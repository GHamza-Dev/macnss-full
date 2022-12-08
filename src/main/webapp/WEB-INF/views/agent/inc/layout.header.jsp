<%@ page import="flat.io.macnss.Config.Global" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set value="${Global.url}" var="url" scope="application"/>

<html>
<head>
    <title>Agent Panel | Welcome</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="<c:url value="/resources/styles/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/styles/sidebars.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/scripts/bootstrap.min.js" />"></script>
    <script defer src="<c:url value="/resources/scripts/sidebars.js" />"></script>
</head>
<body>

<%@ include file="./icons.jsp" %>

<div class="main-wrapper">
    <%@ include file="./aside.jsp" %>



