import React, { Component } from "react";
import {
  Container,
  Media,
  Row,
  Col,
  Button,
  Modal,
  Form,
  Card,
  CardProps,
  ButtonToolbar,
  Popover,
  OverlayTrigger
} from "react-bootstrap";
import slika1 from "../../slika1.png";
import slika2 from "../../slika2.png";
import slika3 from "../../slika3.png";
import ptica from "../../ptica.jpg"
import "./ProfilePage.css";

export default class ProfilePage extends Component {
  constructor(props, context) {
    super(props, context);

    this.handleShow = this.handleShow.bind(this);
    this.handleClose = this.handleClose.bind(this);

    this.state = {
      show: false,
      postText: "",
      visible: false,
      url: "",
      showProfile: false,
      urlProfile: "",
      profileShow: false
    };
  }
  
  handleClose() {
    this.setState({ show: false,
    showProfile: false });
  }

  handleShow() {
    this.setState({ show: true });
  }

  handleChange = (event) => {
    this.setState({
      postText: event
    });
  }

  handleChangePic = (e) => {
    this.setState({
      url:e
    })
  }

  handlePost = () => {
    this.setState({
      visible: true
    });
    this.handleClose()
  }

  openProfPic =() => {
    this.setState({
      showProfile: true
    })
  }
  handleChangeProfPic = (e) => {
    this.setState({
      urlProfile: e
    })
  }

  handleProfilePicture = () => {
    this.setState ({
      profileShow: true
    });
    this.handleClose()
  }

