<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Assignment Examples</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
</head>
<body>
<?php
$ChangingVar = 100;
$ChangingVar += 50;
echo "<p>";
echo "Variable after addition assignment = 
     $ChangingVar<br />";
$ChangingVar -= 30;
echo "Variable after subtraction assignment = 
     $ChangingVar<br />";
$ChangingVar /= 3;
echo "Variable after division assignment = 
     $ChangingVar<br />";
$ChangingVar *= 8;
echo "Variable after multiplication assignment = 
     $ChangingVar<br />";
$ChangingVar %= 300;
echo "Variable after modulus assignment = 
     $ChangingVar</p>";

?>
</body>
</html>

