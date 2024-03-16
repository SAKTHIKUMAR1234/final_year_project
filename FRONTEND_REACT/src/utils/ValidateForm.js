import setError from "./setError";
import setSuccess from "./setSuccess";
let flag_valid = false;

const formValidate = async (id) => {
  const elementName = id;
  const field = document.querySelector(`#${elementName}`);

  //regex constants
  const alphaExp = /^[a-zA-Z]+$/;
  const exp = /^[0-9]+$/;
  const emailExp = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

  switch (elementName) {
    case "username":
      if (field.value === "") {
        setError(field, "*UserName is required");
        flag_valid = false;
      } else if (!field.value.match(alphaExp)) {
        setError(field, "*Enter only Aphabets");
        flag_valid = false;
      } else {
        setSuccess(field);
        flag_valid = true;
      }

      break;
    case "fname":
      if (field.value === "") {
        setError(field, "*FullName is required");
        flag_valid = false;
      } else if (!field.value.match(alphaExp)) {
        setError(field, "*Enter only Aphabets");
        flag_valid = false;
      } else {
        setSuccess(field);
        flag_valid = true;
      }

      break;
    case "lname":
      if (field.value === "") {
        setError(field, "*LastName is required");
        flag_valid = false;
      } else if (!field.value.match(alphaExp)) {
        setError(field, "*Enter only Aphabets");
        flag_valid = false;
      } else {
        setSuccess(field);
        flag_valid = true;
      }

      break;
    case "mobile":
      if (field.value === "") {
        setError(field, "*Mobile Number is required");
        flag_valid = false;
      } else if (!field.value.match(exp)) {
        setError(field, "*Enter only Numbers");
        flag_valid = false;
      } else if (field.value.length < 10) {
        setError(field, "*Enter a Valid Number");
        flag_valid = false;
      } else {
        setSuccess(field);
        flag_valid = true;
      }
      break;
    case "email":
      if (field.value === "") {
        setError(field, "*Email is required");
        flag_valid = false;
      } else if (!field.value.match(emailExp)) {
        setError(field, "*Enter a Valid Email");
        flag_valid = false;
      } else {
        setSuccess(field);
        flag_valid = true;
      }
      break;
    case "dob":
      if (field.value === "") {
        setError(field, "*Date is required");
        flag_valid = false;
      } else {
        setSuccess(field);
        flag_valid = true;
      }
      break;

    case "password":
      if (field.value === "") {
        setError(field, "*Password is required");
        flag_valid = false;
      } else if (field.value.length < 4 ) {
        setError(field, "*Minimum 4 digits required");
        flag_valid = false;
      } else {
        setSuccess(field);
        flag_valid = true;
      }

      break;

    default:
      alert("error--from validateform", elementName);
      console.log(elementName);
  }

  return flag_valid;
};

const valid = async (li, users) => {
  let flag = true;
  const field = document.querySelector(".check-box");
  const accField = document.querySelector(".acc-type");
  const genderField = document.querySelector(".gender-radio");
  console.log("click--", users);

  if (li.length < 3) {
    flag = false;
    alert("Please select atleast 3 fields");
  } else {
    setSuccess(field);
  }

  if (users.accountType != "") {
    setSuccess(accField);
  } else {
    setError(accField, "*required");
    flag = false;
  }
  if (users.gender != "") {
    setSuccess(genderField);
  } else {
    setError(genderField, "*required");
    flag = false;
  }
  console.log(flag_valid);
  if (flag_valid) {
    return flag;
  }
  return flag;
};
export { valid };
export default formValidate;
