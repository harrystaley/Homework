<?php
    session_start();
    require_once("class_OnlineStore.php");
    $storeID = $_GET['CheckOut'];
    $storeInfo = array();
    if (class_exists("OnlineStore")) {
        if (isset($_SESSION['currentStore'])) 
            $Store = unserialize($_SESSION['currentStore']);
        else {
            $Store = new OnlineStore();
        }
        $Store->setStoreID($storeID);
        $storeInfo = $Store->getStoreInformation();
    }
    else {
        $ErrorMsgs[] = "The OnlineStore class is not available!";
        $Store = NULL;
    }
?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>
            <?php
                echo $storeInfo['name']; 
            ?>
        </title>
        <link rel="stylesheet" type="text/css" href="
            <?php 
                echo $storeInfo['css_file']; 
            ?>
        " />
    </head>
    <body>
        <h1><?php echo htmlentities($storeInfo['name']); ?></h1>
        <h2>Checkout</h2>
        
        <?php
            $Store-> checkout();
        ?>
    </body>
    
</html>