import React from 'react'
import FollowersCard from '../FollowersCard/FollowersCard'
import LogoSearch from '../LogoSearch/LogoSearch'

import "./ProfileSide.css"
import InfoCard from '../InfoCard/InfoCard'
const ProfileSide = () => {
  return (
    <div className="ProfileSide card-container">
        <LogoSearch/>
        <InfoCard />
        <FollowersCard/>
    </div>
  )
}

export default ProfileSide