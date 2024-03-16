import React from 'react'
import {GrSearch} from "react-icons/gr"
import './LogoSearch.css'
import { Button } from '../Button/Button'
import logo from "../../img/logo.png"

const LogoSearch = () => {
 return (
 <div className="LogoSearch">
 <div className="logo-img">
 <img className='logo_img' src={logo} alt="alt-text"/>
 </div>
 
 <div className="Search">
 
 <input type="text" name="search" className='search-bar' placeholder='#Explore' />
 
 <Button className={"option-button button"} icon={ <GrSearch size={25}/>}/>
 
 </div>

 </div>
 )
}

export default LogoSearch