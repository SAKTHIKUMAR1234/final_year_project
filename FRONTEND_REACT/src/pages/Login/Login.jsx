import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import setError from "../../utils/setError";
import setSuccess from "../../utils/setSuccess";
import "./Login.css";
import { Button } from "../../components/Button/Button";

import { useGoogleLogin } from '@react-oauth/google';
import axios from "axios";
import logo from "../../img/google-logo.png"

function Login() {
  const navigate = useNavigate();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const login_google = useGoogleLogin({
    onSuccess: tokenResponse => {
      axios.get(`https://www.googleapis.com/oauth2/v1/userinfo?access_token=${tokenResponse.access_token}`).then(async (res) => {
        try {
          const responce = await axios.post('http://localhost:8080/api/v1/userdetails/oauthUser/' + res.data.email);
          console.log(responce.data)
          const header = {
            "Authorization": responce.data.accessToken
          }
          sessionStorage.setItem("AuthHead", JSON.stringify(header));
          sessionStorage.setItem("userId",JSON.stringify(responce.data.userId))
          navigate('/home',{replace:true})
          console.log(tokenResponse.access_token)
        } catch (error) {
          alert("User Not Found Please Sign-up");
          navigate('/signup', { replace: true })
          console.log(error)
        }

      })
    },
    onError: (error) => console.log(error)
  });

  function validateEmail(email) {
    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    return emailRegex.test(email);
  }



  const login = async (e) => {
    e.preventDefault()
    if (email == "" || password == "") {
      alert("All Values are required")
      return
    }
    else {
      if (validateEmail(email)) {
        const data = {
          "email": email,
          "password": password
        }

        try {
          const response = await axios.post('http://localhost:8080/api/v1/userdetails/loginAuth', data);
          const header = {
            "Authorization": response.data.accessToken
          }
          sessionStorage.setItem("AuthHead", JSON.stringify(header));
          sessionStorage.setItem("userId",response.data.userId)
          navigate('/home',{replace:true})
        } catch (error) {
          if (error.response.status === 404) {
            alert("User Not Found Please Sign-up");
            navigate('/signup', { replace: true })
          }
          else{
            alert("Wrong Password")
            return 
          }
        }
      }
      else {

      }
    }
  }





  return (
    <>
      <section>
        <div className="container-login">
          <h1>Login</h1>

          <form id="form">
            <div className="row100">
              <div className="col">
                <div className="inputBox">
                  <input
                    type="text"
                    value={email}
                    id="email"
                    name="email"
                    data-testid="input-email"
                    onChange={(e) => setEmail(e.target.value)}
                    autoComplete="off"
                  />
                  <span className="text">Email</span>
                  <span className="line"></span>
                  <div className="errormsg"></div>
                </div>
              </div>
            </div>
            <div className="row100">
              <div className="col">
                <div className="inputBox">
                  <input
                    type="password"
                    value={password}
                    id="password"
                    name="password"
                    data-testid="input-password"
                    onChange={(e) => setPassword(e.target.value)}
                    autoComplete="off"
                  />
                  <span className="text">Password</span>
                  <span className="line"></span>
                  <div className="errormsg"></div>
                </div>
              </div>
            </div>
            <div className="row100 ">
              <div className="col center">
                <Button type="submit" text="Login" className="login-button button" onClick={login} />
                <a href = "http://localhost:8080/oauth2/authorization/google">check</a>

                <br />
                <Link to="/signup">New User ? Create An Account !</Link>
              </div>
              <div className="row100 col center">
                <button onClick={(e) => {
                  e.preventDefault()
                  login_google()
                }} className="login-button button">Log-In With <span>
                    <img width={"30px"} src={logo} alt="Google" />
                  </span></button>
              </div>
            </div>
          </form>
        </div>
      </section>
    </>
  );
}

export default Login;
