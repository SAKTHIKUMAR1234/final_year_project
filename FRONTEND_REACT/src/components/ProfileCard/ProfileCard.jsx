import React from "react";
import "./ProfileCard.css";
import { useSelector } from "react-redux";

const ProfileCard = () => {
  const user_data = useSelector((state) => {
    return state.userDetails.user_data;
  });

  const connectCount = useSelector((state) => {
    return state.userDetails.connection_count;
  });
  const postCount = useSelector((state)=>{
    return state.userDetails.post_count;
  })


  // const ProfilePage = true;
  return (
    <div className="ProfileCard ">
      <div className="ProfileImages">
        <img src="http://localhost:8080/images/default_cover.jpg" alt="alt-image" className="cover-image" />
      
        <img src={"http://localhost:8080/images/" + (user_data.userProfile? user_data.userProfile : "user.png")} alt="alt-image" className="profile-image-big" />
      </div>

    
      <h1>{user_data.userName}</h1>

      <div className="followStatus">
        <hr />
        <div>
          <div className="follow">
            <span>{connectCount[0]}</span>
            <span>Followers</span>
          </div>
          <div className="vl"></div>
          <div className="follow">
            <span>{connectCount[1]}</span>
            <span >Following</span>
          </div>

          {/* {ProfilePage && (
            <> */}
              {/* <div className="vl"></div> */}
              {/* <div className="follow">
                <span>{postCount}</span>
                <span>Posts</span>
              </div> */}
            {/* </>
          )} */}
        </div>
        <hr />
      </div>
      {/* {ProfilePage ? "" : <span>My Profile</span>} */}
    </div>
  );
};

export default ProfileCard;
