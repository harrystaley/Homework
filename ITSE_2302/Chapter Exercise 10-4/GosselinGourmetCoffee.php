<?php
require_once("inc_OnlineStoreDB.php");
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Gosselin's Gourmet Coffee</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
</head>
<body>
<h1>Gosselin's Gourmet Coffee</h1>
<h2>Description goes here</h2>
<p>Welcome message goes here</p>
<p>Inventory goes here</p>
<?php
if (count($ErrorMsgs)) {
     foreach ($ErrorMsgs as $Msg) 
          echo "<p>" . $Msg . "</p>\n";
}
?>
</body>
</html>
<?php
if (!$DBConnect->connect_error)
     $DBConnect->close();
?>

