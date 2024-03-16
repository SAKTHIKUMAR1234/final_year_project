import React, { useState } from 'react'
import './Post.css'
import Comment from '../../img/comment.png'
import Share from '../../img/share.png'
import { LiaCommentSolid } from "react-icons/lia"
import {GrSend} from "react-icons/gr";
import { FcLike, FcLikePlaceholder } from "react-icons/fc"
import { Button } from '../Button/Button'

const Post = ({ data }) => {

  const [comment, setCommentPopup] = useState(false);
  const openCommentBox = () => {
    setCommentPopup(!comment)
  }
  const closeCommentBox = () => {
    setCommentPopup(false)
  }
  const [postComment, setPostComment] = useState('')
  const [postComments, setPostComments] = useState([])
  const clickPostChange = () => {
    setPostComments((comments) => [...postComments, postComment])
  }
  const changeHandlerComment = (e) => {
    setPostComment(e.target.value)

  }
  const [like_btn, setLike_btn] = useState(false);

  const changelike = () => {
    setLike_btn(!like_btn);
  }

  return (
    <div className="Post card-container">

      <img src={"http://localhost:8080/images/" + data.mediaContent} alt="alt-img" />

      <div className="postReact">
        <Button className="button post" icon={like_btn ? < FcLikePlaceholder size={30} /> : <FcLike size={30} />} onClick={changelike} />
        <Button onClick={openCommentBox} className='commentPopbutton post' icon={<LiaCommentSolid size={30} />} /><img src={Comment} alt="" />

        {comment ?


          <div className='commentPopup modal-container'>
            <div className='commentHeader'>
              <h1>CommentBox</h1>
              <h1 onClick={closeCommentBox}>X</h1>
            </div>

            <div className='middleOfComments'>
              {postComments.map((text) => (
                <div className='postingComment'>{text}</div>
              ))}
            </div>
            <div className='textareaComment'><textarea value={postComment} onChange={changeHandlerComment} className='inputBoxofComment' placeholder='Comment it' />
              <Button onClick={clickPostChange} className="button option-button"
                icon={<GrSend size={30} />} />
            </div>
          </div> : ''}

        <img src={Share} alt="" />
      </div>


      <span style={{ color: "var(--gray)", fontSize: '12px' }}>{data.likes} likes</span>

      <div className="detail">
        <span><b>{data.name}</b></span>
        <span> {data.desc}</span>
      </div>
    </div>
  )
}

export default Post