<?php
    session_start();
    $host="localhost"; // Host name 
    $username="Fred"; // Mysql username 
    $password="Farmer#Fred."; // Mysql password 
    $db_name="FredBiz"; // Database name 
    $tbl_name="halloween"; // Table name
    $item = $_POST['description'];

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
        <title> Fred’s Market Biz Update Inventory</title>
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
                <td>
                    <table>
                        <tr>
                            <td colspan="3" align="center"><strong>Update Inventory</strong></td>
                        </tr>
                        <tr>
                            <td>Item Id</td>
                            <td>Item Description</td>
                            <td>Item Qty.</td>
                            <td>Item Weight (Lbs.)</td>
                        </tr>
                            <?php
                                // connect for the database using the column name selected in DescSelect.php
                                $column = "description";
                                $sql= "SELECT * FROM $tbl_name WHERE $column = '$item'";
                                $result=mysqli_query($con,$sql);
                                
                                // Start while loop to get item types
                                while ($row = mysqli_fetch_assoc($result)){
                                    $ItemId = $row['id'];
                                    $ItemQty = $row['qty'];
                                    $ItemWeight = $row['weight'];
                            
                                    echo "
                                        <tr align='center'>
                                            <td>$ItemId</td>
                                            <td>$ItemQty</td>
                                            <td>$ItemWeight</td>
                                        </tr>
                                        ";
                                } //end while loop 
                            ?>
                    </table>
                </td>
            </tr>
            <tr>
                <td>
                    <a href="DescSelect.php">Select a different item.</a>
                </td>
            </tr>
            <tr>
                <td>
                    <a href="UpdateQtty.php">Update Inventory</a>
                </td>
            </tr>
        </table>
    </body>
</html>
