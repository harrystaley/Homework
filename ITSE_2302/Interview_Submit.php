<html>
    <head>
        <title>Interview Submitted</title>
    </head> 
    <body> 
        
        <p>
            <h1>Interview Submitted</h1>
        </p>
        <p>
            <p><a href ="Interview_Input.html">Input a new Intervew</a></p>
            <p><a href ="Interview_Show.php">Show Interview Info</a></p>
        </p>
        
        <?php 
            if ($_SERVER["REQUEST_METHOD"] == "POST")
            {
                $i_Name = $_POST["i_Name"];
                $i_Position = $_POST["i_Position"];
                $i_Date = $_POST["i_Date"];
                $c_Name = $_POST["c_Name"];
                $c_CommAbil = $_POST["c_CommAbil"];
                $c_ProfApp = $_POST["c_ProfApp"];
                $c_CompSkill = $_POST["c_CompSkill"];
                $c_BusKnow = $_POST["c_BusKnow"];
                $i_Comments = $_POST["i_Comments"];
            }

        $servername = "localhost";
        $username = "root";
        $password = "";
        $dbname = "HR";
        $tblname = "interview";

        // Create connection
        $conn = new mysqli($servername, $username, $password, $dbname);
        // Check connection
        if ($conn->connect_error) {
            die("<br>Connection failed: " . $conn->connect_error);
        } 
        
        $sql = "INSERT INTO ".$tblname." (
                    i_Name,
                    i_Position,
                    i_Date,
                    c_Name,
                    c_CommAbil,
                    c_ProfApp,
                    c_CompSkill,
                    c_BusKnow,
                    i_Comments
                )
                VALUES ('".
                    $i_Name."', '". 
                    $i_Position."', '". 
                    $i_Date."','".
                    $c_Name."', '".
                    $c_CommAbil."', '".
                    $c_ProfApp."', '".
                    $c_CompSkill."', '".
                    $c_BusKnow."', '".
                    $i_Comments.
                "')";
        
        if ($conn->query($sql) === TRUE) {
            echo "<br>New record created successfully";
}       else {
            echo "<br>Error: " . $sql . "<br>" . $conn->error;
        }
        
        $conn->close();
        ?> 
    </body> 
</html>