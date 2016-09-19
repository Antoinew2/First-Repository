<?php
session_start();
if (!isset($_SESSION['user_level']) or ($_SESSION['user_level'] != 1)) {
header("Location: login.php");
exit();
}
?>
<!doctype html>
<html lang=en>
<head>
<title>Search Page</title>
<meta charset=utf-8>
<link rel="stylesheet" type="text/css" href="includes.css">
<style type="text/css">
h3.red { color:red; font-size:105%; font-weight:bold; text=align:center;}
</style>
</head>
<body>
<div id="container">
<?php include("header-admin.php"); ?>
<?php include("nav.php"); ?>
<?php include("info-col.php"); ?>
<div id="content"><!-- Start of search address page content -->
<h2>Search for an Address or Phone Number</h2>
<h3 class = "red">Both name are required items</h3>
<!-- the form has been commented out in the download file to prevent an address being accessed
an active version of the file is provided in the downloads for chapter 6 -->
<form action="view_found_address.php" method="post">

<p><label class="label" for="fname"> First Name: </label>
<input id="fname" type="text" name="fname" size="30" maxlength="30"
value="<?php if (isset($_POST['fname'])) echo $_POST['fname']; ?>"</p>

<p><label class="label" for ="lname"> Last Name:</label>
<input id-"lname" type="text" name="lname" size="30" maxlength="40"
value="<?php if (isset($_POST['lname'])) echo $_POST['lname']; ?>"></p>
<p><input id="submit" type="submit" name="submit" value="Search"></p>
</form>
<?php include ('footer.php'); ?>
</div>>!-- End of the search address page content -->
</div>
</body>
</html>

