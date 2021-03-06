<!doctype html>
<html lang=en>
<head>
<title> The Login page</title>
<meta charset=utf-8>
<link rel="stylesheet" type="text/css" href="includes.css">
</head>
<body>
<div id="container">
<?php include("login-header.php"); ?>
<?php include("nav.php"); ?>
<? php include("info-col.php"); ?>
<div id="content"><!-- Start of the login page content. -->
<?php
//This section processes submissions from the login form.
//Check if the form has been submitted:
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
	//connect to database
	require ('mysqli_connect.php');
	//Validate the email address:
	if (!empty($_POST['email'])) {
		$e = mysqli_real_escape_string($dbcon, $_POST['email']);
	} else {
	$e = FALSE;
		echo '<p class="error">You forgot to enter your email address.</p>';
	}
	//Validate the password
	if (!empty($_POST['psword'])) {
		$p = mysqli_real_escape_string($dbcon, $_POST['psword']);
	} else {
	$p = FALSE;
		echo '<p class="error"> You forgot to enter your password. </p>';
	}
	if ($e && $p) { //If no problems
//Retrieve the user_id, first name and user_level for that email/password combination:
	$q = "SELECT user_id, fname, user_level FROM users WHERE (email='$e' AND psword=SHA1('$p') )"; //AND paid='Yes')";
	$result = mysqli_query ($dbcon,$q);
	//Check the result:
	if (@mysqli_num_rows($result) == 1 ) { //The user input matched the database record
	//Start the session, fetch the record and insert the three value in an array
	session_start();
	$_SESSION = mysqli_fetch_array ($result, MYSQLI_ASSOC);
$_SESSION['user_level'] = (int) $_SESSION['user_level']; //Ensure the user level is an integer
$url = ($_SESSION['user_level'] == 1) ? 'admin-page.php' : 'members-page.php'; //Ternary operation to set the URL
header('Location: ' . $url); //Make the selected page appear
exit(); //Cancels the rest of the script
	mysqli_free_result($result);
	mysqli_close($dbcon);
	} else { //No match was made
	echo '<p class="error"> The email address and password do not match our records.<br> Perhaps your fee has not yet arrived from PayPal. <br> If you need to register, click the Register button on the header menu </p>';
 	}
	} else { //If there was a problem
		echo '<p class="error"> Please try again.</p>';
	}
	mysqli_close($dbcon);
	} //End of Submit conditional.
?>
<!-- Display the form fields -->
<div id="loginfields">
<?php include('login_page.inc.php'); ?>
</div>
</div>
</body>
</html>
