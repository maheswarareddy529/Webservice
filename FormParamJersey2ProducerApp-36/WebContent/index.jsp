<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
</head>
<body>
<h1>Payment Screen Here!</h1>
<form action="rest/payment/card" method="POST">
<pre>
CARD NUMBER:               <input type="text" name="cardNum" placeholder="xxxx-xxxx-xxxx">
CARD HOLDER NAME:   <input type="text" name="cardName" placeholder="Enter your Name">
EXP  MONTH:                   <select name="expMonth">
                                            <option>JAN</option>
                                            <option>FEB</option>
                                            <option>MAR</option>
                                            <option>APR</option>
                                            <option>MAY</option>
                                            <option>JUN</option>
                                            <option>JUL</option>
                                            <option>AUG</option>
                                            <option>SEP</option>
                                            <option>OCT</option>
                                            <option>NOV</option>
                                            <option>DEC</option>
                                           </select>
 EXP YEAR:                   <select name="expYear">
                                            <option>2021</option>
                                            <option>2022</option>
                                            <option>2023</option>
                                            <option>2024</option>
                                            <option>2025</option>
                                            <option>2026</option>
                                            <option>2027</option>
                                            <option>2028</option>
                                            <option>2029</option>
                                           </select>
    CVV:                            <input type="text" name="cvv" placeholder="***">
    AMOUNT:                    <input type="text" name="amt" placeholder="23.33">
                                         <input type="submit" value="Pay Now...">
</pre>
</form>
</body>
</html>

