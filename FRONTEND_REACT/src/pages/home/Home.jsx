import React, { useEffect } from "react";
import PostSide from "../../components/PostSide/PostSide";
import ProfileSide from "../../components/profileSide/ProfileSide";
import RightSide from "../../components/RightSide/RightSide";
import "./Home.css";
import { useDispatch, useSelector } from "react-redux";
import { getConnectionCount, getPostCount, getUser } from "../../Reducers/userDetailsSlice";
import { notificationList, recommendedUser } from "../../Reducers/recommendationListsSlice";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { useId } from "react";
import { recommendedPosts } from "../../Reducers/postsSlice";

const Home = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const header = JSON.parse(sessionStorage.getItem("AuthHead"))
  const userId = JSON.parse(sessionStorage.getItem('userId'))


  useEffect(() => {
    if (!header) {
      console.error("UnAuthorized");
      navigate('/login', { replace: true })
    }
    else {
      dispatch(getUser(userId));
      dispatch(recommendedUser(userId));
      dispatch(getConnectionCount(userId));
      dispatch(getPostCount(userId));
      dispatch(notificationList(userId));
      dispatch(recommendedPosts(userId));
    }
  }, []);


  const user_data = useSelector((state) => {
    return state.userDetails.user_data;
  });
  return (
    <div className="Home">
      <ProfileSide />
      <PostSide />
      <RightSide />
    </div>
  );
};

export default Home;
