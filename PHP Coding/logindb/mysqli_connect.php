<?php
//Create a connection to the logindb database and to MySQL.
// Set the encoding and access details as constants:
DEFINE ('DB_USER','williams');
DEFINE ('DB_PASSWORD','catonlap');
DEFINE ('DB_HOST','localhost');
DEFINE ('DB_NAME','logindb');
//Make the connection
$dbcon = @mysqli_connect (DB_HOST, DB_USER, DB_PASSWORD,DB_NAME)
OR die ('Could not connect to MySQL: ' .mysqli_connect_error() );
//set the encoding...
mysqli_set_charset($dbcon,'utf8');