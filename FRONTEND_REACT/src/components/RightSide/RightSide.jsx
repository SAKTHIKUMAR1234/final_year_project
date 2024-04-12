import React, { useState } from "react";
import "./RightSide.css";
import ShareModal from "../ShareModal/ShareModal";
import Chats from "../chats/Chats";
import { GrSettingsOption, GrChat, GrNotification } from "react-icons/gr";
import { useSelector } from "react-redux";
import { Button } from "../Button/Button";
import SettingsModal from "../SettingsModal.jsx/SettingsModal";
import RequestsCard from "../RequestsCard/RequestsCard";
import NotificationCard from "../NotificationCard/NotificationCard";
import FollowersCard from "../FollowersCard/FollowersCard";
import CourseRecommendation from "../CourseRecommendationCard/CourseRecommendation";

const RightSide = () => {
  const user_data = useSelector((state) => {
    return state.userDetails.user_data;
  });

  let flag = false;
  if (user_data.accountType === "Private") {
    flag = true;
  }

  const [modalOpened, setModalOpened] = useState(false);
  const [chatpop, setChatPopup] = useState(false);
  const chatpopUp = () => {
    setChatPopup(!chatpop);
  };
  const closeChats = () => {
    setChatPopup(false);
  };

  const [notify, setNotify] = useState(false);
  const displayNotification = () => {
    setNotify(!notify);
  };
  let clickedEdit = false;

  const [shareModal, setShareModal] = useState(false);

  return (
    <div className="RightSide card-container">
      <div className="navIcons ">
        <Button
          text="Chats"
          className="option-button button"
          onClick={chatpopUp}
          icon={<GrChat size={25} />}
        />
        <Button
          text="Notification"
          className="option-button button"
          onClick={displayNotification}
          icon={<GrNotification size={25} />}
        />
      </div>
      {chatpop ? (
        <div className="mainchats">
          <div className="chatpopup">
            <Chats chatpop={chatpop} setChatPopup={chatpopUp} />

            <div></div>
          </div>
        </div>
      ) : (
        ""
      )}

      {notify ? <NotificationCard /> : ""}
      <div></div>

      <RequestsCard />
      {/* <FollowersCard/>
       */}
      <CourseRecommendation/>

      {/* <Button
        text="Share a post..."
        className="button r-button"
        onClick={() => setShareModal(true)}
      /> */}

      {/* <ShareModal modalOpened={shareModal} setModalOpened={setShareModal} /> */}
    </div>
  );
};

export default RightSide;
