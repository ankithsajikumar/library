<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Register</title>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"rel="stylesheet">
    </head>
    <body>
        <form id="accesspanel" action="login/register" method='POST'>
			<h1 id="litheader">Register</h1>
			<div class="inset">
				<input type="text" name="username" id="email">
				<input type="password" name="password" id="password">
				<input type="submit" id="go" value="Register">
			</div>
        </form>
        <footer>
			<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
			<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
        </footer>
    </body>
</html>
