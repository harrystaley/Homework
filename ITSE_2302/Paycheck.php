<html>
    <head>
        <title>Paycheck Results</title>
    </head> 
    <body> 
        <?php 
            $hours = $_POST["hours"]; 
            $wage = $_POST["wage"]; 
            
            $overtimewage = $wage * 1.5;
            $overtime = max($hours - 40, 0); 
            $overtimepay = $overtime * $wage * 1.5; 
            $basepay = ($hours - $overtime) * $wage; 
            $totalpay = $basepay + $overtimepay;

            echo "<h1>Paycheck Calculations</h1>";
            echo "Hours worked: " . $hours . "<br>";
            echo "Pay rate (per hour): $" . number_format($wage, 2) . "<br>";
            echo "Base pay: $" . number_format($basepay, 2) . "<br>";
            echo "Overtime rate (per hour): $" . number_format($overtimewage, 2) . "<br>";
            echo "Overtime hours worked: " . $overtime . "<br>";
            echo "Overtime pay: $" . number_format($overtimepay, 2) . "<br>";
            echo "Your Paycheck is: $" . number_format($totalpay, 2) . "<br>"; 
        ?> 
    </body> 
</html>