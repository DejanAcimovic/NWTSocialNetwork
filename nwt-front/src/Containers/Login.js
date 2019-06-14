import React, { Component } from "react";
import { Button, FormGroup, FormControl, FormLabel } from "react-bootstrap";
import "./Login.css";
import axios from "axios";

export default class Login extends Component {
  constructor(props) {
    super(props);

    this.state = {
      username: "",
      password: ""
    };
  }

  handleChange = event => {
    this.setState({
      [event.target.id]: event.target.value
    });
  }

  handleSubmit = (event) => {
    console.log(this.state);
    axios.post("http://localhost:8084/userUI/login", this.state)
    .then((response)=>{
      localStorage.setItem('token', response.data);
      console.log(response.data);
    })
    .catch(err => {
      console.log(err.message);
    });

  }

  render() {
    return (
      <div className="Login">
        <form onSubmit={this.handleSubmit}>
          <FormLabel>Username: </FormLabel>
          <FormGroup controlId="username" >
            <FormControl
              autoFocus
              type="text"
              value={this.state.username}
              onChange={this.handleChange}
            />
          </FormGroup>
          <FormLabel>Password: </FormLabel>
          <FormGroup controlId="password" >
            <FormControl
              value={this.state.password}
              onChange={this.handleChange}
              type="password"
            />
          </FormGroup>
            
          <Button
            block
            className="btnLogin"
            onClick = {this.handleSubmit}
          >
            Login
          </Button>
        </form>
      </div>
    );
  }
}
