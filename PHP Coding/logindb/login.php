<!doctype html>
<html lang=en>
<head>
<title>The Login Page</title>
<meta charset=utf-8>
<link rel="stylesheet" type="text/css" href="includes.css">
</head>
<body>
<div id="container">
<?php include("login-header.php"); ?>
<?php include("nav.php"); ?>
<?php include("info-col.php"); ?>
<div id="content"><!-- Start of the login page content. -->
<?php
//This section processes submissions from the login form
//Check it the form has been submitted:
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
//connect to database
require ('mysqli_connect.php');
//Validate the email address
if (!empty($_POST['email'])) {
	$e = mysqli_real_escape_string($dbcon,$_POST['email']);
} else {
$e= FALSE;
	echo '<p class="error"> You forgot to enter your email address. </p>';
}
//Validate the password
if (!empty($_POST['psword'])) {
	$p = mysqli_real_escape_string($dbcon, $_POST['psword']);
} else {
$p = FALSE;
	echo '<p class= "error"> You forgot to enter your password.</p';
}
if ($e && $p) { //if no problems
// Retrieve the user_id, first name and user level for that email combination
$q = "SELECT user_id, fname, user_level FROM users WHERE (email='$e' AND psword=SHA1('$p'))";
//Run the query and assign it to the variable $result
$result = mysqli_query ($dbcon, $q);
// Count the number of rows that match the email/password combination
if(@mysqli_num_rows($result) ==1) { //if one database row matches the input
//Start the session
session_start();
$_SESSION= mysqli_fetch_array ($result,MYSQLI_ASSOC);
//Ensure that the user level is in an integer
$_SESSION['user_level'] = (int) $_SESSION['user_level'];
//use a ternary operation to set the URL
$url = ($_SESSION['user_level'] === 1 ) ? 'admin-page.php' : 'members-page.php';
header('Location: ' . $url); // Make the browser load either the members' or the admin page
exit(); // Cancel the rest of the script
	mysqli_free_result($result);
	mysql_close($dbcon);
} 
	else 
{	//No match was found
echo'<p class="error"> The e-mail address and password entered do not match our records
<br> Perhaps you need to register, just click the Register button on the header menu </p>';
}
}else {//if the was a problem
echo'<p class="error">Please try again.</p>';
}
mysqli_close($dbcon);
}// End of SUBMIT conditional.
?>
<!-- Display the form fields -->
<div id ="loginfields">
<?php include ('login_page.inc.php'); ?>
</div><br>
<?php include ('footer.php'); ?>
</div>
</div>
</body>
</html>