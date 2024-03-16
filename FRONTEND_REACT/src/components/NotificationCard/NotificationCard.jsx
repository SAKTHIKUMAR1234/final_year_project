import React, { useState } from "react";
import { Button } from "../Button/Button";
import { useSelector } from "react-redux";
import axios from "axios";
import "./NotificationCard.css";

const NotificationCard = () => {
  const clearNotification = async () => {
    try {
      const userId = JSON.parse(sessionStorage.getItem("userId"));
      if (window.confirm("Are you sure to clear the notifications!!")) {
        const result = await axios({
          method: "DELETE",
          url: `http://localhost:8080/api/v1/notifyUser/clearNotifications/${userId}`,
          headers: {
            Authorization:
              "Bearer " +
              JSON.parse(sessionStorage.getItem("AuthHead")).Authorization,
          },
        }).then((res, err) => {
          window.location.reload(false);
        });
      }
    } catch (error) {
      console.log(error);
    }
  };

  const notify_list = useSelector((state) => {
    console.log(state.followSuggestion.notify_list);
    return state.followSuggestion.notify_list;
  });
 
  

  return (
    <div className="NotificationCard card-container">
      <div className="card-top">
        <h2>Notification</h2>
     
          <Button
            className="button logout-button reject "
            onClick={clearNotification}
            text="Clear"
          />
       
      </div>

      <div className="coverBox">
        

        {notify_list.map((user, id) => {
          return (
            <div className="follower follow-container">
              <div>
                <div className="notify-content">
                  <span>{user.content}</span>
                </div>
              </div>
            </div>
          );
        })}
      </div>
    </div>
  );
};

export default NotificationCard;
