<html>
    <head>
        <title>Database Creation</title>
    </head> 
    <body> 
        
        <p>
            <h1>Database Creation</h1>
        </p>
        <p>
            <p><a href ="Conference_Personal.php">Start Conference Input</a></p>
        </p>
        

<?php
session_start();

//chect to see if all datapoints have been entered
if (isset($_SESSION['p_FName']) && isset($_SESSION['p_LName']) &&  
    isset($_SESSION['p_Address']) && isset($_SESSION['p_City']) &&  
    isset($_SESSION['p_State']) && isset($_SESSION['p_Zip']) &&  
    isset($_SESSION['p_Phone']) && isset($_SESSION['p_Email'])) {
    $P_Data_Missing = "False";
}
else {
    $P_Data_Missing = "True";
    echo "<p>";
    echo     "<p>Please navigate back to finish your application at the link below.<br>";
    echo     "<a href ='Conference_Personal.php'>Personal Conference Form</a></p>";
    echo "</p>";
}

if (isset($_SESSION['c_Name']) && isset($_SESSION['c_Address']) &&   
    isset($_SESSION['c_City']) && isset($_SESSION['c_State']) &&  
    isset($_SESSION['c_Zip']) && isset($_SESSION['c_Phone'])) {
    $C_Data_Missing = "False";
}
else{
     $C_Data_Missing = "True";
    echo "<p>";
    echo     "<p>Please navigate back to finish your application at the link below.<br>";
    echo     "<a href ='Conference_Company.php'>Company Conference Form</a></p>";
    echo "</p>";
}




    //Begain database creation
    $servername = "localhost";
    $username = "root";
    $password = "";
    $dbname = "Registration";
    $tblname = "Reg";

    // Create connection
    $conn = new mysqli($servername, $username, $password);
    // Check connection
    if ($conn->connect_error) {
        die("<br>Connection failed: " . $conn->connect_error);
    } 
    
    // Create database
    $sql = "CREATE DATABASE ".$dbname;
    if ($conn->query($sql) === TRUE) {
        echo "<br>Created Registration database.";
    } else {
        echo "<br>Error creating database: " . $conn->error;
    }
    $conn->close(); // close the connection

    // Create connection to the newly created Registration database
    $conn = new mysqli($servername, $username, $password, $dbname);
    // Check connection
    if ($conn->connect_error) {
        die("<br>Connection failed: " . $conn->connect_error);
    }
    
    // sql to create table
    $sql = "CREATE TABLE ".$tblname." (
    Personal_FName VARCHAR(20) NOT NULL,
    Personal_LName VARCHAR(20) NOT NULL,
    Personal_Address VARCHAR(40) NOT NULL,
    Personal_City VARCHAR(20) NOT NULL,
    Personal_State VARCHAR(2) NOT NULL,
    Personal_Zip VARCHAR(5) NOT NULL,
    Personal_Phone VARCHAR(12) NOT NULL,
    Personal_Email VARCHAR(40) NOT NULL ,
    Company_Name VARCHAR(20) NOT NULL,
    Company_Address VARCHAR(40) NOT NULL,
    Company_City VARCHAR(20) NOT NULL,
    Company_State VARCHAR(2) NOT NULL,
    Company_Zip VARCHAR(5) NOT NULL,
    Company_Phone VARCHAR(12) NOT NULL,
    Seminar_JS VARCHAR(3) NOT NULL,
    Seminar_PHP VARCHAR(3) NOT NULL,
    Seminar_AP VARCHAR(3) NOT NULL,
    Seminar_MySQL VARCHAR(3) NOT NULL,
    Seminar_Web VARCHAR(3) NOT NULL,
    UNIQUE (Personal_Email)
    )";
    
    if ($conn->query($sql) === TRUE) {
        echo "<br>Table ".$tblname." created successfully";
    } else {
        echo "<br>Error creating table: " . $conn->error;
    }

