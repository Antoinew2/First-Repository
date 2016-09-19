<?php
session_start();//access the current session
//if no session variable exists then redirect the user
if (!isset($_SESSION['user_id'])) {
header("location:index.php");
exit();
// cancel the session and redirect the user
} else { // cancel the session
	$_SESSION = array(); // destroy the variables
	session_destroy(); // destroy the session
setcookie('PHPSESSID', ", time()-3600,'/', ",0,0);//Destroy the cookie
header("location:index.php");
exit();
}
?>