  render() {
    return (
  <div>
  <Container>
  <Row>
    <Col sm={3}>
    <div class="profile-card">
     <Card class="profile-card" style={{ width: '15rem', height:'20rem' }}>

       
     {this.state.profileShow &&
     <Card.Img variant='top' 
                  width={8}
                  height={170}
                  src={this.state.urlProfile}
                  alt="Generic placeholder"/>}
       <Card.Body>
          <Card.Text> 
             Name Surname
           </Card.Text>
          <Button variant="primary" onClick={this.openProfPic}>Upload profile picture</Button>


          <Modal show={this.state.showProfile} onHide={this.handleClose}>
                  <Modal.Header closeButton>
                    <Modal.Title>Upload new Profile picture</Modal.Title>
                  </Modal.Header>
                  <Modal.Body>
                    <Form>
                       <Form.Label>Pictures: </Form.Label>
                        <Form.Control onChange={e => this.handleChangeProfPic(e.target.value)}></Form.Control>
                    </Form>
                  </Modal.Body>
                  <Modal.Footer>
                    <Button variant="primary" onClick={this.handleProfilePicture}>
                      Post it
                    </Button>
                  </Modal.Footer>
                </Modal>
       </Card.Body>
     </Card>
    </div>
    </Col>
    
    <Col sm={9}>
      <Row> 
        <h2> Posts </h2>
        <Button variant="Primary" onClick={this.handleShow}>New post</Button>
        <Modal show={this.state.show} onHide={this.handleClose}>
                  <Modal.Header closeButton>
                    <Modal.Title>Create new post</Modal.Title>
                  </Modal.Header>
                  <Modal.Body>
                    <Form>
                        <Form.Label>Post: </Form.Label>
                        <Form.Control onChange={event => this.handleChange(event.target.value)} placeholder="Enter your post" />                      
                        <Form.Label>Pictures: </Form.Label>
                        <Form.Control onChange={e => this.handleChangePic(e.target.value)}></Form.Control>
                    </Form>
                  </Modal.Body>
                  <Modal.Footer>
                    <Button variant="secondary" onClick={this.handleClose}>
                      Cancel
                    </Button>
                    <Button variant="primary" onClick={this.handlePost}>
                      Post it
                    </Button>
                  </Modal.Footer>
                </Modal>
                

      </Row>
      <Row>
        <Media >
         <Media.Body border="solid">
         
           {this.state.visible && 
        (<Row>
           <Row> <p style={{width: "80%"}}> {this.state.postText} </p>
           <p style={{width: "1500px"}}>
           <img
            width={64}
            height={64}
            className="mr-3"
            src={this.state.url}
            alt="Generic placeholder"
            /> 
          </p>
            </Row>
            <Row>
          <Button variant="Primary" class="btn btn-success btn-lg">Like</Button>
            <ButtonToolbar>
              {['right'].map(placement => (
               <OverlayTrigger
                 trigger="click"
                 key={placement}
                 placement={placement}
                 overlay={
                   <Popover
                   id={`popover-positioned-${placement}`}
                   title={`Comments`} >
                  </Popover> } >           
                 <Button variant="Primary" class="comments">Comments</Button>
              </OverlayTrigger>))}
            </ButtonToolbar>
        </Row>
            </Row>
          )}
        
           <Row>
          <p>
            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque
            ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at,
            tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla.
            Donec lacinia congue felis in faucibus.
          </p>
          <img
            width={64}
            height={64}
            className="mr-3"
            src={slika1}
            alt="Generic placeholder"/>
         <img
            width={64}
            height={64}
            className="mr-3"
            src={slika2}
            alt="Generic placeholder"/>
         <img
            width={64}
            height={64}
            className="mr-3"
            src={slika3}
            alt="Generic placeholder"/>
          </Row>
        
          <Row>
          <Button variant="Primary" class="btn btn-success btn-lg">Like</Button>
            <ButtonToolbar>
              {['right'].map(placement => (
               <OverlayTrigger
                 trigger="click"
                 key={placement}
                 placement={placement}
                 overlay={
                   <Popover
                   id={`popover-positioned-${placement}`}
                   title={`Comments`} >
                   <ul className="list-unstyled">
                    <Media as="li">
                      <img
                        width={32}
                        height={32}
                        className="mr-3"
                        src={slika1}
                        alt="Generic placeholder"
                      />
                        <Media.Body>
                          <h6>Nađa Žilić</h6>
                          <p>
                          Great post!
                          </p>
                        </Media.Body>
                    </Media>

                    <Media as="li">
                      <img
                        width={32}
                        height={32}
                        className="mr-3"
                        src={slika1}
                        alt="Generic placeholder"
                      />
                      <Media.Body>
                        <h6>Dejan Aćimović</h6>
                        <p>
                        This is amazing!
                        </p>
                      </Media.Body>
                    </Media>
                  </ul>
                  </Popover> } >           
                 <Button variant="Primary" class="comments">Comments</Button>
              </OverlayTrigger>))}
            </ButtonToolbar>
        </Row>
        </Media.Body>
      </Media>

    </Row>
      
    <Row>
        <Media >
         <Media.Body border="solid">
           <Row>
          <p>
            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque
            ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at,
            tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla.
            Donec lacinia congue felis in faucibus.
          </p>
          <img
            width={64}
            height={64}
            className="mr-3"
            src={slika1}
            alt="Generic placeholder"/>
         <img
            width={64}
            height={64}
            className="mr-3"
            src={slika2}
            alt="Generic placeholder"/>
          </Row>
        
          <Row>
          <Button variant="Primary" class="btn btn-success btn-lg">Like</Button>
            <ButtonToolbar>
              {['right'].map(placement => (
               <OverlayTrigger
                 trigger="click"
                 key={placement}
                 placement={placement}
                 overlay={
                   <Popover
                   id={`popover-positioned-${placement}`}
                   title={`Comments`} >
                   <ul className="list-unstyled">
                    <Media as="li">
                      <img
                        width={32}
                        height={32}
                        className="mr-3"
                        src={slika1}
                        alt="Generic placeholder"
                      />
                        <Media.Body>
                          <h6>Nađa Žilić</h6>
                          <p>
                          Great post!
                          </p>
                        </Media.Body>
                    </Media>

                    <Media as="li">
                      <img
                        width={32}
                        height={32}
                        className="mr-3"
                        src={slika1}
                        alt="Generic placeholder"
                      />
                      <Media.Body>
                        <h6>Dejan Aćimović</h6>
                        <p>
                        This is amazing!
                        </p>
                      </Media.Body>
                    </Media>
                  </ul>
                  </Popover> } >           
                 <Button variant="Primary" class="comments">Comments</Button>
              </OverlayTrigger>))}
            </ButtonToolbar>
        </Row>
        <Row>
        <Media >
         <Media.Body border="solid">
           <Row>
          <p>
            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque
            ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at,
            tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla.
            Donec lacinia congue felis in faucibus.
          </p>
          </Row>
        
          <Row>
          <Button variant="Primary" class="btn btn-success btn-lg">Like</Button>
            <ButtonToolbar>
              {['right'].map(placement => (
               <OverlayTrigger
                 trigger="click"
                 key={placement}
                 placement={placement}
                 overlay={
                   <Popover
                   id={`popover-positioned-${placement}`}
                   title={`Comments`} >
                   <ul className="list-unstyled">
                    <Media as="li">
                      <img
                        width={32}
                        height={32}
                        className="mr-3"
                        src={slika1}
                        alt="Generic placeholder"
                      />
                        <Media.Body>
                          <h6>Nađa Žilić</h6>
                          <p>
                          Great post!
                          </p>
                        </Media.Body>
                    </Media>

                    <Media as="li">
                      <img
                        width={32}
                        height={32}
                        className="mr-3"
                        src={slika1}
                        alt="Generic placeholder"
                      />
                      <Media.Body>
                        <h6>Dejan Aćimović</h6>
                        <p>
                        This is amazing!
                        </p>
                      </Media.Body>
                    </Media>
                  </ul>
                  </Popover> } >           
                 <Button variant="Primary" class="comments">Comments</Button>
              </OverlayTrigger>))}
            </ButtonToolbar>
        </Row>
        </Media.Body>
      </Media>

    </Row>
      

        </Media.Body>
      </Media>

    </Row>
      
    </Col>
  </Row>
 
</Container>
  </div>
    
);
  }
}
//export default ProfilePage;
