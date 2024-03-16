import React, { useState, useEffect } from "react";
import "./SignUp.css";
import { Link, useNavigate } from "react-router-dom";
import formValidate, { valid } from "../../utils/ValidateForm";
import { Button } from "../../components/Button/Button";
import "../../components/Button/Custom-btn.css";
import { useDispatch, useSelector } from "react-redux";
import { showList } from "../../Reducers/interestListsSlice";
import { createUser } from "../../Reducers/userDetailsSlice";

function SignUp() {
  let [li, setLi] = useState([]);
  const navigate = useNavigate();
  const [popup, setPopup] = useState(false);
 
  const [users, setUsers] = useState({});
  const dispatch = useDispatch();
 
  useEffect(() => {
    dispatch(showList());
  }, []);
  const lists = useSelector((state) => {
    return state.list_interest.lists;
  });
  


  //x

  //to display interest field
  const handleclickopen = (e) => {
    e.preventDefault();
    setPopup(true);
  };
  //adds all fields and data
  const getUserData = (e) => {
    setUsers({ ...users, [e.target.name]: e.target.value });
    console.log(users);
  };
  //add interest data
  const getUserDataInterests = (e) => {
    if (!e.target.checked) {
      console.log(e.target.checked, "--1--");
      li.splice(li.indexOf(e.target.value), 1);
      setUsers({ ...users, interests: li });
    } else {
      console.log(e.target.checked, "--2---");
      li.push({ interestId: e.target.value });
      setUsers({ ...users, interests: li });
    }
  };
  //runs after submit
  const OnRegister = (e) => {
    e.preventDefault();
    //checks validation 
    console.log(valid(li,users));
    if (valid(li, users)) {
      console.log("-----", users);
      dispatch(createUser(users));
      navigate("/login");
    }
    else{
      alert("Please fill All fields.")
    }
  };
  return (
    <>
      <section>
        <div className="container">
          <h1>SignUp</h1>
          <form id="form">
            <div className="row100">
              <div className="col">
                <div className="inputBox">
                  <input
                    type="text"
                    id="username"
                    name="userName"
                    onChange={getUserData}
                    onBlur={(e) => formValidate(e.target.id)}
                    autoComplete="off"
                  />
                  <span className="text">UserName</span>
                  <span className="line"></span>
                  <div className="errormsg"></div>
                </div>
              </div>
              <div className="col">
                <div className="inputBox">
                  <input
                    type="text"
                    id="fname"
                    name="firstName"
                    onChange={getUserData}
                    onBlur={(e) => formValidate(e.target.id)}
                    autoComplete="off"
                  />
                  <span className="text">First Name</span>
                  <span className="line"></span>
                  <div className="errormsg"></div>
                </div>
              </div>
              <div className="col">
                <div className="inputBox">
                  <input
                    type="text"
                    id="lname"
                    name="lastName"
                    onChange={getUserData}
                    onBlur={(e) => formValidate(e.target.id)}
                    autoComplete="off"
                  />
                  <span className="text">Last Name</span>
                  <span className="line"></span>
                  <div className="errormsg"></div>
                </div>
              </div>
            </div>

            <div className="row100">
              <div className="col">
                <div className="inputBox">
                  <input
                    type="text"
                    id="email"
                    name="email"
                    onChange={getUserData}
                    onBlur={(e) => formValidate(e.target.id)}
                    autoComplete="off"
                  />
                  <span className="text">Email</span>
                  <span className="line"></span>
                  <div className="errormsg"></div>
                </div>
              </div>
              <div className="col">
                <div className="inputBox">
                  <input
                    type="password"
                    id="password"
                    name="password"
                    onChange={getUserData}
                    onBlur={(e) => formValidate(e.target.id)}
                    autoComplete="off"
                  />

                  <span className="text">Password</span>
                  <span className="line"></span>
                  <div className="errormsg"></div>
                </div>
              </div>

              <div className="col">
                <div className="inputBox">
                  <input
                    type="text"
                    id="mobile"
                    name="phNo"
                    onChange={getUserData}
                    onBlur={(e) => formValidate(e.target.id)}
                    autoComplete="off"
                    maxLength="10"
                  />
                  <span className="text">Mobile</span>
                  <span className="line"></span>
                  <div className="errormsg "></div>
                </div>
              </div>
            </div>

            <div className="row100">
              <div className="col">
                <div className="inputBox">
                  <input
                    type="date"
                    id="dob"
                    name="dateOfBirth"
                    onChange={getUserData}
                    onBlur={(e) => formValidate(e.target.id)}
                    max={new Date().toISOString().split("T")[0]}
                    autoComplete="off"
                  />

                  <span className="text">Date Of Birth</span>
                  <span className="line"></span>
                  <div className="errormsg"></div>
                </div>
              </div>
              <div className="col">
                <div className="inputBox p-3 ">
                  <div className="radio-group ">
                    <input
                      type="radio"
                      id="Male"
                      name="gender"
                      value="Male"
                      className="gender-radio"
                      onChange={getUserData}
                    />
                    <label htmlFor="Male" className="radio-label">
                      Male
                    </label>

                    <input
                      type="radio"
                      id="Female"
                      name="gender"
                      className="gender-radio"
                      value="Female"
                      onChange={getUserData}
                    />
                    <label htmlFor="Female" className="radio-label">
                      Female
                    </label>
                    <div className="errormsg errormsg-radio"></div>
                  </div>

                  <span
                    className="text text-2"
                    style={{ position: "relative", top: "-65px" }}
                  >
                    Gender
                  </span>
                </div>
              </div>
              <div className="col">
                <div className="inputBox p-3 ">
                  <div className="radio-group ">
                    <input
                      type="radio"
                      id="Private"
                      className="acc-type"
                      name="accountType"
                      value="private"
                      onChange={getUserData}
                    />
                    <label htmlFor="Private" className="radio-label">
                      Private
                    </label>

                    <input
                      type="radio"
                      id="Public"
                      name="accountType"
                      className="acc-type"
                      value="public"
                      onChange={getUserData}
                    />
                    <label htmlFor="Public" className="radio-label">
                      Public
                    </label>
                    <div className="errormsg errormsg-radio"></div>
                  </div>

                  <span
                    className="text text-2"
                    style={{ position: "relative", top: "-65px" }}
                  >
                    Account Type
                  </span>
                </div>
              </div>
            </div>
            <div className="row100">
              <div className="col">
                <button
                  onClick={handleclickopen}
className={"interest-button"}    text="  Select Your Intrested Fields..."            >
                  Select Your Intrested Fields...
                </button>

                {popup ? (
                  <div className=" inputBox-list ">
                    <div className=" row100 check-group">
                      {lists.length > 0 &&
                        lists.map((tag, index) => {
                          return (
                            <div key={index}>
                              <input
                                type="checkbox"
                                key={index}
                                id={tag[0]}
                                className="check-box"
                                name="interestId"
                                value={tag[0]}
                                onClick={getUserDataInterests}
                              />
                              <label htmlFor={tag[0]} className="check-label">
                                {tag[1]}
                              </label>
                              <div
                                className="errormsg errormsg-checkbox"
                                style={{ position: "absolute", top: "380px" }}
                              ></div>
                            </div>
                          );
                        })}
                    </div>
                  </div>
                ) : (
                  ""
                )}
              </div>
            </div>

            <div className="row100 ">
              <div className="col center">
                <Button
                  type="submit"
                  text="Create"
                  className="button login-button "
                  onClick={(e)=>{OnRegister(e)}}
                />
                <br/>
                <Link to="/login">Already Have an Account ? Login Now</Link>

              </div>
            </div>
            
          </form>
        </div>
      </section>
    </>
  );
}

export default SignUp;
