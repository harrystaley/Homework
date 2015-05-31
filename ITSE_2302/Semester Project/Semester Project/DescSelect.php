<?php
    session_start();
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
    
    
    
?>

<html>
    <head>
        <title> Fred’s Market Biz Item Type Select</title>
        <link rel="stylesheet" type="text/css" href="Style.css" />
        <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
    </head>
    <body>
        <?php
            echo "You are currently logged in as ".$_SESSION['myusername'];    
        ?>
        
        <!-- Logout button -->
        <form name="LoginForm" method="post" action="Logout.php">
            <input type="submit" name="Submit" value="Logout">
        </form>
        
        <h1>Fred's Market Biz</h1>
        <table>
            <tr>
                <form name="ItemSelect" method="post" action="QttySelect.php">
                <td>
                    <table>
                        <tr>
                            <td colspan="2"><strong>Items for Sale</strong></td>
                        </tr>
                        <tr>
                            <td>
                                <?php
                                    // connect for the database
                                    $column = "description";
                                    $sql= "SELECT DISTINCT $column FROM $tbl_name";
                                    $result=mysqli_query($con,$sql);

                                    // Start while loop to get item types
                                    while ($row = mysqli_fetch_array($result)){
                                        $ItemName = $row[$column];
                                ?>    
                                        <input type="radio" value="<?php echo $ItemName; ?>" name='description'><?php echo $ItemName; ?><br> 
                                <?php  } //end while loop ?>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="submit" name="Submit" value="Submit"></td>
                        </tr>
                    </table>
                </td>
                </form>
                <tr>
                <td>
                    <a href="UpdateQtty.php">Update Inventory</a>
                </td>
            </tr>
            </tr>
        </table>
    </body>
</html>
<?php
    // close the sql connection
    mysqli_close($con);
?>

