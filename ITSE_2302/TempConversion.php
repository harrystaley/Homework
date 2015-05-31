<!DOCTYPE HTML>
<html>
    <head>
        <title> Temperature Conversion </title>
    </head>
    <body>
        <h1><a>Temperature Conversion</a></h1>
        <a>Select a Temperature to convert from</a>
        <form method="post" action= "<?php echo $_SERVER["PHP_SELF"]; ?>">
            Fahrenheit: <input type="radio" name="temp_metric" value="Fahrenheit" />
            Celcius: <input type="radio" name="temp_metric" value="Celcius" />
            <input type="submit" name="submit" value="submit" />
        </form>
        
    </body>
</html>


<?php

//VARIABLE DECLARATIONS
$degrees = NULL;
$temp_degrees = NULL;
$curr_metric = NULL;
$converted_metric = NULL;
$converted_temp = NULL;

//LOGIC
if ('POST' === $_SERVER['REQUEST_METHOD'] and isset($_POST['temp_metric'])) {
    $curr_metric = $_POST['temp_metric'];
    for ($degrees = 0; $degrees <= 100; $degrees++) {
        if($curr_metric == "Fahrenheit") {
            $converted_metric = "Celcius";
            $temp_degrees = ($degrees - 32) * (5/9);
            $converted_temp = round( $temp_degrees, 1);
        } 
    
        else {
            $curr_metric = "Celcius";
            $converted_metric = "Fahrenheit";
            $temp_degrees = $degrees * 9/5 + 32;
            $converted_temp = round($temp_degrees , 1);
        }
    
        //output the result of the users selection
        echo "<div> $degrees $curr_metric is $converted_temp $converted_metric. </div>";
  
    }//end of for loop
}//end of if current metric is not null


?>