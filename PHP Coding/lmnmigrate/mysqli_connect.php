<?php
//Connect to the lmnmigrate database and set the encoding to utf-8
DEFINE ('DB_USER', 'trevithick');
DEFINE ('DB_PASSWORD','locomotive');
DEFINE ('DB_HOST','localhost');
DEFINE ('DB_NAME','lmnmigrate');
//Make the connection
$dbcon = @mysqli_connect (DB_HOST, DB_USER, DB_PASSWORD, DB_NAME) OR die
('Could not connect to MySQL: ' . mysqli_connect_error() );
//Set the encoding
mysqli_set_charset($dbcon, 'utf8');
 