<!DOCTYPE html>

<html>
<head>
    <meta charset = "utf-8">
    <title>Registration Form</title>

</head>
<h1> Welcome to winterfell hotel</h1>
<body>
<?php
session_start();
include "storage.php";


printStuff();


print( "<h1>Book A Room</h1>
            <p>Please fill in all fields and click Register.</p>" );


/**
 * Form starts here
 */
print( " <form method = 'post' action = 'Feedback.php' autocomplete='off'>
            <fieldset><legend>Booking</legend>");
//Name fields
print("<p>First Name: <input type='text' name='fName'/></p>
                 <p>Last Name: <input type='text' name='LName'/></p>
                   ");
print("<p>Choose a room");
print("<select name='selection'> <option disabled>Select Room</option>");

$tCount =1;
foreach ($_SESSION as $type)
{
    if($tCount ==2){$index = 'A';}
    elseif ($tCount ==3){$index = 'B';}
    else if ($tCount==4){$index='C';}
    $count =1;
    //Load rooms
    foreach ($type as $num)
    {
        $value = $_SESSION[$index][$count];
        if($value==1)
        {
            print("<option value='$index,$count' disabled>$index-$count:$$num
            </option>");
        }
        else
        {
            print("<option value='$index,$count,$num'>$index-$count:$$num
            </option>");
        }
        $count++;
    }
    $tCount++;
}
print( "<!-- create a submit button -->
            <p class = 'head'><input type = 'submit' name = 'submit'
            value = 'Book'></p>" );
print ("<p><a href = 'ContactUs.php'> Contact Us.</a></p>");
print"</form></body></html>";
?>


