<%@ include file="./inc/layout.header.jsp" %>

<div class="container mt-4">
    <h3 class="display-6">New Patient</h3>

    <form action="${url}patient/add" method="post" class="p-3 mt-4 border border-1 border-secondary rounded-2">
        <div class="d-flex flex-wrap gap-1">
            <div class="mb-3 flex-grow-1">
                <label for="email" class="form-label">Email address</label>
                <input type="email" name="email" class="form-control" id="email" placeholder="name@example.com">
            </div>
            <div class="mb-3 flex-grow-1">
                <label for="username" class="form-label">Username</label>
                <input type="text" name="username" class="form-control" id="username" placeholder="enter patient's username">
            </div>
            <div class="mb-3 flex-grow-1">
                <label for="patientNumber" class="form-label">Patient Number</label>
                <input type="number" name="patient-number" class="form-control" id="patientNumber" placeholder="enter patient's number">
                <input type="password" name="password" hidden value="123456">
            </div>
        </div>
        <div class="d-flex gap-2 justify-content-end">
            <div class="mb-3">
                <button type="submit" class="btn btn-primary form-control">Submit</button>
            </div>
        </div>
    </form>
</div>

<%@ include file="./inc/layout.footer.jsp" %>

