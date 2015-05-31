<html>
    <head>
        <title>Guest Book Display</title>
    </head> 
    <body> 
        
        <p>
            <h1>The guest book is displayed below.</h1>
        </p>
        <p>
            <p><a href ="ShowGuestBook.php">Show Guest Book. </a></p>
            <p><a href ="AlphaGuestBook.php">Remove duplicate values and alphabatize the Guest Book. </a></p>
            <p><a href ="GuestBook.html">Add another guest to the Guest Book. </a></p>
            
        </p>
        <table>
        <tr>
            <td> Name </td>
            <td> Email </td>
        </tr>

<?php

$GuestBook = fopen("GuestBook.csv", "r");

while (($line = fgetcsv($GuestBook)) !== false) {
        echo "<tr>";
        foreach ($line as $cell) {
                echo "<td>" . htmlspecialchars($cell) . "</td>";
        }
        echo "</tr>\n";
}
fclose($GuestBook);
?>
        </table>
    </body>
</html>
