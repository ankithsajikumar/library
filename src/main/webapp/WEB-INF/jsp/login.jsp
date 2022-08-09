<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Login</title>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"rel="stylesheet">
        <link href="css/login.css" rel="stylesheet">
    </head>
    <body>
        <div class="login-v1">
        <div class="background-wrap">
          <div class="background"></div>
        </div>

        <form id="accesspanel" action="perform_login" method='POST'>
          <h1 id="litheader">LOGIN</h1>
          <div class="inset">
            <p>
              <input type="text" name="username" id="email" placeholder="Username">
            </p>
            <p>
              <input type="password" name="password" id="password" placeholder="Access code">
            </p>
            <input class="loginLoginValue" type="hidden" name="service" value="perform_login" />
          </div>
          <p class="p-container">
            <input type="submit" name="Login" id="go" value="Login">
          </p>
        </form>
        </div>
        <footer>
            <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
            <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
            <script src="js/login.js"></script>
        </footer>
    </body>
</html>