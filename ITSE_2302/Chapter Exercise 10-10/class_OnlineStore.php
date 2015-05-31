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

}
?>
