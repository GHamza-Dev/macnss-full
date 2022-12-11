<%@ include file="./inc/layout.header.jsp" %>

<div class="container mt-4">
    <h3 class="display-6">New Dossier</h3>

    <nav>
        <div class="nav mb-3 d-flex align-items-center gap-2" id="nav-tab" role="tablist">
            <button style="background-color: #1D4483" class="btn btn-secondary d-flex align-items-center active" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-home" type="button" role="tab" aria-controls="nav-home" aria-selected="true">
                <span>Select patient</span>
                <svg class="bi text-white ms-1" width="16" height="25"><use xlink:href="#user"/></svg>
            </button>
            <button style="background-color: #1D4483" class="btn btn-secondary d-flex align-items-center" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-profile" type="button" role="tab" aria-controls="nav-profile" aria-selected="false">
                <span>Attachments</span>
                <svg class="bi text-white ms-1" width="16" height="25"><use xlink:href="#paperclip"/></svg>
            </button>
        </div>
    </nav>

    <form action="${url}dossier/add" method="POST">
        <div class="tab-content" id="nav-tabContent">
            <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                <div class="p-3 shadow-sm rounded-3 my-2" style="border: solid 1px #1D4483;">
                    <h4 style="color: #1D4483">Select patient</h4>
                    <div class="p-3 mt-2 b border-secondary rounded-2 bg-light">
                        <div class="d-flex flex-wrap gap-1">
                            <div class="mb-3 flex-grow-1 d-flex align-content-center gap-1">
                                <div class="flex-grow-1">
                                    <label class="form-label">Patient number</label>
                                    <div class="d-flex flex-wrap gap-1">
                                        <input type="number" class="search-patient form-control" placeholder="Ex: 123456789">
                                    </div>
                                </div>
                                <div class="d-flex flex-column justify-content-end">
                                    <button class="add-patient-btn btn btn-secondary rounded-3" style="background-color: #1D4483;">
                                        <svg class="bi" width="16" height="25"><use xlink:href="#add-plus"/></svg>
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="selected-patient row container gap-1">
                            <%-- Selected patient goes here --%>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                <div class="p-3 shadow-sm rounded-3 my-2 mt-3" style="border: solid 1px #1D4483;">
                    <h4 style="color: #1D4483">Speciality</h4>
                    <div class="p-3 mt-2 b border-secondary rounded-2 bg-light">
                        <div class="d-flex flex-wrap gap-1">
                            <div class="mb-3 flex-grow-1 d-flex align-content-center gap-1">
                                <div class="flex-grow-1">
                                    <label class="form-label">Select speciality</label>
                                    <div class="d-flex flex-wrap gap-1">
                                        <select class="select-speciality form-select">
                                            <c:forEach var='speciality' items='${refundables.get("specialities")}'>
                                                <option value="${speciality.getId()}">${speciality.getName()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="d-flex flex-column justify-content-end">
                                    <button class="add-speciality-btn btn btn-secondary rounded-3" style="background-color: #1D4483;">
                                        <svg class="bi"  width="16" height="25"><use xlink:href="#add-plus"/></svg>
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="selected-specialities row container gap-1">
                            <%-- Selected specialities goes here --%>
                        </div>
                    </div>
                </div>

                <div class="p-3 shadow-sm rounded-3 my-2" style="border: solid 1px #1D4483;">
                    <h4 style="color: #1D4483">Medications</h4>
                    <div class="p-3 mt-2 b border-secondary rounded-2 bg-light">
                        <div class="d-flex flex-wrap gap-1">
                            <div class="mb-3 flex-grow-1 d-flex align-content-center gap-1">
                                <div class="flex-grow-1">
                                    <label class="form-label">Medication bar code</label>
                                    <div class="d-flex flex-wrap gap-1">
                                        <input type="number" class="search-medication form-control" placeholder="Ex: 123456789">
                                    </div>
                                </div>
                                <div class="d-flex flex-column justify-content-end">
                                    <button class="add-medication-btn btn btn-secondary rounded-3" style="background-color: #1D4483;">
                                        <svg class="bi" width="16" height="25"><use xlink:href="#add-plus"/></svg>
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="selected-medications row container gap-1">
                            <%-- Selected medications goes here --%>
                        </div>
                    </div>
                </div>

                <div class="p-3 shadow-sm rounded-3 my-2" style="border: solid 1px #1D4483;">
                    <h4 style="color: #1D4483">Analysis</h4>
                    <div class="p-3 mt-2 b border-secondary rounded-2 bg-light">
                        <div class="d-flex flex-wrap gap-1">
                            <div class="mb-3 flex-grow-1 d-flex align-content-center gap-1">
                                <div class="flex-grow-1">
                                    <label class="form-label">Select analysis</label>
                                    <div class="d-flex flex-wrap gap-1">
                                        <select class="select-analysis form-select">
                                            <c:forEach var='analysis' items='${refundables.get("analyses")}'>
                                                <option value="${analysis.getId()}">${analysis.getName()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="d-flex flex-column justify-content-end">
                                    <button class="add-analysis-btn btn btn-secondary rounded-3" style="background-color: #1D4483;">
                                        <svg class="bi" width="16" height="25"><use xlink:href="#add-plus"/></svg>
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="selected-analyses row container gap-1">
                            <%-- Selected analyses goes here --%>
                        </div>
                    </div>
                </div>

                <div class="p-3 shadow-sm rounded-3 my-2" style="border: solid 1px #1D4483;">
                    <h4 style="color: #1D4483">Radios</h4>
                    <div class="p-3 mt-2 b border-secondary rounded-2 bg-light">
                        <div class="d-flex flex-wrap gap-1">
                            <div class="mb-3 flex-grow-1 d-flex align-content-center gap-1">
                                <div class="flex-grow-1">
                                    <label class="form-label">Select radios</label>
                                    <div class="d-flex flex-wrap gap-1">
                                        <select class="select-radio form-select">
                                            <c:forEach var='radio' items='${refundables.get("radios")}'>
                                                <option value="${radio.getId()}">${radio.getName()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="d-flex flex-column justify-content-end">
                                    <button class="add-radio-btn btn btn-secondary rounded-3" style="background-color: #1D4483;">
                                        <svg class="bi" width="16" height="25"><use xlink:href="#add-plus"/></svg>
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="selected-radios row container gap-1">
                            <%-- Selected radios goes here --%>
                        </div>
                    </div>
                </div>

                <div class="d-flex justify-content-end">
                    <button class="btn btn-success btn-lg" type="submit">Submit</button>
                </div>
            </div>
        </div>
    </form>

</div>

<script src="<c:url value="/resources/scripts/new.dossier.js" />"></script>
<%@ include file="./inc/layout.footer.jsp" %>

