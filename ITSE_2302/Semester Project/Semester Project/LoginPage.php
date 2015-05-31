<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Fred's Market Biz</title>
        <link rel="stylesheet" type="text/css" href="Style.css" />
        <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
    </head>
    <body>
        <h1>Fred's Market Biz </h1>
        <table>
            <tr>
                <form name="LoginForm" method="post" action="CheckLogin.php">
                <td>
                    <table>
                        <tr>
                            <td colspan="2"><strong>Login</strong></td>
                        </tr>
                        <?php
                            session_start();
                            if(isset($_SESSION['LoginFail'])){
                                if($_SESSION['LoginFail'] == "True"){
                                echo "<tr>
                                        <td colspan='2'><strong>Login Failed</strong></td>
                                    </tr>";
                                }
                            }
                        ?>
                        <tr>
                            <td>Username</td>
                            <td><input name="myusername" type="text" id="myusername"></td>
                        </tr>
                        <tr>
                        <td>Password</td>
                            <td><input name="mypassword" type="password" id="mypassword"></td>
                        </tr>
                        <tr>
                            <td><input type="submit" name="Submit" value="Login"></td>
                        </tr>
                    </table>
                </td>
                </form>
            </tr>
            <tr>
                <form name="RegisterForm" method="post" action="AddUser.php">
                <td>
                    <table>
                        <tr>
                            <td colspan="2"><strong>Register</strong></td>
                        </tr>
                        <tr>
                            <td>Username</td>
                            <td><input name="myusername" type="text" id="myusername"></td>
                        </tr>
                        <tr>
                        <td>Password</td>
                            <td><input name="mypassword" type="password" id="mypassword"></td>
                        </tr>
                        <tr>
                            <td><input type="submit" name="Submit" value="Register"></td>
                        </tr>
                    </table>
                </td>
                </form>
            </tr>
        </table>
    </body>
</html>