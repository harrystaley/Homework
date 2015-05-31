<?php


//Assign Values to the variable.
$number = 15;

//If statements to check Even number or not.

//Is_numeric, Isset() and round() functions.
if (is_numeric($number) && isset($number)){
	if (round($number, 0) % 2 == 0){
	       echo "The number " .$number. " entered is a even number<br>";
	   }
    else
	   {
		echo "The number " . $number. " is a non-even number";
	   } //End round if statement.
	} //End is numeric if statement
else
	{
		echo "Please enter a numeric value.";
	}


?>