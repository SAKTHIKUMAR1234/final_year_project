import React, { useEffect, useState } from "react";
import "./CourseRecommendation.css";
import { Button } from "../Button/Button";
import { useSelector } from "react-redux";
import axios from "axios";
const CourseRecommendation = () => {
  const [recommended_Users,setRecommendedUsers] = useState([])

  const currentUser = JSON.parse(sessionStorage.getItem("userId"))
  const [isDisabled, setDisabled] = useState(true)

  useEffect(()=>{
    get_current_trends()
  },[])

  const get_current_trends = async ()=>{
    const res = await axios.get('http://localhost:5005/recommendation/get_current_trended_courses')
    setRecommendedUsers(res.data)
  }


  const makeFollowRequest =async (link) => {
    window.open(link,'_blank')
  }

  return (
    <div className="FollowersCard card-container">
      <h2>The Current Trend Course Url</h2>
      <div className="coverBox">
        {recommended_Users.map((recommended, id) => {
          return (
            <div className="follower follow-container" id={id}>
              <div className="make_centre">
                <div className="follower-username">
                  {recommended.title}
                </div>
              </div>
              <button className="button follow-button" isDisabled={isDisabled} onClick={()=>makeFollowRequest(recommended.link)}>Open</button>
            </div>
          );
        })}
      </div>
    </div>
  );


};

export default CourseRecommendation;
