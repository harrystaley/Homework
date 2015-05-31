<html>
    <head>
        <title>Interviews Completed</title>
    </head> 
    <body> 
        
        <p>
            <h1>Interviews Completed</h1>
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
        $conn = new mysqli($servername, $username, $password, $dbname);
        // Check connection
        if ($conn->connect_error) {
            die("<br>Connection failed: " . $conn->connect_error);
        } 
        
        $sql = "SELECT 
                    P_Id,
                    i_Name, 
                    i_Position, 
                    i_Date, 
                    c_Name, 
                    c_CommAbil, 
                    c_ProfApp, 
                    c_CompSkill, 
                    c_BusKnow, 
                    i_Comments 
                FROM ".$tblname;
        $result = $conn->query($sql);

        if ($result->num_rows > 0) {
            echo "<table>
                    <tr>
                        <td>ID (PK)</td>
                        <td>Interviewer's Name</td>
                        <td>Interviewer's Position</td>
                        <td>Interview Date</td>
                        <td>Candidates' Name</td>
                        <td>Candididate's Communication Abilities</td>
                        <td>Candididate's Professional Appearance</td>
                        <td>Candididate's Computer Skills</td>
                        <td>Candididate's Business Knowledge</td>
                        <td>Interviewer's Comments</td>
                    </tr>";
            // output data of each row
            while ($row = $result->fetch_assoc()) {
                echo "<tr>".
                        "<td>".$row["P_Id"]."</td>".
                        "<td>".$row["i_Name"]."</td>".
                        "<td>".$row["i_Position"]."</td>".
                        "<td>".$row["i_Date"]."</td>".
                        "<td>".$row["c_Name"]."</td>".
                        "<td>".$row["c_CommAbil"]."</td>".
                        "<td>".$row["c_ProfApp"]."</td>".
                        "<td>".$row["c_CompSkill"]."</td>".
                        "<td>".$row["c_BusKnow"]."</td>".
                        "<td>".$row["i_Comments"]."</td>".
                    "</tr>";
            }
            echo "</table>";
        } 
        else {
            echo "0 results";
        }
        
        $conn->close();
        ?> 
    </body> 
</html>