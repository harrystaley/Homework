<?php
session_start();
?>
<html>
    <head>
        <title>Professional Conference - Seminar Info</title>
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
                <td><h3>Seminar Info</h3></td>
            </tr>
            <tr>
                <p><a href ="Conference_Summary.php">Conference Summary</a></p>
            </tr>
        </table>
        <hr />
	
	   <form method="post" action="Conference_TempData.php">
	       <p>
                <input type="reset" value="Reset Form"/>
                <input type="submit" value="Continue and Review All Info" />
           </p>
                <input type="checkbox" name="JavaScript" id="JavaScript" value="Yes"
                
                    <?php 
                        if (isset($_SESSION["s_JavaScript"]) && $_SESSION["s_JavaScript"] == "Yes"){
                          echo 'checked="checked"';
                        }
                    ?>
                       /> Java Script<br>
                <input type="checkbox" name="PHP" id="PHP" value="Yes" 
                    <?php 
                        if(isset($_SESSION["s_PHP"]) && $_SESSION["s_PHP"] == "Yes"){
                            echo 'checked="checked"';
                        }
                    ?>
                       />PHP<br>
                <input type="checkbox" name="MySQL" id="MySQL" value="Yes"
                    <?php 
                        if(isset($_SESSION["s_MySQL"]) && $_SESSION["s_MySQL"] == "Yes"){
                            echo 'checked="checked"';
                        }
                    ?>
                    />MySQL<br>   
                <input type="checkbox" name="Apache" id="Apache" value="Yes" 
                    <?php 
                        if(isset($_SESSION["s_Apache"]) && $_SESSION["s_Apache"] == "Yes"){
                            echo 'checked="checked"';
                        }
                    ?>
                    />Apache<br>   
                <input type="checkbox" name="WebServices" id="WebServices" value="Yes"
                    <?php 
                        if(isset($_SESSION["s_WebServices"]) && $_SESSION["s_WebServices"] == "Yes"){
                            echo 'checked="checked"';
                        }
                    ?>
                    />Web Services<br>
           <p>
                <input type="hidden" name="InputPage" value="Seminars">
                <input type="reset" value="Reset Form" />
                <input type="submit" value="Continue and Review All Info" /><br> 
            </p>
	   </form>
        <form method="post" action="Conference_TempData.php">
            <input type="hidden" name="InputPage" value="Reset">
            <input type="submit" value="Start Over" /><br>
        </form>
    </body>
</html>
