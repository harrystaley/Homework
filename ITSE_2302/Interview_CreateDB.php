<html>
    <head>
        <title>Database Creation</title>
    </head> 
    <body> 
        
        <p>
            <h1>Database Creation</h1>
        </p>
        <p>
            <p><a href ="Interview_Input.html">Input a new Intervew</a></p>
        </p>
        

<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "HR";
$tblname = "interview";

// Create connection
$conn = new mysqli($servername, $username, $password);
// Check connection
if ($conn->connect_error) {
    die("<br>Connection failed: " . $conn->connect_error);
} 

// Create database
$sql = "CREATE DATABASE ".$dbname;
if ($conn->query($sql) === TRUE) {
    echo "<br>Created HR database.";
} else {
    echo "<br>Error creating database: " . $conn->error;
}
$conn->close(); // close the connection

// Create connection to the newly created HR database
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("<br>Connection failed: " . $conn->connect_error);
}

// sql to create table
$sql = "CREATE TABLE ".$tblname." (
P_Id MEDIUMINT NOT NULL AUTO_INCREMENT,
i_Name VARCHAR(40) NOT NULL, 
i_Position VARCHAR(40) NOT NULL,
i_Date DATE NOT NULL,
c_Name VARCHAR(40) NOT NULL,
c_CommAbil VARCHAR(2000) NOT NULL,
c_ProfApp VARCHAR(2000) NOT NULL,
c_CompSkill VARCHAR(2000) NOT NULL,
c_BusKnow VARCHAR(2000) NOT NULL,
i_Comments VARCHAR(2000) NOT NULL,
PRIMARY KEY (P_Id)
)";

if ($conn->query($sql) === TRUE) {
    echo "<br>Table ".$tblname." created successfully";
} else {
    echo "<br>Error creating table: " . $conn->error;
}

$conn->close(); // close the connection
?>
</body> 
</html>