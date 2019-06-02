import React from 'react';
import './App.css';
import { Route, Switch } from "react-router-dom";
import Navbar from "./Containers/Navbar/Navbar";
import ProfilePage from "./Containers/Profile/ProfilePage";
// import Header from "./Containers/Header/Header";
import HomePage from "./Containers/HomePage/HomePage";


function App() {
  return (
    <div className="App">
      <Navbar />
      <Switch>
        <Route exact path="/" component={HomePage} />
        <Route path="/profile" component={ProfilePage} />
     </Switch>
    </div>

  );
}

export default App;
