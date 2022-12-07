<%@ page import="flat.io.macnss.Config.Global" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>New Dossier</title>
</head>
<body>
<h1>New Dossier</h1>
<form action="<%=Global.url%>dossier/add" method="POST">
    <div>
        <label>Medication</label>
        <select name="medication">
            <c:forEach var='medication' items='${refundables.get("medications")}'>
                <option value="${medication.getId()}">${medication.getName()}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label>Analysis</label>
        <select name="analysis">
            <c:forEach var='analysis' items='${refundables.get("analyses")}'>
                <option value="${analysis.getId()}">${analysis.getName()}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label>Radios</label>
        <select name="radio">
            <c:forEach var='radio' items='${refundables.get("radios")}'>
                <option value="${radio.getId()}">${radio.getName()}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label>Specialities</label>
        <select name="speciality">
            <c:forEach var='speciality' items='${refundables.get("specialities")}'>
                <option value="${speciality.getId()}">${speciality.getName()}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label>Patients list</label>
        <select name="patient">
            <c:forEach var='patient' items='${patients}'>
                <option value="${patient.getId()}">${patient.getUsername()}</option>
            </c:forEach>
        </select>
    </div>
    <br><br>
    <button>Submit</button>
</form>
</body>
</html>
