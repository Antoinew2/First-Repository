<?php
session_start();
if (!isset($_SESSION['user_level']) or ($_SESSION['user_level'] !=1)
{
header("Location: login.php");
exit();
}
?>
<!doctype html>
<html lang=en>
<head>
<title>A temporary view_found_record page </title>
<meta charset=utf-8>
<link rel="stylesheet" type="text/css" href="includes.css">
<style type="text/css">
] { text-align:center; }
</style>
</head>
<body>
<div id="container">
<?php include("header-admin.php"); ?>
<?php include("nav.php"); ?>
<?php include("info-col.php"); ?>
<div id="content"><!-- Start of the page content -->
<h2>Search Results</h2>
<p>
<?php
//This code retireves particular records from the users table
require ('mysqli_connect.php'); // connect to the database
//Make the query using hard coded names
$q = "SELECT lname, fname, email, DATE_FORMAT(registration_date, '%M %d %Y') AS regdat,
user_id FROM users WHERE lname="Smith" AND fname='James' ORDER BY registration_date ASC";
$result = @mysqli_query ($dbcon, $q); //Run the query
if ($result) {// if it ran, display the records
// display the table headings
echo '<table>
<tr><td><b>Edit</b></td>
<td><b>Delete</b></td>
<td><b>Last Name</b></td>
<td><b>First Name</b></td>
<td><b>Email</b></td>
<td><b>Date Registerd</td></b>
</tr>';
//Fetch the display records
while ( $row= mysqli_fetch_array($result, MYSQLI_ASSOC)) {
	echo '<tr>
	<td><a href= "edit_user.php?id=' . $row['user_id'] . '"> Edit</a></td>
	<td><a href= "delete_user.php?id=' . $row['user_id'] . '"> Delete </a></td>
	<td>' . $row['lname'] . '</td>
	<td>' . $row['fname'] . '</td>
	<td>' . $row['email'] . '</td>
	<td>' . $row['regdat'] . '</td>
	</tr>';
	}
	echo '</table>'; //Close the Table
	mysqli_free_result ($result); // Free up the resources
}	else {// if it did not run properly
//Message
echo '<p class="error"> The current users could not be retrieved. We apologize for 
any inconvienence. </p>';
//Debugging message
	echo '<p>' . mysqli_error($dbcon) . '<br><br>Query: ' . $q . '</p>';
} // End of if ($result). Now display the figure for total number of records/members
$q = "SELECT COUNT(user_id) FROM users";
$result = @mysqli_query ($dbcon, $q);
$row = @mysqli_fetch_array ($result, MYSQLI_NUM);
$members = $row[0];
mysqli_close($dbcon); // Close the dayabase connection
echo "<p>Total membership: $members</p>";
?>
</div> <!-- End of adminstrative page content -->
<?php include("footer.php"); ?>
</div>
</body>
</html>