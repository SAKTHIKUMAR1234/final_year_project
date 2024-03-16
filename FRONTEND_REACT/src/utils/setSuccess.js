const setSuccess= (field) =>{
    const inputGroup = field.parentElement;
    const errorElement = inputGroup.querySelector('.errormsg')
    errorElement.innerText = '';

    inputGroup.classList.add('success')
    inputGroup.classList.remove('error')
  }
  export default setSuccess