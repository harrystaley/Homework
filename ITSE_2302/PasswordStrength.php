<?php

//SET VARIABLES
$Passwords = array( "@Ab1000000000000Z", //error too long
                    "@Ab1000000000000", //correct
                    "@Ab1000", //error too short
                    "@Ab10000", //correrct
                    "@AbZZZZZ", //error no numbers
                    "@Ab1ZZZZ", //correct
                    "@AZ1ZZZZ", //error no lower case
                    "@Ab1ZZZZ", //correct
                    "@zb1zzzz", //error no upper case
                    "@Ab1zzzz", //correct
                    "zAb1zzzz", //error no symbol
                    "@Ab1zzzz", //correct
                    "@Ab1zzz z", //error contains a space
                    "@Ab1zzzz", //correct
                    "a a" //fails multiple tests
                    );
$value = "";

//BUSINESS LOGIC

//validate all passwords in the password array
foreach ($Passwords as $value) {
    
    $error = ""; //reset the error variable at the top of the loop
    
    //Error if password is more than 16 characters in length 
    if( preg_match("/.{17}$/", $value)) {
	   $error .= "Password too long! <br>";
    } //end if password is too long and concatenate it to $error variable
    
    // error if the password is not at least 8 characters in length
   if( !preg_match("/.{8}$/", $value)) {
	   $error .= "Password too short! <br>";
    } //end if password is too short and concatenate it to $error variable

    if( preg_match("/.[\s]+/", $value)) {
	   $error .= "Password contains a space! <br>";
    } 
    
    //error if the password does nto include at least one number
   if( !preg_match("/.[0-9]+/", $value) ) {
	   $error .= "Password must include at least one number! <br>";
    }//end if password must include a number and concatenate it to $error variable
    
    //error if the password does not contain at least one lowercase
   if( !preg_match("/.[a-z]+/", $value) ) {
	   $error .= "Password must include at least one lower case letter! <br>";
    }//end if password must include a lower case letter
    
    //error if the password does not contail atleast one capitol
   if( !preg_match("/.[A-Z]+/", $value) ) {
	   $error .= "Password must include at least one capitol letter! <br>";
    }//end if the password must have at least one capitol letter
    
    //error if the password does not contain at least one symbol character
    // \s is included due to the fact that the error was seeing the space as a valid symbol this should be errataed in the hint of the homework problem
   if( !preg_match("/[^0-9A-Za-z\s]/", $value) ) {
	   $error .= "Password must include at least one symbol! <br>";
    }//end if the password must include at least one symbol and concatenate it to $error variable
    
    //OUTPUT
    
    //if the error is not null then show the error otherwise show the password as valid
    if($error){
        echo "$value";
        echo "<br>";
        echo "Password validation failure(your choise is weak):";
        echo "<br>";
        echo "$error";
        echo "<br>";
    } else {
        echo "$value";
        echo "<br>";
        echo "Your password is strong.";
        echo "<br>";
        echo "<br>";
    }//end if error exists display the failure
}//end for loop for the array length

?>