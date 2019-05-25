import React, { Component } from "react";
import { Button, FormGroup, FormControl, FormLabel } from "react-bootstrap";
import "./Signup.css";

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
    event.preventDefault();
  }
render() {
    return (
      <div className="Signup">
        <form onSubmit={this.handleSubmit}>
          <FormLabel>First name: </FormLabel>
          <FormGroup controlId="firstName" bsSize="large">
            <FormControl
              autoFocus
              type="firstName"
              value={this.state.firstName}
              onChange={this.handleChange}
            />
          </FormGroup>
          <FormLabel>Last name: </FormLabel>
          <FormGroup controlId="lastName" bsSize="large">
            <FormControl
              autoFocus
              type="lastName"
              value={this.state.lastName}
              onChange={this.handleChange}
            />
          </FormGroup>
          <FormLabel>Email : </FormLabel>
          <FormGroup controlId="email" bsSize="large">
            <FormControl
              autoFocus
              type="email"
              value={this.state.email}
              onChange={this.handleChange}
            />
          </FormGroup>
          <FormLabel>Username: </FormLabel>
          <FormGroup controlId="username" bsSize="large">
            <FormControl
              value={this.state.username}
              onChange={this.handleChange}
            />
          </FormGroup>
          <FormLabel>Password: </FormLabel>
          <FormGroup controlId="password" bsSize="large">
            <FormControl
              value={this.state.password}
              onChange={this.handleChange}
              type="password"
            />
          </FormGroup>

          <FormLabel>Confirm password: </FormLabel>
          <FormGroup controlId="ConfirmPassword" bsSize="large">
            <FormControl
              value={this.state.password}
              onChange={this.handleChange}
            />
          </FormGroup>
          
          <Button
            block
            bsSize="large"
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