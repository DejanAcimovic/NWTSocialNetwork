import React from 'react';
import './App.css';
import Login from "./Containers/Login";
import Signup from "./Containers/Signup";
import Navbar from "./Containers/Navbar/Navbar";

function App() {
  return (
    <div className="App">
        <Navbar></Navbar>
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
}

export default App;
