<?php

    $host="localhost"; // Host name 
    $username="Fred"; // Mysql username 
    $password="Farmer#Fred."; // Mysql password 
    $db_name="FredBiz"; // Database name 
    $tbl_name="halloween"; // Table name

    // Connect to server and select databse.
    $con = mysqli_connect("$host", "$username", "$password", "$db_name")or die("cannot connect"); 

    // Check connection
    if (mysqli_connect_errno())
      {
      echo "Failed to connect to MySQL: " . mysqli_connect_error();
      }

    // data sent from form 
    $ItemId = $_POST['ItemId'];


    // To protect MySQL injection (more detail about MySQL injection)
    $ItemId = stripslashes($ItemId);
    $ItemId = mysql_real_escape_string($ItemId);
    $ItemId = (int)$ItemId;
    
    $sql="DELETE FROM $tbl_name WHERE id=$ItemId";
    if (mysqli_query($con,$sql)) {
        echo "Record removed successfully";
        header("location:UpdateQtty.php");
    } else {
        echo "Error: " . $sql . "<br>" . mysqli_error($con);
    }

    mysqli_close($con);
?>