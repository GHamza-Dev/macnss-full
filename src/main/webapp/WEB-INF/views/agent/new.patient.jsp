<%@ include file="../layout/header.jsp" %>

<h1>New Patient</h1>
<form action="${url}patient/add" method="POST">
    <input name="email" type="email" placeholder="Enter patient email">
    <input name="password" type="password" placeholder="Enter patient password">
    <input name="username" type="text" placeholder="Enter patient username">
    <input name="patient-number" type="number" placeholder="Enter patient number">
    <br><br>
    <button>Submit</button>
</form>

<%@ include file="../layout/footer.jsp" %>

