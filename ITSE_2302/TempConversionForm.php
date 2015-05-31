<?php
  $temp = $_POST['temp'];
  if($temp != NULL) {
    $curr_metric;
    $converted_metric;
    $converted_temp;
    if($_POST['temp_metric'] == 'fahrenheit') {
      $curr_metric = "Fahrenheit";
      $converted_metric = "Celcius";
      $converted_temp = (5/9) * ($temp - 32);
    } else {
      $curr_metric = "Celcius";
      $converted_metric = "Fahrenheit";
      $converted_temp = $temp * 9/5 + 32;
    }
    echo "<div> $temp $curr_metric is $converted_temp $converted_metric. </div>";
  }
  

  echo '<div>';
  echo '<form method="POST" action="">';
    echo "<div>";
      echo '<input type="text" name="temp" />';
      echo '<input type="radio" name="temp_metric" value="fahrenheit" /> Fahrenheit';
      echo '<input type="radio" name="temp_metric" value="celcius" /> Celcius';
    echo "</div>";
    echo "<div>";
      echo '<input type="submit" name="submit" value="submit" />';
    echo "</div>";
  echo "</form>";
  echo "</div>";
?>