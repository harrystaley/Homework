<?php
$ErrorMsgs = array();
$DBConnect = new mysqli("host", "user", "password", 
     "online_stores");
if (!$DBConnect)
   $ErrorMsgs[] = "The database server is not available.";
?>

