<?php
session_start();
?>
<html>
    <head>
        <title>Professional Conference - Personal Info</title>
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
                <td><h3>Personal Info</h3></td>
            </tr>
            <tr>
                <p><a href ="Conference_Summary.php">Conference Summary</a></p>
            </tr>
        </table>
        <hr />
	
	   <form method="post" id="p_Info" action="Conference_TempData.php">
	       <p>
                <input type="reset" value="Reset Form"/>
                <input type="submit" value="Continue to Company Info" />
            </p>
           <p>First Name:
                <input type="text" size="20" maxlength="20" name="p_FName" id="p_FName" required 
                    value= "<?php 
                                if(isset($_SESSION['p_FName'])){
                                   echo $_SESSION['p_FName'];
                                }
                           ?>"
                />
            Last Name:
                <input type="text" size="20" maxlength="20" name="p_LName" id="p_LName" required 
                    value= "<?php 
                                if(isset($_SESSION['p_LName'])){
                                   echo $_SESSION['p_LName'];
                                }
                            ?>"
                />
           </p>
          <p>Address:
                <input type="text" size="40" maxlength="40" name="p_Address" id="p_Address" required 
                    value= "<?php 
                                if(isset($_SESSION['p_Address'])){
                                   echo $_SESSION['p_Address'];
                                }
                            ?>"
                />
           </p>
           <p>City:
                <input type="text" size="20" maxlength="20" name="p_City" id="p_City" required 
                    value= "<?php 
                                if(isset($_SESSION['p_City'])){
                                   echo  $_SESSION['p_City'];
                                }
                            ?>"
                />
           State:
                <select name="p_State" >
                    <option value=
                        "<?php 
                            if(isset($_SESSION['p_State'])){
                                echo $_SESSION['p_State'];
                            }
                        ?>"
                    >
                        <?php 
                            if(isset($_SESSION['p_State'])){
                                echo $_SESSION['p_State'];
                            }
                        ?>                    
                    </option>
                    <option value="AL">AL</option>
                    <option value="AK">AK</option>
                    <option value="AZ">AZ</option>
                    <option value="AR">AR</option>
                    <option value="CA">CA</option>
                    <option value="CO">CO</option>
                    <option value="CT">CT</option>
                    <option value="DE">DE</option>
                    <option value="DC">DC</option>
                    <option value="FL">FL</option>
                    <option value="GA">GA</option>
                    <option value="HI">HI</option>
                    <option value="ID">ID</option>
                    <option value="IL">IL</option>
                    <option value="IN">IN</option>
                    <option value="IA">IA</option>
                    <option value="KS">KS</option>
                    <option value="KY">KY</option>
                    <option value="LA">LA</option>
                    <option value="ME">ME</option>
                    <option value="MD">MD</option>
                    <option value="MA">MA</option>
                    <option value="MI">MI</option>
                    <option value="MN">MN</option>
                    <option value="MS">MS</option>
                    <option value="MO">MO</option>
                    <option value="MT">MT</option>
                    <option value="NE">NE</option>
                    <option value="NV">NV</option>
                    <option value="NH">NH</option>
                    <option value="NJ">NJ</option>
                    <option value="NM">NM</option>
                    <option value="NY">NY</option>
                    <option value="NC">NC</option>
                    <option value="ND">ND</option>
                    <option value="OH">OH</option>
                    <option value="OK">OK</option>
                    <option value="OR">OR</option>
                    <option value="PA">PA</option>
                    <option value="RI">RI</option>
                    <option value="SC">SC</option>
                    <option value="SD">SD</option>
                    <option value="TN">TN</option>
                    <option value="TX">TX</option>
                    <option value="UT">UT</option>
                    <option value="VT">VT</option>
                    <option value="VA">VA</option>
                    <option value="WA">WA</option>
                    <option value="WV">WV</option>
                    <option value="WI">WI</option>
                    <option value="WY">WY</option>
                </select>
            ZIP:
                <input type="text" size="5" maxlength="5" pattern="[0-9]{5}" name="p_Zip" id="p_Zip" required 
                    value= "<?php 
                                if(isset($_SESSION['p_Zip'])){
                                   echo $_SESSION['p_Zip'];
                                }
                            ?>"
                />
           
           </p>
            <p>Phone:
	           <input type="tel" size="12" maxlength="12" name="p_Phone" id="p_Phone"  required 
                    value= "<?php 
                                if(isset($_SESSION['p_Phone'])){
                                   echo $_SESSION['p_Phone'];
                                }
                            ?>"
                />
	       </p>
            <p>Email:
	           <input type="email" size="40" maxlength="40" name="p_Email" id="p_Email"  required 
                    value= "<?php 
                                if(isset($_SESSION["p_Email"])){
                                      echo $_SESSION["p_Email"];
                                }                                    
                            ?>"      
                />
	       </p>
           <p>
                <input type="hidden" name="InputPage" value="Personal">
                <input type="reset" value="Reset Form" />
                <input type="submit" value="Continue to Company Info" /><br> 
            </p>
	   </form>
        <form method="post" action="Conference_TempData.php">
            <input type="hidden" name="InputPage" value="Reset">
            <input type="submit" value="Start Over" /><br>
        </form>
    </body>
</html>
