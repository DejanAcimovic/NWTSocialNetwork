import React from "react";
// import { Link } from "react-router-dom";
import Login from "../Login";
import Signup from "../Signup";

const HomePage = () => (
  <div>
    <div className="first-box">
        <Login>
        </Login>
        </div>
       <div className ="second-box">
         <Signup>
         </Signup>
       </div>
  </div>
);

export default HomePage;
