import './App.css';
import React from "react";
import Home from './pages/home/Home';
import SignUp from './pages/SignUp/SignUp';
import Login from './pages/Login/Login';
import { createBrowserRouter, RouterProvider } from "react-router-dom"


function App() {
  const router = createBrowserRouter([
    {
      path: "/",
      element: <Login />,
    },
    {
      path: "/login",
      element: <Login />,
    },
    {
      path: "/signup",
      element: <SignUp />,
    },
    {
      path:"/Home",
      element:<Home />,
    }
   
  ]);

  return <>
  <RouterProvider router={router} />  
  </>
  
}

export default App;

