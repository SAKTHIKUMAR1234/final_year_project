import React from 'react'
import './Posts.css'
import Post from '../Post/Post'
import { useSelector } from 'react-redux'


const Posts = () => {

  const posts_lists = useSelector((state) => {
    return state.posts.recommended_posts;
  })

  function isDateTimeLessThanOrEqualToCurrent(dateTimeString) {
    const dateTime = new Date(dateTimeString);
  
    const currentDateTime = new Date();
  
    return dateTime <= currentDateTime;
    
  }



  // console.log("-->",posts_lists);
  return (
    <div className="Posts">
        {/* {posts_lists.map((post, id)=>{
            if(isDateTimeLessThanOrEqualToCurrent(post.scheduledTime)){
              return <Post data={post} id={id}/>
            }
        })} */}
    </div>
    
  )
}

export default Posts