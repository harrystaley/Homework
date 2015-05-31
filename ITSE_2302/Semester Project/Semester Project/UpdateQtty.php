<?php
    session_start();
    $host="localhost"; // Host name 
    $username="Fred"; // Mysql username 
    $password="Farmer#Fred."; // Mysql password 
    $db_name="FredBiz"; // Database name 
    $tbl_name="halloween"; // Table name
    $item = "description";

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
                <td>
                    <table>
                        <tr>
                            <td colspan="3" align="center"><strong>Items for Sale</strong></td>
                        </tr>
                        <tr>
                            <td>Item Id</td>
                            <td>Item Qty.</td>
                            <td>Item Desc.</td>
                            <td>Item Weight (Lbs.)</td>
                        </tr>
                            <?php
                                // connect for the database using the column name selected in DescSelect.php
                                $column = "description";
                                $sql= "SELECT * FROM $tbl_name ORDER BY $tbl_name.`description` ASC ,`weight` ASC";
                                $result=mysqli_query($con,$sql);
                                
                                // Start while loop to get item types
                                while ($row = mysqli_fetch_assoc($result)){
                                    $ItemId = $row['id'];
                                    $ItemQty = $row['qty'];
                                    $ItemDesc = $row['description'];
                                    $ItemWeight = $row['weight'];
                            
                                    echo "
                                        <tr align='center'>
                                            <td>$ItemId</td>
                                            <td>$ItemQty</td>
                                            <td>$ItemDesc</td>
                                            <td>$ItemWeight</td>
                                        </tr>
                                        ";
                                } //end while loop 
                            ?>
                    </table>
                </td>
            </tr>
            <tr>
                <form name="DataUpdateForm" method="post" action="InvAdd.php">
                <td>
                    <table>
                        <tr>
                            <td colspan="2"><strong>Add Inventory</strong></td>
                        </tr>
                        <tr>
                            <td>Item Qty.</td>
                            <td><input name="ItemQty" type="text" id="ItemQty"></td>
                        </tr>
                        <tr>
                            <td>Item Desc.</td>
                            <td><input name="ItemDesc" type="text" id="ItemDesc"></td>
                        </tr>
                        <tr>
                            <td>Item Weight (Lbs.)</td>
                            <td><input name="ItemWeight" type="text" id="ItemWeight"></td>
                        </tr>
                        <tr>
                            <td><input type="submit" name="Submit" value="Add Inventory"></td>
                        </tr>
                    </table>
                </td>
                </form> 
            </tr>
            <tr>
                <form name="DataUpdateForm" method="post" action="InvUpd.php">
                <td>
                    <table>
                        <tr>
                            <td colspan="2"><strong>Update Inventory</strong></td>
                        </tr>
                        <tr>
                            <td>Item Id</td>
                            <td>
                                <?php
                                    $sql= "SELECT id FROM $tbl_name ORDER BY $tbl_name.`id` ASC";
                                    $result=mysqli_query($con,$sql);
                                    echo "<select name=ItemId value=''>Item Id</option>";
                                    while ($row = mysqli_fetch_assoc($result)){
                                        $ItemId = $row['id'];
                                        echo "<option value='$ItemId'>$ItemId</option>"; 
                                    }
                                    echo "</select>";
                                ?>
                            </td>
                        </tr>
                        <tr>
                            <td>Item Qty.</td>
                            <td><input name="ItemQty" type="number" id="ItemQty"></td>
                        </tr>
                        <tr>
                            <td>Item Desc.</td>
                            <td><input name="ItemDesc" type="text" id="ItemDesc"></td>
                        </tr>
                        <tr>
                            <td>Item Weight (Lbs.)</td>
                            <td><input name="ItemWeight" type="number" id="ItemWeight"></td>
                        </tr>
                        <tr>
                            <td><input type="submit" name="Submit" value="Update"></td>
                        </tr>
                    </table>
                </td>
                </form> 
            </tr>
            <tr>
                <form name="DataUpdateForm" method="post" action="InvDel.php">
                <td>
                    <table>
                        <tr>
                            <td colspan="2"><strong>Remove Inventory</strong></td>
                        </tr>
                        <tr>
                            <td>Item Id</td>
                            <td>
                                <?php
                                    $sql= "SELECT id FROM $tbl_name ORDER BY $tbl_name.`id` ASC";
                                    $result=mysqli_query($con,$sql);
                                    echo "<select name=ItemId value=''>Item Id</option>";
                                    while ($row = mysqli_fetch_assoc($result)){
                                        $ItemId = $row['id'];
                                        echo "<option value='$ItemId'>$ItemId</option>"; 
                                   }
                                    echo "</select>";
                                ?>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="submit" name="Submit" value="Delete Inventory"></td>
                        </tr>
                    </table>
                </td>
                </form> 
            </tr>
            <tr>
                <td>
                    <a href="DescSelect.php">Select a different item to display</a>
                </td>
            </tr>
        </table>
    </body>
</html>