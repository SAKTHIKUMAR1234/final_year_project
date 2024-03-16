import React, { useEffect, useState } from "react";
import { Button } from "../Button/Button";
import axios from "axios";
const RequestsCard = () => {
  const [requestedUsers, setRequestedUsers] = useState([]);
  const userId = JSON.parse(sessionStorage.getItem("userId"));
  useEffect(() => {
    fetchRequestedUsers();
  }, []);

  const accept = async (targetId) => {
    const data = {
      sender: {
        userId: userId,
      },
      receiver: {
        userId: targetId,
      },
    };
    const result = await axios({
      method: "POST",
      url: `http://localhost:8080/api/v1/request/acceptedRequest`,
      headers: {
        Authorization:
          "Bearer " +
          JSON.parse(sessionStorage.getItem("AuthHead")).Authorization,
      },
      data: data,
    });

    // console.log("result---->", result.data);
    window.location.reload(false);
  };

  const reject = async (targetId) => {
    const data = {
      sender: {
        userId: userId,
      },
      receiver: {
        userId: targetId,
      },
    };

    const result = await axios({
      method: "POST",
      url: `http://localhost:8080/api/v1/request/rejectRequest`,
      headers: {
        Authorization:
          "Bearer " +
          JSON.parse(sessionStorage.getItem("AuthHead")).Authorization,
      },
      data: data,
    });
    window.location.reload(false);
  };

  const fetchRequestedUsers = async () => {
    const result = await axios({
      method: "POST",
      url: `http://localhost:8080/api/v1/request/getRequestedConnections/${userId}`,
      headers: {
        Authorization:
          "Bearer " +
          JSON.parse(sessionStorage.getItem("AuthHead")).Authorization,
      },
    });
    setRequestedUsers(result.data);
  };

  // const [requestCount, setRequestCount] = useState(false);

  // if (requestedUsers.length > 1) {
  //   setRequestCount(true);
  // }

  return (
    <div className="RequestsCard card-container">
      <h2>Requested Id's</h2>
      <div className="coverBox">
        {/* {requestCount ? "" : "No requests found"} */}

        {requestedUsers.map((user, id) => {
          return (
            <div className="follower follow-container">
              <div>
                <img
                  src={
                    "http://localhost:8080/" +
                    (user.sender.userProfile ? user.sender.userProfile : "user.png")
                  }
                  alt="alt-text"
                  className="profile-image"
                />
                <div className="follower-username">
                  <span>@ {user.sender.userName}</span>
                </div>
              </div>
              <div className="">
                <Button
                  className="button follow-button accept"
                  onClick={() => {
                    accept(user.sender.userId);
                  }}
                  text="Accept"
                />

                <Button
                  className="button follow-button reject"
                  onClick={() => {
                    reject(user.sender.userId);
                  }}
                  text="Reject"
                />
              </div>
            </div>
          );
        })}
      </div>
    </div>
  );
};

export default RequestsCard;
