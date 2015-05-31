<html>
    <head>
        <title>Bowling Tournament Sign Up</title>
    </head> 
    <body> 
        
        <p>
            <h1>Thank you for visiting our hotel!</h1>
        </p>
        <p>
            <p><a href ="ShowGuestBook.php">Show Guest Book. </a></p>
            <p><a href ="AlphaGuestBook.php">Remove duplicate values and alphabatize the Guest Book. </a></p>
            <p><a href ="GuestBook.html">Add another guest to the Guest Book. </a></p>
            
        </p>
        
        
        <?php 
            if ($_SERVER["REQUEST_METHOD"] == "POST")
            {
                $Name = test_input($_POST["Name"]);
                $Email = test_input($_POST["Email"]);
            }

            
            if ($Name !== NULL)
            {
                $Guest = $Name.",".$Email."\n";
                $GuestBook = fopen('GuestBook.csv', 'a+') or die("Unable to open file!");
                fwrite($GuestBook, $Guest);
                fclose($GuestBook);
                echo "<h3>Thank you for signing our guest book!</h3>";
            }

            function test_input($data)
            {
                $data = trim($data);
                $data = stripslashes($data);
                $data = htmlspecialchars($data);
                $Dupe = NULL;
                $GuestBook = fopen("GuestBook.csv", "r");
                
                while (false != ( $row = fgetcsv($GuestBook, 0, ',') )) {
                    //extract name from the first column
                    //this should match the last word before the comma, if there is a comma
                    preg_match('~([^\s]+)(?:,.*)?$~', $row[0], $m);
                    $names[] = $m[1];
                    $rows[] = $row;
                }

                fclose($GuestBook);


                
                if (in_array($data, $names) == false)
                {
                    return $data;
                }
                else
                {
                    echo "<h3>This guest has already signed in!<h3>";
                }
                
            }
        ?> 
    </body> 
</html>