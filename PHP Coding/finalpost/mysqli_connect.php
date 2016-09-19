<?php
//Create a connection to the final post database
//Set the database access details to constants and set the encoding to utf-8
DEFINE ('DB_USER', 'cabbage');
DEFINE ('DB_PASSWORD', 'in4aPin4aL');
DEFINE ('DB_HOST', 'localhost' );
DEFINE ('DB_NAME', 'finalpost');
//Make the connection
$dbcon = @mysqli_connect (DB_HOST, DB_USER, DB_PASSWORD, DB_NAME) OR die
('Could not connect to MySQL: ' . mysqli_connect_error() );
//Set the encoding
mysqli_set_charset($dbcon, 'utf8');