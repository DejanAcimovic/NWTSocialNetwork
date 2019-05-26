import React, { Component } from "react";
import { Button, FormGroup, FormControl, FormLabel } from "react-bootstrap";
import "./Signup.css";
import axios from 'axios';



export default class Signup extends Component {
  constructor(props) {
    super(props);

    this.state = {
        firstName : "",
        lastName : "",
        username : "",
        email: "",
        password: "",
        confirmPassword: ""
    };
  }

  handleChange = event => {
    this.setState({
      [event.target.id]: event.target.value
    });
  }


  handleSubmit = event => {
    console.log("handleSubmmit");
    this.setState({
      [event.target.id]: event.target.value
    });
    console.log(this.state);


    axios.post(`https://localhost:8000/user`, this.state)
    .then(res => {
      console.log(res);
      console.log(res.data);
    })

    event.preventDefault();
  }
render() {
    return (
      <div className="Signup">
        <form onSubmit={this.handleSubmit}>
          <FormLabel>First name: </FormLabel>
          <FormGroup controlId="firstName" >
            <FormControl
              autoFocus
              type="firstName"
              value={this.state.firstName}
              onChange={this.handleChange}
            />
          </FormGroup>
          <FormLabel>Last name: </FormLabel>
          <FormGroup controlId="lastName" >
            <FormControl
              autoFocus
              type="lastName"
              value={this.state.lastName}
              onChange={this.handleChange}
            />
          </FormGroup>
          <FormLabel>Email : </FormLabel>
          <FormGroup controlId="email" >
            <FormControl
              autoFocus
              type="email"
              value={this.state.email}
              onChange={this.handleChange}
            />
          </FormGroup>
          <FormLabel>Username: </FormLabel>
          <FormGroup controlId="username">
            <FormControl
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

          <FormLabel>Confirm password: </FormLabel>
          <FormGroup controlId="ConfirmPassword" >
            <FormControl
              value={this.state.password}
              onChange={this.handleChange}
              type = "password"
            />
          </FormGroup>
          
          <Button
            block
            type="submit"
            className = "btnSignup"
          >
            Sign up
          </Button>
        </form>
      </div>
    );
}
}