<%@ page import="flat.io.macnss.Config.Global" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
    <form action="<%=Global.url%>users/login" method="POST">
        <input name="email" type="email" placeholder="email">
        <input name="password" type="password" placeholder="password">
        <div>
            <label>Agent</label>
            <input name="role" type="radio" value="agent" checked>
            <br>
            <label>Patient</label>
            <input name="role" type="radio" value="patient">
        </div>
        <br><br>
        <button>Login</button>
    </form>
</body>
</html>