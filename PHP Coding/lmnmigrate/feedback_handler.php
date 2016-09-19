<?php
/* Feedback form handler */
//set to the email address of the recipient
$mailto = "antoinew2@yahoo.com";
$subject = "Message from my website";
//List the pages to be displayed
$formurl = "localhost/lmnmigrate/feedback-form.php;
$errorurl= "localhost/lmnmigrate/error.php;
$thankyouurl= "localhost/lmnmigrate/thankyou.html;
$emailerrurl= "localhost/lmnmigrate/emailerrurl.html";
$errorcommentturl= "localhost/lmnmigrate/commenterror.html";
$uself = 0;
//Set the information received from the form as short variables
$headersep = (!isset( $uself ) || ($uself ==0)) ? "\r\n" : "\n" ;
$username = $_POST['username'] ;
$useremail = $_POST['useremail'];
$phone = $_POST['phone'];
$brochure = $_POST['brochure'];
$addrs1 = $_POST['addrs1'];
$addrs2 = $_POST['addrs2'];
$city = $_POST['city'];
$postcode = $_POST['postcode'] ;
$letter = $_POST['letter'] ;
$comment = $_POST['comment'];
$http_referrer = getenv( "HTTP_REFERER" );
//Check that all four essential fields are filled out
if (empty($username) || empty($useremail) || empty($phone) || empty($comment)) {
header("Location: $errorurl");
exit ; }
//check that no URLs have been inserted in the username text field
if ( strpos ($username, '://')||strpos($username,'www') != false) {
header("Location: $errorsuggesturl");
exit ; }

if(preg_match( "[\r\n]" , $username ) || preg_match( "[\r\n]", $useremail )) {
header(" Location: errorurl" );
exit ; }
#remove any spaces from beginning and end of email address
$useremail = trim($useremail);
#Check for permitted email address patterns
$_name= "/^[-!#$%&\'*+\\.\/0-9=?A-Z^_`{|}~]+";
$_host= "([-0-9A-Z]+\.)+";
$_tlds = "([0-9A-Z]){2,4}$/i";
if(!preg_match($_name."@".$_host.$_tlds,$useremail)) {
header( "Location: $emailerrurl" ) ;
exit ; }
//Has a phone number been entered
if (!empty($_POST['phone'])) {
//Removes spaces, hyphens, letters and brackets.
$phone = preg_replace('/\D+/', '', ($_POST['phone']));
}
//Has the brochure box been checked?
if(!$brochure){$brochure = "No";}
//check that no URLs have been inserted in the addrs1 text field
if (strpos ($addrs1,'://')|| strpos($addrs1, 'www') !==false) {
header("Location: $errorsuggesturl" );
exit ; }
//Check whether URLs have been inserted in the addrs2 text field
if (strpos ($addrs2, '://')||strpos($addrs2,'www') !== false) {
header( "Location: $errorsuggesturl") ;
exit ; }
//Check whether URLS have been inserted in the city textfield
if (strpos($city, '://')||strpos($city,'www') != false) {
header("Location: $errorsuggesturl" );
exit ; }
//Check URLs have been inserted in the pcode text field
if (strpos ($pcode, '://')||strpos($pcode, 'www') != false) {
header ( "Location: $errorsuggesturl" );
exit ; }
//Check whether URLs have been inserted in the comment text area
if (strpos ($comment, '://')||strpos($comment,'www') != false) {
header("Location: $errorcommenturl");
exit ; }
if($letter != null) {$letter = $letter;}
$messageproper =
"This messahe was sent from: \n" .
"http_refferrer\n" .
"Name of sender: $username\n" .
"Email of sender:$useremail\n" .
"Telephone: $phone\n" .
"brochure?: $brochure\n" .
"Address: $addrs1\n" .
"Address: $addrs2\n" .
"City: $city\n" .
"Postcode: $postcode\n" .
"Newsletter:$letter\n" .
"--------------------- Message --------------------------\n\n" .
$comment .
"\n\n ---------------------------------------------------------------------\n";
mail($mailto, $subject, $messageproper, "From: \"$username\" <$useremail>");
header( "Location: $thankyouurl");
exit ;
?>
