const name = document.getElementById("name");
const password = document.getElementById("password");
const repeatPassword = document.getElementById("repeatPassword");
const idCard = document.getElementById("idCard");
const birthDate = document.getElementById("birthDate");
const email = document.getElementById("email");
const telephone = document.getElementById("telephone");
const country = document.getElementById("country");

const liberty = document.getElementById("Liberty");
const coccor = document.getElementById("Coccor");
const pipera = document.getElementById("Pipera");
const vitan = document.getElementById("Vitan");
let subscription = document.getElementById("subName");

const student = document.getElementById("Student");
const normal = document.getElementById("Normal");
const family = document.getElementById("Family");
let gym = document.getElementById("gymName");

liberty.onclick = () => {
    gym.value = "Liberty";
}
coccor.onclick = () => {
    gym.value = "Coccor";
}
pipera.onclick = () => {
    gym.value = "Pipera";
}
vitan.onclick = () => {
    gym.value = "Vitan";
}

student.onclick = () => {
    subscription.value = "Student";
}

normal.onclick = () => {
    subscription.value = "Normal";
}

family.onclick = () => {
    subscription.value = "Family";
}

function validateName(name){
    console.log(name);
    const regExp = /^[a-zA-Z\s]+$/;
    console.log("Name is: " + regExp.test(name));

    if(!regExp.test(name)){
        alert("Name field wrong, it must contain only letters!");
        return 0;
    }
}

function validatePassword(password, repeatPassword){
    console.log("Password is: " + (password === repeatPassword));

    if(!password.toString.length > 5){
        if(password !== repeatPassword){
            alert("Passwords must be the same!");
            return 0;
        }
        alert("Password must be at lest 5 characters long!");
        return 0;
    }
}

function validateIdCard(idCard){
    const regExp = /^\d{9}[A-Z]$/;
    console.log("IdCard is: " + regExp.test(idCard));

    if(!regExp.test(idCard)){
        alert("Wrong ID Card format, it must contain 9 numbers followed by a capital letter");
        return 0;
    }

    return 1;
}

function validateBirthDate(birthDate){
    console.log("BirthDate is: " + birthDate);
    let age = Year.now().getValue() - Long.parseLong(birthDate.toString().substring(0, 4));

    if(birthDate){
        if(age >= 16){
            alert("You must be at least 16 years old!");
            return 0;
        }

        alert("Birth date field is empty!");
        return 0;
    }

    return 1;
}

function validateEmail(email){
    const regExp = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    console.log("Email is: " + regExp.test(email));

    if(!regExp.test(email)){
        alert("Wrong email format!");
        return 0;
    }

    return 1;
}

function validateTelephone(telephone){
    let regExp = /^[0-9\+]\d+/;
    console.log("Telephone is: " + regExp.test(telephone));

    if(!regExp.test(telephone)){
        alert("Wrong telephone format!");
        return 0;
    }

    return 1;
}

function validateCountry(country){
    console.log("Country is: " + country)

    if(!country){
        alert("You must select a country!");
        return 0;
    }

    return 1;
}

function validate(){
    console.log("Validate: " + (validateName(name.value) &&
        validatePassword(password.value, repeatPassword.value) &&
        validateIdCard(idCard.value) &&
        validateBirthDate(birthDate.value) &&
        validateEmail(email.value) &&
        validateTelephone(telephone.value) &&
        validateCountry(country.value)));

    return validateName(name.value) &&
        validatePassword(password.value, repeatPassword.value) &&
        validateIdCard(idCard.value) &&
        validateBirthDate(birthDate.value) &&
        validateEmail(email.value) &&
        validateTelephone(telephone.value) &&
        validateCountry(country.value);
}

function selectRow(cell) {
    // Remove 'selected' class from all rows
    var rows = document.getElementsByName('row');
    for (var i = 0; i < rows.length; i++) {
        rows[i].classList.remove('selected');
    }

    // Add 'selected' class to the clicked row
    cell.classList.add('selected');
    console.log(cell.id);
}

function selectColumn(cell){
    // Remove 'selected' class from all rows
    var columns = document.getElementsByName('column');
    for (var i = 0; i < columns.length; i++) {
        columns[i].classList.remove('selected');
    }

    // Add 'selected' class to the clicked row
    cell.classList.add('selected');
    console.log(cell.id);
}
