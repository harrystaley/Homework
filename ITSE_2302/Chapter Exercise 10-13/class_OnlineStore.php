<?php
class OnlineStore {
     private $DBConnect = NULL;
     private $storeID = "";
     private $Order = array();

     function __construct() {
          include("inc_OnlineStoreDB.php");
          $this->DBConnect = $DBConnect;
     }
     
     function __destruct() {
          if (!$this->DBConnect->connect_error)
               $this->DBConnect->close();
     }

     public function setStoreID($storeID) {
        if ($this->storeID != $storeID) {
               $this->storeID = $storeID;
               $SQLString = "SELECT * FROM inventory " .
                         " where storeID = '" . 
                         $this->storeID . "'";
               $QueryResult = @$this->DBConnect->query($SQLString);
               if ($QueryResult === FALSE) {
                    $this->storeID = "";
               }
               else {
                    $this->inventory = array();
                    $this->shoppingCart = array();
                    while (($Row = $QueryResult->fetch_assoc()) 
                              !== NULL) {
                         $this->inventory[$Row['productID']] = array();
                         $this->inventory[$Row['productID']]['name']
                                   = $Row['name'];
                         $this->inventory[$Row['productID']]['description'] 
                                   = $Row['description'];
                         $this->inventory[$Row['productID']]['price'] = 
                                   $Row['price'];
                         $this->shoppingCart[$Row['productID']] = 0;
                    }
               }
          }
     }
     
     public function getStoreInformation() {
          $retval = FALSE;
          if ($this->storeID != "") {
               $SQLString = "SELECT * FROM store_info " .
                         " where storeID = '" . 
                         $this->storeID . "'";
               $QueryResult = @$this->DBConnect->query($SQLString);
               if ($QueryResult !== FALSE) {
                    $retval = $QueryResult->fetch_assoc();
               }
          }
          return($retval);
     }
     
     public function getProductList() {
          $retval = FALSE;
          $subtotal = 0;
           
          if (count($this->inventory) > 0) {
               echo "<table width='100%'>\n";
               echo "<tr><th>Product</th><th>Description</th>" .
                    "<th>Price Each</th><th># in Cart</th>" .
                    "<th>Total Price</th><th>&nbsp;</th></tr>\n";
               foreach ($this->inventory as $ID => $Info) {
                    echo "<tr><td>" . htmlentities($Info['name'])
                         . "</td>\n";
                    echo "<td>" .
                         htmlentities($Info['description']) . 
                         "</td>\n";
                    printf("<td class='currency'>$%.2f</td>\n", 
                         $Info['price']);
                    echo "<td class='currency'>" . 
                         $this->shoppingCart[$ID] . "</td>\n";
                    printf("<td class='currency'>$%.2f</td>\n", 
                         $Info['price'] * $this->shoppingCart[$ID]);
                    echo "<td><a href='" . $_SERVER['SCRIPT_NAME'] . 
                         "?PHPSESSID=" . session_id() . 
                         "&ItemToAdd=$ID'>Add " .
                         " Item</a></td>\n";
                    $subtotal += ($Info['price'] * 
                         $this->shoppingCart[$ID]);
               }
               echo "<tr><td colspan='4'>Subtotal</td>\n";
               printf("<td class='currency'>$%.2f</td>\n", 
                    $subtotal);
               echo "<td>&nbsp;</td></tr>\n";
               echo "</table>";
               $retval = TRUE;
          }
          return($retval);
     }
     
     public function addItem() {
          $ProdID = $_GET['ItemToAdd'];
          if (array_key_exists($ProdID, $this->shoppingCart))
               $this->shoppingCart[$ProdID] += 1;
     }
     
     function __wakeup() {
          include("inc_OnlineStoreDB.php");
          $this->DBConnect = $DBConnect;
     }

}
?>
