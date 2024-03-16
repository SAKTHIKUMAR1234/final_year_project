import React, { useState, useEffect } from "react";
import "./InfoCard.css";
import {GrEdit} from "react-icons/gr"
import ProfileModal from "../ProfileModal/ProfileModal";
import { Button } from "../Button/Button";
import { useDispatch, useSelector } from "react-redux";
import { updateUser } from "../../Reducers/userDetailsSlice";
import { useNavigate } from "react-router-dom";

const InfoCard = () => {
  const dispatch = useDispatch();
  useEffect(() => {
    dispatch(updateUser(user_data));
  },[]);

  const navigate = useNavigate()

  const user_data = useSelector((state) => {
    return state.userDetails.user_data;
  });

  const [modalOpened, setModalOpened] = useState(false);
  return (
    <div className="InfoCard card-container ">
      <div className="infoHead ">
        <h3>Your Info</h3>
        <div>
          <Button className="button option-button" icon={<GrEdit size={25} onClick={() => setModalOpened(true)} />} />
          
          <ProfileModal
            old_data={user_data}
            modalOpened={modalOpened}
            setModalOpened={setModalOpened}
          />
        </div>
      </div>
      {/* <h2>{user_data.firstName}FirstName</h2> */}

      <div className="info">
        <span >
          <b>@UserName : </b>
          {user_data.userName}
        </span>
      </div>

      <div className="info">
        <span >
          <b>DateOfBirth : </b>
          {(user_data.dateOfBirth)}
        </span>
      </div>

      <Button className="button logout-button" text="LogOut"  onClick={()=>{
        sessionStorage.clear()
        navigate('/login')
      }}/>
    </div>
  );
};

export default InfoCard;
