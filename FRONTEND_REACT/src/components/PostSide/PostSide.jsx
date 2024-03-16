import React from "react";
import Posts from "../Posts/Posts";
import ProfileCard from "../ProfileCard/ProfileCard";

import "./PostSide.css";
const PostSide = () => {
  return (
    <div className="PostSide card-container ">
      <ProfileCard />
      <Posts />
    </div>
  );
};

export default PostSide;
