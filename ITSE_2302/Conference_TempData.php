<?php
    session_start();
    if(!empty($_POST)){
        switch($_POST['InputPage']) {
            case "Personal" :
                $_SESSION["p_FName"] = $_POST['p_FName'];
                $_SESSION["p_LName"] = $_POST['p_LName'];
                $_SESSION["p_Address"] =$_POST['p_Address'];
                $_SESSION["p_City"] =$_POST['p_City'];
                $_SESSION["p_State"] =$_POST['p_State'];
                $_SESSION["p_Zip"] =$_POST['p_Zip'];
                $_SESSION["p_Phone"] =$_POST['p_Phone'];
                $_SESSION["p_Email"] =$_POST['p_Email'];
                echo "Personal info saved.";
                header("Location: Conference_Company.php");
                break;
            case "Company" :
                $_SESSION["c_Name"] = $_POST['c_Name'];
                $_SESSION["c_Address"] =$_POST['c_Address'];
                $_SESSION["c_City"] =$_POST['c_City'];
                $_SESSION["c_State"] =$_POST['c_State'];
                $_SESSION["c_Zip"] =$_POST['c_Zip'];
                $_SESSION["c_Phone"] =$_POST['c_Phone'];
                echo "Company info saved.";
                header("Location: Conference_Seminars.php");
                break;
            case "Seminars" :
                $_SESSION["s_JavaScript"] = isset($_POST["JavaScript"]) ? $_POST["JavaScript"] : "No";
                $_SESSION["s_PHP"] = isset($_POST["PHP"]) ? $_POST["PHP"] : "No";
                $_SESSION["s_MySQL"] = isset($_POST["MySQL"]) ? $_POST["MySQL"] : "No";
                $_SESSION["s_Apache"] = isset($_POST["Apache"]) ? $_POST["Apache"] : "No";
                $_SESSION["s_WebServices"] = isset($_POST["WebServices"]) ? $_POST["WebServices"] : "No";                    
                header("Location: Conference_Summary.php");
                echo "Seminar info saved.";
                break;
            case "Reset" :
                session_unset();
                echo "All data has been resent and starting over.";
                header("Location: Conference_Personal.php");
                break;
            case "": 
                
                break;
            default:
                echo "ERROR: The page that you are submitting input from is not recognized.";
        } // end switch for data creation
    } // end if to check if data was passed via post.
    
?>