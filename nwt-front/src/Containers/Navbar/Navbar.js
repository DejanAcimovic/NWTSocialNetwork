import React, { Component } from "react";
import { Button, FormControl, Navbar, Nav, Form, Modal } from "react-bootstrap";
import axios from "axios";
import { NavLink } from "react-router-dom";
import "./Navbar.css";


export default class Login extends Component {
  constructor(props) {
    super(props);

    this.state = {
      search : "",
      searchResult:[],
      showSearchResults: false
    };
  }

  handleChange = event => {
    this.setState({
        search: event.target.value,
        searchResult:[],
        showSearchResults: false
    });
  }

  handleSubmit = event => {
      console.log(this.state);
      axios.get(`http://localhost:8084/userUI/get/user/{first_name}?firstName=${this.state.search}`)
        .then(response => {
            this.setState({
                search: "",
                searchResult:[response.data],
                showSearchResults: true
            });
        })
        .catch(error => {
            this.setState({
                search: "",
                searchResult:[],
                showSearchResults: true
            });
        });
  }

  handleClose = event => {
    this.setState({
        search: "",
        searchResult:[],
        showSearchResults: false
    });
  }

  render() {
    return (
      <div className="Navbar">
          <Navbar expand="lg">
            <Navbar.Brand color="white">Social Network</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="mr-auto">
                    <NavLink to="/profile" > My Profile </NavLink>
                    {"   "}
                    <NavLink to="/group"> Create Group </NavLink>
                    {"   "}
                    <NavLink >Sign Out</NavLink>
                </Nav>

                    <Form inline>
                        <FormControl type="text" 
                                    placeholder="Search for people" 
                                    className="mr-sm-2" 
                                    value={this.state.search}
                                    onChange={this.handleChange}/>
                        <Button variant="outline-success" onClick={this.handleSubmit}>Search</Button>
                    </Form>
                
            </Navbar.Collapse>
           </Navbar>

           <Modal show={this.state.showSearchResults} onHide={this.handleClose}>
          <Modal.Header closeButton>
            <Modal.Title>Search results</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                { 
                    this.state.searchResult.length > 0 && 
                    <div>
                        {
                            this.state.searchResult.map(result => {
                            console.log(result);
                            return <div>{result.firstName} {result.lastName}</div> ;
                            })
                        }
                    </div>
                }
                {this.state.searchResult.length === 0 &&  <div>No matches were found</div>}
            </Modal.Body>
           </Modal>
      </div>
    );
  }
}
