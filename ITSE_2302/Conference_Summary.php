<?php
session_start();
?>
<html>
    <head>
        <title>Professional Conference - Summary</title>
        <meta http-equiv="Content-Type"
          content="text/html; charset=iso-8859-1" />
    </head>
    <body>
        <table>
           <tr>
            </tr>
            <tr>
                <td><h1>Professional Conference</h1></td>
            </tr>
            <tr>
                <td><h3>Registration Overview</h3></td>
            </tr>
        </table>
        <hr />
	
        <table>
           <tr>
            </tr>
            <tr>
                <td><a href ="Conference_Personal.php">Personal Info</a></td>
                <td><a href ="Conference_Company.php">Company Info</a></td>
                <td><a href ="Conference_Seminars.php">Seminar Info</a></td>
            </tr>
            <tr valign="top">
                <td>
                    <?php
                        if (isset($_SESSION["p_FName"])){
                            echo "First Name: ".$_SESSION["p_FName"]."<br>";
                         }
                        else {
                            echo "First Name: <br>";
                        }
                        if (isset($_SESSION["p_LName"])){
                            echo "Last Name: ".$_SESSION["p_LName"]."<br>";
                        }
                        else {
                             echo "Last Name: <br>";
                        }
                         if (isset($_SESSION["p_Address"])){
                            echo "Address: ".$_SESSION["p_Address"]."<br>";
                        }
                        else {
                            echo "Address: <br>";
                        }
                        if (isset($_SESSION["p_City"])){
                            echo "City: ".$_SESSION["p_City"]."<br>";
                        }
                        else {
                            echo "City: <br>";
                        }
                        if (isset($_SESSION["p_State"])){
                            echo "State: ".$_SESSION["p_State"]."<br>";
                        }
                        else {
                            echo "State: <br>";
                        }
                        if (isset($_SESSION["p_Zip"])){
                            echo "Zip: ".$_SESSION["p_Zip"]."<br>";
                        }
                        else {
                             echo "Zip: <br>";
                        }
                        if (isset($_SESSION["p_Phone"])){
                            echo "Phone: ".$_SESSION["p_Phone"]."<br>";
                        }
                        else {
                            echo "Phone: <br>";
                        }
                        if (isset($_SESSION["p_Email"])){
                            echo "Email: ".$_SESSION["p_Email"]."<br>";
                        }
                        else {
                            echo "Email: <br>";
                        }
                    ?>
                </td>
                <td>
                    <?php
                        if (isset($_SESSION["c_Name"])){
                            echo "Name: ".$_SESSION["c_Name"]."<br>";
                        }
                        else {
                            echo "Name: <br>";
                        }
                        if (isset($_SESSION["c_Address"])){
                            echo "Address: ".$_SESSION["c_Address"]."<br>";
                        }
                        else {
                            echo "Address: <br>";
                        }   
                        if (isset($_SESSION["c_City"])){
                            echo "City: ".$_SESSION["c_City"]."<br>";
                         }
                        else {
                            echo "City: <br>";
                        }                           
                        if (isset($_SESSION["c_State"])){
                            echo "State: ".$_SESSION["c_State"]."<br>";
                         }
                        else {
                            echo "State: <br>";
                        }   
                        if (isset($_SESSION["c_Zip"])){
                            echo "Zip: ".$_SESSION["c_Zip"]."<br>";
                         }
                        else {
                            echo "Zip: <br>";
                        }   
                        if (isset($_SESSION["c_Phone"])){
                            echo "Phone: ".$_SESSION["c_Phone"]."<br>";
                         }
                        else {
                            echo "Phone: <br>";
                        }   
                    ?>
                </td>
                <td>
                    <?php
                        if (isset($_SESSION["s_JavaScript"])){
                            echo "Java Script: ".$_SESSION["s_JavaScript"]."<br>";
                         }
                        if (isset($_SESSION["s_PHP"])){
                            echo "PHP : ".$_SESSION["s_PHP"]."<br>";
                         }
                        if (isset($_SESSION["s_MySQL"])){
                            echo "MySQL : ".$_SESSION["s_MySQL"]."<br>";
                         }
                        if (isset($_SESSION["s_Apache"])){
                            echo "Apache : ".$_SESSION["s_Apache"]."<br>";
                         }
                        if (isset($_SESSION["s_WebServices"])){
                            echo "Web Services : ".$_SESSION["s_WebServices"]."<br>";
                         }
                    ?>
                </td>
            </tr>
            <tr>
            </tr>
        </table>
        <form method="post" action="conference_CreateDB.php">
            <input type="submit" value="Register" /><br>
        </form>
        <form method="post" action="Conference_TempData.php">
            <input type="hidden" name="InputPage" value="Reset">
            <input type="submit" value="Start Over" /><br>
        </form>
        
        
        
	   
    </body>
</html>

