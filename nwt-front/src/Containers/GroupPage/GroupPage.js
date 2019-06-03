import React, { Component } from "react";
import {
  Container,
  Media,
  Row,
  Col,
  Button,
  Modal,
  Form
} from "react-bootstrap";
import slika1 from "../../slika1.png";
import slika2 from "../../slika2.png";
import slika3 from "../../slika3.png";
import "./GroupPage.css";

export default class GroupPage extends Component {
  constructor(props, context) {
    super(props, context);

    this.handleShow = this.handleShow.bind(this);
    this.handleClose = this.handleClose.bind(this);

    this.state = {
      show: false
    };
  }

  handleClose() {
    this.setState({ show: false });
  }

  handleShow() {
    this.setState({ show: true });
  }

  render() {
    return (
      <div>
        <Container>
          <Row>
            <Col sm={8}>
              <Row>
                <h5>Group name</h5>
                <Button variant="secondary" onClick={this.handleShow}>
                  New group
                </Button>

                <Modal show={this.state.show} onHide={this.handleClose}>
                  <Modal.Header closeButton>
                    <Modal.Title>Create new group</Modal.Title>
                  </Modal.Header>
                  <Modal.Body>
                    <Form>
                        <Form.Label>Group name: </Form.Label>
                        <Form.Control placeholder="Enter group name" />                      
                        <Form.Label>Description: </Form.Label>
                        <Form.Control placeholder="Enter group description" />
                        <Form.Label>Add member: </Form.Label>
                        <Form.Control placeholder="" />
                    </Form>
                  </Modal.Body>
                  <Modal.Footer>
                    <Button variant="secondary" onClick={this.handleClose}>
                      Close
                    </Button>
                    <Button variant="primary" onClick={this.handleClose}>
                      Save Changes
                    </Button>
                  </Modal.Footer>
                </Modal>
              </Row>
              <Media>
                <img
                  width={64}
                  height={64}
                  className="mr-3"
                  src={slika1}
                  alt="Generic placeholder"
                />
                <Media.Body>
                  <h5>Post </h5>
                  <p>
                    Cras sit amet nibh libero, in gravida nulla. Nulla vel metus
                    scelerisque ante sollicitudin commodo.
                  </p>
                </Media.Body>
              </Media>
              <Media>
                <img
                  width={64}
                  height={64}
                  className="mr-3"
                  src={slika2}
                  alt="Generic placeholder"
                />
                <Media.Body>
                  <h5>Elephant post</h5>
                  <p>
                    Cras purus odio, vestibulum in vulputate at, tempus viverra
                    turpis. Fusce condimentum nunc ac nisi vulputate fringilla.
                    Donec lacinia congue felis in faucibus.
                  </p>
                </Media.Body>
              </Media>
              <Media>
                <img
                  width={64}
                  height={64}
                  className="mr-3"
                  src={slika3}
                  alt="Generic placeholder"
                />
                <Media.Body>
                  <h5>Monkey post</h5>
                  <p>Donec lacinia congue felis in faucibus.</p>
                </Media.Body>
              </Media>
            </Col>
            <Col sm={4}>
              <h4>Description</h4>
              <p>
                Cras sit amet nibh libero, in gravida nulla. Nulla vel metus
                scelerisque ante sollicitudin commodo.
              </p>
              <h4>Members</h4>
              <p>
                Cras sit amet nibh libero, in gravida nulla. Nulla vel metus
                scelerisque ante sollicitudin commodo.
              </p>
              <Button>Join Group / Leave group</Button>
            </Col>
          </Row>
        </Container>
      </div>
    );
  }
}
