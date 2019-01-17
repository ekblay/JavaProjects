<!DOCTYPE html >
<head>
    <meta charset = "utf-8">
    <title>storage</title>
    <style type = "text/css">
        p       { margin: 0px; }
        p.head  { font-weight: bold; margin-top: 10px; }
        label   { width: 5em; float: left; }
    </style>
</head>

<html>
<body>
<?php
// begin the session
session_start();
//run this  portion once
if(!isset($_SESSION['first_run'])){
    $_SESSION['first_run'] = 1;
    //set the rooms
    $type_A[1]= 0;$type_A[2]=0;$type_A[3]= 0;$type_A[4]= 0;$type_A[5]= 0;//1-400
    $type_B[1]=0;$type_B[2]=0;$type_B[3]=0;$type_B[4]=0;$type_B[5]=0;//1-300
    $type_C[1]=0;$type_C[2]=0;$type_C[3]=0;$type_C[4]=0;$type_C[5]=0;//1-200
// put the array in a session variable
    $_SESSION['A']=$type_A;
    $_SESSION['B'] =$type_B;
    $_SESSION['C'] =$type_C;

}


/**
 *
 * This function randomizes
 */
function randomized()
{
    for ($i = 1; $i < 6; $i++)
    {
        if($_SESSION['A'][$i] !=1)
        {
            $_SESSION['A'][$i] = rand(100, 400);
        }
    }

    for ($i = 1; $i < 6; $i++)
    {
        if($_SESSION['B'][$i] != 1) {
            $_SESSION['B'][$i] = rand(100, 300);
        }
    }

    for ($i = 1; $i < 6; $i++)
    {
        if($_SESSION['C'][$i] != 1) {
            $_SESSION['C'][$i] = rand(100, 200);
        }
    }

}
randomized();
asort($_SESSION['A']);
asort($_SESSION['B']);
asort($_SESSION['C']);

//printStuff();
function printStuff()
{
    print  "<br>These are the rooms we have";


    print " <br><br> Type A rooms ($100-$400)";
    $counter =1;
    if(isVacant($_SESSION['A']))
    {
        foreach ($_SESSION['A'] as $value)
        {
            if( $_SESSION['A'][$counter]==1)
            {
                print "<br>Room A-$counter is not available";
            }
            else {
                print "<br>Room A-$counter is $$value";

            }
            $counter++;
        }
    }
    else{print " <br>Rooms in type A have no vacancy";}

    print " <br><br> Type B rooms ($100-$300)";
    $counter =1;
    if(isVacant($_SESSION['B']))
    {
        foreach ($_SESSION['B'] as $value)
        {
            if( $_SESSION['B'][$counter]==1)
            {
                print "<br>Room B-$counter is not available";
            }else
            {print "<br>Room B-$counter is $$value";}
            $counter++;

        }
    }
    else{print"<br>Rooms in type B have no vacancy";}


    print " <br><br> Type C rooms($100-$200)";
    $counter =1;
    if(isVacant($_SESSION['C']))
    {
        foreach ($_SESSION['C'] as $value)
        {
            if( $_SESSION['C'][$counter]==1)
            {
                print "<br>Room C-$counter is not available";
            }
            else{
            print "<br>Room C-$counter is $$value";}
            $counter++;

        }
    }
    else{print" <br>Rooms in type C have no vacancy";}


}

/**
 * This function checks if the rooms are vacant
 */
function isVacant($array)
{
    $count = 0;
    foreach ($array as $var)
    {
        if ($var == 1) {
            $count++;
        }
    }

        if ($count == 5)
        {return false;}
        else{return true;}


}
?>
