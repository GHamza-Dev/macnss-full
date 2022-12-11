let searchMedication = document.querySelector('.search-medication');
let addMedicationBtn = document.querySelector('.add-medication-btn');
let selectedMedications = document.querySelector('.selected-medications');

let selectSpeciality = document.querySelector('.select-speciality');
let addSpecialityBtn = document.querySelector('.add-speciality-btn');
let selectedSpecialities = document.querySelector('.selected-specialities');

let selectAnalysis = document.querySelector('.select-analysis');
let addAnalysisBtn = document.querySelector('.add-analysis-btn');
let selectedAnalyses = document.querySelector('.selected-analyses');

let selectRadio = document.querySelector('.select-radio');
let addRadioBtn = document.querySelector('.add-radio-btn');
let selectedRadios = document.querySelector('.selected-radios');

let searchPatient = document.querySelector('.search-patient');
let addPatientBtn = document.querySelector('.add-patient-btn');
let selectedPatient = document.querySelector('.selected-patient');


let url = 'http://localhost:8080/macnss/';

addPatientBtn.addEventListener('click',async (e)=>{

    e.preventDefault();

    let patientNumber = searchPatient.value;

    if(!patientNumber || patientNumber == ''){
        alert("Please enter the patient number!");
        return;
    }

    let res = await fetch(`${url}patient/search-patient/${patientNumber}`);
    let patient = await res.json();

    if(!patient || patient == null){
        alert(`No patient found with the patient number: ${patientNumber}`);
        return;
    }

    let newInput = `${itemSkeleton(`[#${patient.patientNumber}] ${patient.username} - ${patient.email}`,'user','patient-id',patient.id)}`;

    selectedPatient.innerHTML = `${newInput}`;
})

addRadioBtn.addEventListener('click',(e)=>{

    e.preventDefault();

    let radioId = selectRadio.value;
    let radioLabel = selectRadio.selectedOptions[0].innerText


    let existedInputs = selectedRadios.innerHTML;
    let newInput = `${itemSkeleton(radioLabel,'radio','radio',radioId)}`;

    selectedRadios.innerHTML = `${existedInputs} ${newInput}`;
})

addAnalysisBtn.addEventListener('click',(e)=>{

    e.preventDefault();

    let analysisId = selectAnalysis.value;
    let analysisLabel = selectAnalysis.selectedOptions[0].innerText


    let existedInputs = selectedAnalyses.innerHTML;
    let newInput = `${itemSkeleton(analysisLabel,'syringe','analysis',analysisId)}`;

    selectedAnalyses.innerHTML = `${existedInputs} ${newInput}`;
})

addSpecialityBtn.addEventListener('click',(e)=>{

    e.preventDefault();

    let specialityId = selectSpeciality.value;
    let specialityLabel = selectSpeciality.selectedOptions[0].innerText


    let existedInputs = selectedSpecialities.innerHTML;
    let newInput = `${itemSkeleton(specialityLabel,'user-doctor','speciality',specialityId)}`;

    selectedSpecialities.innerHTML = `${existedInputs} ${newInput}`;
})

addMedicationBtn.addEventListener('click',async (e)=>{

    e.preventDefault();

    let barCode = searchMedication.value;

    if(!barCode || barCode == ''){
        alert("Please enter a medication code bar!");
        return;
    }

    let res = await fetch(`${url}dossier/search-medication/${barCode}`);
    let medication = await res.json();

    if(!medication || medication == null){
        alert(`No medication found with the bar code: ${barCode}`);
        return;
    }

    let existedInputs = selectedMedications.innerHTML;
    let newInput = `${itemSkeleton(medication.name,'medication','bar-code',medication.id)}`;

    selectedMedications.innerHTML = `${existedInputs} ${newInput}`;
})



function itemSkeleton(label,iconId,inputName,inputValue){
    return `
        <div class="col d-flex align-items-center justify-content-between p-3 border rounded-3">
            <div class="d-flex align-items-center">
                <svg class="bi text-success" width="25" height="25"><use xlink:href="#${iconId}"/></svg>
                <p class="m-0 ms-2">${label}</p>
            </div>
            <span class="remove-item">
                <svg class="bi text-black-50" width="25" height="25"><use xlink:href="#xmark"/></svg>
            </span>
            <input type="number" name="${inputName}" class="form-control" value="${inputValue}" hidden>
        </div>
    `;
}