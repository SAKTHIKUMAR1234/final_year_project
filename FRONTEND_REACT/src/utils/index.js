import axios from "axios"

export const fetch_get=async(url)=>{
    const response=await axios(url, {
      method: "GET",
      headers : {
        "Authorization":"Bearer "+JSON.parse(sessionStorage.getItem("AuthHead")).Authorization
      }
    });
    return response
}

export const create_User = async (url,data)=>{
  const response = await fetch(url,{
    method: "POST",
    headers : {
      "Content-Type":"application/json",
    },
    body:JSON.stringify(data)
  });
  return response;
}

export const fetch_getNotAuth=async(url)=>{
  const response=await axios(url, {
    method: "GET",
    headers : {
"Content-Type":"application/json",
    }
  });

  return response
}


export const create_post = async (url,formData) =>{
  try {
    const response = await axios(url,{
      method:"POST",
      headers : {
        "Authorization":"Bearer "+JSON.parse(sessionStorage.getItem("AuthHead")).Authorization
      },
      data:formData
    })
    return response.data;
  } catch (error) {
  }
}

