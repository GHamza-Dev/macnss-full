<aside class="d-flex flex-column flex-shrink-0 p-3" style="background-color: #1D4483;width: 280px; min-height: 100vh;">
  <div class="rounded-3">
    <span style="width: 5rem;" class="mx-auto d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
      <img class="w-100 rounded-circle" src="<c:url value="/resources/images/logo.png" /> ">
    </span>
  </div>
  <ul class="nav nav-pills flex-column mb-auto mt-3">
    <li class="nav-item">
      <a href="#" class="nav-link" style="color: #17A2B8;background-color: #FFF;" aria-current="page">
        <svg class="bi me-2" width="16" height="16"><use xlink:href="#home"/></svg>
        Home
      </a>
    </li>
    <li>
      <a href="${url}patient/add" class="nav-link text-white">
        <svg class="bi me-2" width="16" height="16"><use xlink:href="#add-user"/></svg>
        New Patient
      </a>
    </li>
    <li>
      <a href="${url}dossier/add" class="nav-link text-white">
        <svg class="bi me-2" width="16" height="16"><use xlink:href="#address-book"/></svg>
        New Dossier
      </a>
    </li>
    <li>
      <a href="#" class="nav-link text-white">
        <svg class="bi me-2" width="16" height="16"><use xlink:href="#table"/></svg>
        Dossiers
      </a>
    </li>
    <li>
      <a href="#" class="nav-link text-white">
        <svg class="bi me-2" width="16" height="16"><use xlink:href="#users"/></svg>
        Patients
      </a>
    </li>
  </ul>
  <div>
    <a href="#" class="d-flex align-items-center text-white text-decoration-none">
      <a href="#" class="nav-link" style="color: #17A2B8">
        <svg class="bi me-2" width="16" height="16"><use xlink:href="#logout"/></svg>
        <strong>Logout</strong>
      </a>
    </a>
  </div>
</aside>
