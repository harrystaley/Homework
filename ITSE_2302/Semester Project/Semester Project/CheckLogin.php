<?php
session_start();
$host="localhost"; // Host name 
$username="Fred"; // Mysql username 
$password="Farmer#Fred."; // Mysql password 
$db_name="FredBiz"; // Database name 
$tbl_name="users"; // Table name
$_SESSION['LoginFail'] ="False"; //login failure sentinel value

// Connect to server and select databse.
$con = mysqli_connect("$host", "$username", "$password", "$db_name")or die("cannot connect"); 

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


$encrypted_mypassword=md5($mypassword);
$sql="SELECT * FROM $tbl_name WHERE username='$myusername' and password='$encrypted_mypassword'";
$result=mysqli_query($con,$sql);

// Mysql_num_row is counting table row
$count=mysqli_num_rows($result);

// If result matched $myusername and $mypassword, table row must be 1 row
if($count==1){
    
    // Register $myusername, $mypassword and redirect to file "login_success.php"
    $_SESSION['myusername'] = $myusername;
    $_SESSION['mypassword'] = $encrypted_mypassword; 
    $_SESSION['LoginBool'] = "False";
    header("location:DescSelect.php");
    }
    else {
        $_SESSION['LoginFail'] = "True";
    header("location:LoginPage.php");
}
mysqli_close($con);
?>