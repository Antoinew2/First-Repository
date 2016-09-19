<?php
// This file provides the information for accessing the database and connecting
// to MySQL. It also sets the language coding to utf-8
//First we define the constants
DEFINE ('DB_USER', 'root');
DEFINE ('DB_PASSWORD', '515151');
DEFINE ('DB_HOST', 'localhost');
DEFINE ('DB_NAME', 'simpleIdb');
//Next we assign the database connection to a variable that we will call $dbcon:
$dbcon = @mysqli_connect (DB_HOST, DB_USER, DB_PASSWORD, DB_NAME)
OR die ('Could not connect to MySql: ' . mysqli_connect_error ());
//Finally, we set the language encoding. as utf-8
mysqli_set_charset($dbcon, 'utf8');
