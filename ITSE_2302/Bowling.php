<html>
    <head>
        <title>Bowling Tournament Sign Up</title>
    </head> 
    <body> 
        
        <p>
            <h1>Thank you for signing up for the tournament and good luck!</h1>
        </p>
        <p>
            Use your browsers back button to sign up another bowler.
        </p>
        
        
        
        <?php 
            $Name = $_POST["Name"];
            $Age = $_POST["Age"]; 
            $Average = $_POST["Average"]; 
            $Bowler = $Name.",".$Age.",".$Average."\n";
            $BowlingRoster = fopen("Bowling.txt", "a+") or die("Unable to open file!");
            
            fwrite($BowlingRoster, $Bowler);
            fclose($BowlingRoster);
        ?> 
    </body> 
</html>