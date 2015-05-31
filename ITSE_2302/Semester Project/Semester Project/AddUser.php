<?php

$host="localhost"; // Host name 
$username="Fred"; // Mysql username 
$password="Farmer#Fred."; // Mysql password 
$db_name="FredBiz"; // Database name 
$tbl_name="users"; // Table name 

// Connect to server and select databse.
$con = mysqli_connect("$host", "$username", "$password", "$db_name") or die("cannot connect"); 

// Check connection
if (mysqli_connect_errno())
  {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
  }

// username and password sent from form 
$myusername=$_POST['myusername']; 
$mypassword=$_POST['mypassword']; 

// To protect MySQL injection (more detail about MySQL injection)
$myusername = stripslashes($myusername);
$mypassword = stripslashes($mypassword);
$myusername = mysql_real_escape_string($myusername);
$mypassword = mysql_real_escape_string($mypassword);

// encrypt password using MD5 hash
$encrypted_mypassword=md5($mypassword);

$sql="INSERT INTO $tbl_name (username, password) VALUES ('$myusername', '$encrypted_mypassword')";
$result=mysqli_query($con,$sql);

$sql="SELECT * FROM $tbl_name WHERE username='$myusername' and password='$encrypted_mypassword'";
$result=mysqli_query($con,$sql);

// Mysql_num_row is counting table row
$count=mysqli_num_rows($result);

// If result matched $myusername and $mypassword, table row must be 1 row
if($count==1){
    $Message= $myusername." you account was created successfully <br> Click your brownsers back button to login";
}
else {
    $Message= "User was not registered";
}

mysqli_close($con);
?>


<html>
    <head>
        <title> Fred’s Market Biz Login </title>
        <link rel="stylesheet" type="text/css" href="Style.css" />
        <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
    </head>
    <body>
        <?php
            echo $Message;
        ?>
    </body>
</html>

