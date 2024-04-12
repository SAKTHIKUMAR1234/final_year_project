import React, { useState, useEffect } from "react";
import "./chats.css";
import { IoMdArrowRoundBack } from "react-icons/io";
import { Modal, useMantineTheme } from "@mantine/core";
import axios from "axios";
import { Button } from "../Button/Button";
import { useMediaQuery } from "@mantine/hooks";


const Chats = ({ chatpop, setChatPopup }) => {
  const theme = useMantineTheme();
  const isMobile = useMediaQuery("(max-width:50em)");

  const userId = JSON.parse(sessionStorage.getItem('userId'))

  const [chats, setChats] = useState([]);
  const [searchQuery, setSearchQuery] = useState("");
  const [searchResults, setSearchResults] = useState([]);

  const [selectedUser, setSelectedUser] = useState(null);
  const [messages, setMessages] = useState([]);
  const [newMessage, setNewMessage] = useState("");
  const [userData, setUserData] = useState({});

  const handleUserClick = (user, userDetails) => {
    console.log(userDetails)
    setUserData(userDetails)
    setSelectedUser(user);
    setSearchResults([]);
  };

  const handleSearch = async () => {
    if (searchQuery.trim() !== "") {
      try {
        const response = await axios.get(`http://localhost:8080/api/v1/userdetails/searchUser/${searchQuery}`, {
          headers: {
            "Authorization": "Bearer " + JSON.parse(sessionStorage.getItem("AuthHead")).Authorization
          }
        }
        );
        setSearchResults(response.data.body);
      } catch (error) {
        console.error("Error searching for users:", error);
      }
    } else {
      setSearchResults([]);
    }
  };

  useEffect(() => {
    const fetchChats = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/api/v1/message/getChatList/${userId}`, {
          headers: {
            "Authorization": "Bearer " + JSON.parse(sessionStorage.getItem("AuthHead")).Authorization
          }
        });
        setChats(response.data);
      } catch (error) {
        console.error("Error fetching chats:", error);
      }
    };

    fetchChats();
  }, []);

  useEffect(() => {
    let intervalId;

    const data = {
      "user1": userId,
      "user2": selectedUser
    }
    const fetchMessages = async () => {
      if (selectedUser) {
        try {
          const response = await axios({
            method: "POST",
            url: `http://localhost:8080/api/v1/message/getChats`,
            headers: {
              Authorization: "Bearer " + JSON.parse(sessionStorage.getItem("AuthHead")).Authorization
            },
            data: data
          });
          // console.log(response.data.body)
          setMessages(response.data.body);
        } catch (error) {
          console.error("Error fetching messages:", error);
        }
      }
    };

    const startPolling = () => {
      fetchMessages();
      intervalId = setInterval(() => {
        // console.log("POLLED")
        fetchMessages();
      }, 5000);
    };

    const stopPolling = () => {
      clearInterval(intervalId);
    };

    if (selectedUser) {
      startPolling();
    } else {
      stopPolling();
    }

    return stopPolling;
  }, [selectedUser]);

  const sendMessage = async () => {
    if (newMessage.trim() !== "") {
      // setMessages([...messages, { text: newMessage, sender: "me" }]);
      const data = {
        "user1": {
          "userId": userId
        },
        "user2": {
          "userId": selectedUser
        },
        "content": newMessage

      }
      const response = await axios({
        method: "POST",
        url: `http://localhost:8080/api/v1/message/addChat`,
        headers: {
          Authorization: "Bearer " + JSON.parse(sessionStorage.getItem("AuthHead")).Authorization
        },
        data: data
      });
      setNewMessage("");
    }
  };

  return (
    <>
      <Modal
        overlayColor={
          theme.colorScheme === "dark"
            ? theme.colors.dark[9]
            : theme.colors.gray[6]
        }
        withCloseButton={false}
       size="auto"
       fullscreen={isMobile}
        padding="0%"
        centered
        opened={chatpop}
        onClose={()=> setChatPopup(false)}
      >
        <div className="FollowersCard1">
          <div className="heading"></div>
          <div className="chat-box">
            <div id="container">
              <aside>
                <header>
                  <div className="back-btn">
                    <IoMdArrowRoundBack
                      size={30}
                      color="white"
                      onClick={setChatPopup}
                   />
                  </div>
                  <input
                    type="text"
                    placeholder="Search"
                    value={searchQuery}
                    onChange={(e) => { setSearchQuery(e.target.value) }}
                  />
                  <Button className="button" onClick={handleSearch} text="Search" />
                </header>
                <ul>
                  {!searchQuery ? (
                    chats.map((user) => (
                      <li key={user.user2.userId} className="box" onClick={() => handleUserClick(user.user2.userId, user.user2)}>
                        
                        <Button text={user.avatarText} className="button profile-image" />
                        <div>
                          <h2>{user.user2.userName}</h2>
                        </div>
                      </li>
                    ))
                  ) : (
                    searchResults.map((user) => (
                      <li key={user.userId}  onClick={() => handleUserClick(user.userId, user) }>
                        <img
                          src={user.profileImage}
                          className="profile-image"
                          alt=""
                        />
                        <div>
                          <h2>{user.userName}</h2>
                        </div>
                      </li>
                    ))
                  )}
                </ul>
              </aside>
              <main>
                {selectedUser ? (
                  <header>
                    {/* <img src="http://localhost:8080/images/userprofile.png" alt="" /> */}
                    <div>
                      <h1>{userData.userName}</h1>
                    </div>
                    {/* <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/ico_star.png" alt=""></img> */}
                  </header>
                ) : (
                  <p className="chatbox">Select a user to start a chat.</p>
                )}
                <ul id="chat">
                  {selectedUser &&
                    messages.map((message, index) => (
                      <div>
                        <li key={message.id + "1"} className={message.user1.userId === userId ? "me" : "you"}>
                          <div className="entete">
                            <span className="status green"></span>
                            <h2>{message.sender}</h2>
                          </div>
                          <div className="triangle"></div>
                          <div className="message">{message.content}</div>
                        </li>
                      </div>

                    ))}
                </ul>
                {selectedUser && (
                  <footer>
                    <textarea
                      placeholder="Type your message"
                      value={newMessage}
                      onChange={(e) => setNewMessage(e.target.value)}
                      className="chatbox"
                    />
                    <button className="button send-button" onClick={sendMessage}>
                      Send
                    </button>
                  </footer>
                )}
              </main>
            </div>
          </div>
        </div>
      </Modal>
    </>
  );
};

export default Chats;