//double check to see if not mandatory data is missing
if ($P_Data_Missing == "False" && $C_Data_Missing == "False") {
    
    $sql = "INSERT INTO ".$tblname." 
    VALUES ( '".
        $_SESSION['p_FName']."', '".
        $_SESSION['p_LName']."', '". 
        $_SESSION['p_Address']."', '". 
        $_SESSION['p_City']."', '". 
        $_SESSION['p_State']."', '". 
        $_SESSION['p_Zip']."', '". 
        $_SESSION['p_Phone']."', '". 
        $_SESSION['p_Email']."', '".
        $_SESSION['c_Name']."', '". 
        $_SESSION['c_Address']."', '".  
        $_SESSION['c_City']."', '". 
        $_SESSION['c_State']."', '". 
        $_SESSION['c_Zip']."', '". 
        $_SESSION['c_Phone']."', '".
        $_SESSION['s_JavaScript']."', '".
        $_SESSION['s_PHP']."', '".
        $_SESSION['s_MySQL']."', '".
        $_SESSION['s_Apache']."', '".
        $_SESSION['s_WebServices'].
    "');";
    
    if ($conn->query($sql) === TRUE) {
        echo "<br>A record has been created in ".$tblname." table successfully";
    } else {
        echo "<br>Error creating record: " . $conn->error;
    }
}
/* The below code was written to create a more dynamic database.
However I thought that this assignment is already late and that functionality
would be a bit overkill. Never the less in order to implement I would need a 
bridgin table for the many to many relationships, not to mention much more
complex isert and update querie logic.
*/

/*

$tblname = "Personal"
// sql to create table
$sql = "CREATE TABLE ".$tblname." (
Personal_Id MEDIUMINT NOT NULL AUTO_INCREMENT,
Personal_FName VARCHAR(20) NOT NULL,
Personal_LName VARCHAR(20) NOT NULL,
Personal_Address VARCHAR(40) NOT NULL,
Personal_City VARCHAR(20) NOT NULL,
Personal_State VARCHAR(2) NOT NULL,
Personal_Zip VARCHAR(5) NOT NULL,
Personal_Phone VARCHAR(12) NOT NULL,
Personal_Email VARCHAR(40) NOT NULL,
Company_Id MEDIUMINT NOT NULL,

PRIMARY KEY (Personal_Id)
)";

if ($conn->query($sql) === TRUE) {
    echo "<br>Table ".$tblname." created successfully";
} else {
    echo "<br>Error creating table: " . $conn->error;
}


$tblname = "Companies"
// sql to create table
$sql = "CREATE TABLE ".$tblname." (
Company_Id MEDIUMINT NOT NULL AUTO_INCREMENT,
Company_Name VARCHAR(20) NOT NULL,
Company_Address VARCHAR(40) NOT NULL,
Company_City VARCHAR(20) NOT NULL,
Company_State VARCHAR(2) NOT NULL,
Company_Zip VARCHAR(5) NOT NULL,
Company_Phone VARCHAR(12) NOT NULL,
Personal_Id MEDIUMINT NOT NULL,
Seminar_Id MEDIUMINT NOT NULL,
PRIMARY KEY (Company_Id)
)";

if ($conn->query($sql) === TRUE) {
    echo "<br>Table ".$tblname." created successfully";
} else {
    echo "<br>Error creating table: " . $conn->error;
}

$tblname = "Seminars"
// sql to create table
$sql = "CREATE TABLE ".$tblname." (
Seminar_Id MEDIUMINT NOT NULL AUTO_INCREMENT,
Seminar_Name VARCHAR(20) NOT NULL,
Company_Id MEDIUMINT NOT NULL,
Personal_Id MEDIUMINT NOT NULL,
PRIMARY KEY (Seminar_Id)
)";

if ($conn->query($sql) === TRUE) {
    echo "<br>Table ".$tblname." created successfully";
} else {
    echo "<br>Error creating table: " . $conn->error;
}
*/

$conn->close(); // close the connection
?>
</body> 
</html>