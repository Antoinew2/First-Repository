<?php
session_start();
if (!isset($_SESSION['user_level']) or ($_SESSION['user_level'] !=1))
{
header("Location: login.php");
exit();
}
?>

<!doctype html>
<html lang=en>
<head>
<title>An administrator's View-members page</title>
<meta charset=utf-8>
<link rel= "styelsheet" type = "text/css" href="includes.css">
</head>
<body>
<div id ="container">
<?php include("header-admin.php"); ?>
<?php include("nav.php"); ?>
<?php include("info-col.php"); ?>
<div id = "content"> <!-- Start of the view_users_page content -->
<h2> These are the registered users </h2>
<p>
<?php
//This script retrieves all the record from the users table
require ('mysqli_connect.php'); //Connect to the database
//Make the query
$q= "SELECT lname, fname, email, DATE_FORMAT(registration_date, '%M %d %Y')
AS redat, user_id from users ORDER BY registration_date ASC";
$result = @mysqli_query ($dbcon, $q); //Run the query
if ($result) { //Of ot ran without a problem, display the records
//Table headings
echo '<table>
<tr>
<td><b>Edit</b></td>
<td><b> Delete</b></td>
<td><b> Last Name</b></td>
<td><b> First Name</b></td>
<td><b> Email </b></td>
<td><b> Date Registered</b></td>
</tr>';
// Fetch and print all the records
while ($row = mysqli_fetch_array($result,MYSQLI_ASSOC)) {
	echo '<tr>
	<td><a href= "edit_user.php?id=' . $row['user_id'] . '">Edit </a></td>
	<td><a href= "delete_user.php?id=' . $row['user_id'] . '">Delete</a></td>
	<td>' . $row['lname'] . '</td>
	<td>' . $row['fname'] . '</td>
	<td>' . $row['email'] . '</td>
	<td>' . $row['regdat'] . '</td></tr>';
	}
	echo '</table>'; //Close the table
	mysqli_free_result ($result); // Free up resources
	} else {//If it fails to run
	//Error message
	echo '<p class= "error"> The current users could not be retrieved. We apologize
	for any inconvenience. </p>';
	//Debuggingg message
	echo '<p>' . mysqli_error($dbcon) . '<br><br />Query: ' . $q . '</p>';
	} //End of if ($result)
	mysqli close($dbcon); //Close the database connection
	?>
	</p>
	</div><!-- End of page content -->
	</body>
	</html>
