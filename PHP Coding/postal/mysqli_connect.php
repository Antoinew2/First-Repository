<?php
//Create a connection to the postaldb database and to MySQL
//Set the encoding to utf-8
//Set the database access details as constants
DEFINE ('DB_USER', 'jenner');
DEFINE ('DB_PASSWORD', 'vaccination');
DEFINE ('DB_HOST', 'localhost');
DEFINE ('DB_NAME', 'postaldb');
//Make the connection
$dbcon = @mysqli_connect (DB_HOST, DB_USER, DB_PASSWORD, DB_NAME)
OR die ('Could not connect to MySQL: ' . mysqli_connect_error() );
//Set the encoding
mysqli_set_charset($dbcon, 'utf8');