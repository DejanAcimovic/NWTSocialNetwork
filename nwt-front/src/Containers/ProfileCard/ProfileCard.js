import React, { Component } from "react";
import { Button, FormControl, Card,Form, Modal, CardProps } from "react-bootstrap";

export default class ProfileCard extends Component {
    constructor(props) {
      super(props);
  
      this.state = {
        image: "",
        name: ""
      };
    }
  

render() {
 return (
<div  className="ProfileCard">
  <Card style={{ width: '18rem' }}>
  <Card.Img variant="top" src="holder.js/100px180" />
  <Card.Body>
    <Card.Title>Card Title</Card.Title>
    <Card.Text>
      Some quick example text to build on the card title and make up the bulk of
      the card's content.
    </Card.Text>
    <Button variant="primary">Add friend</Button>
  </Card.Body>
</Card>
 </div>
        );
    }
}