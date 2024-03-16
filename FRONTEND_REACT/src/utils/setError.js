const setError = (field, msg) =>{

    const inputGroup = field.parentElement;
    const errorElement = inputGroup.querySelector('.errormsg')
    errorElement.innerText = msg;

    inputGroup.classList.add('error')
    inputGroup.classList.remove('success')


   
  }
    //setting success 
 
    
  export default setError;
  
 