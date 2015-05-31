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
    $ItemQty = $_POST['ItemQty']; 
    $ItemDesc = $_POST['ItemDesc'];
    $ItemWeight = $_POST['ItemWeight'];


    // To protect MySQL injection (more detail about MySQL injection)
    $ItemId = stripslashes($ItemId);
    $ItemQty = stripslashes($ItemQty);
    $ItemDesc = stripslashes($ItemDesc);
    $ItemWeight = stripslashes($ItemWeight);
    $ItemId = mysql_real_escape_string($ItemId);
    $ItemQty = mysql_real_escape_string($ItemQty);
    $ItemDesc = mysql_real_escape_string($ItemDesc);
    $ItemWeight = mysql_real_escape_string($ItemWeight);

    $sql="UPDATE $tbl_name SET qty=$ItemQty, description='$ItemDesc', weight=$ItemWeight WHERE id=$ItemId";
    if (mysqli_query($con,$sql)) {
        echo "New record created successfully";
        header("location:UpdateQtty.php");
    } else {
        echo "Error: " . $sql . "<br>" . mysqli_error($con);
    }

    mysqli_close($con);
?>