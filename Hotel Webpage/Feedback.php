<
/**
 * Created by PhpStorm.
 * User: Emmanuel Blay
 * Date: 16/11/2018
 * Time: 13:46
 */
<!DOCTYPE html>


<html>
   <head>
      <meta charset = "utf-8">
      <title>Booking Receipt</title>
      </head>
   <body>
   <?php
session_start();
if (isset($_POST['submit']))
{
    $fName = $_POST[ "fName" ] ? $_POST["fName"] : '';
    $lName = $_POST[ "lName" ] ? $_POST["lName"] : '';
    $selection = $_POST["selection"];
    list($roomType,$roomNumber, $price) = explode(',', $selection);


    //parse it and get the room number and type
print "<br>Hello  $fName $lName";
print"<br> You successfully booked room $roomType-$roomNumber which costs $$price";
$_SESSION[$roomType][$roomNumber] = 1;

}
   print ("<p><a href = 'index.php'> Make another Booking.</a></p>
     <p><a href = 'ContactUs.php'> Contact Us.</a></p>");

//The booking memo should have the customer’s name, room type, room number, and the price

   ?>

