import React, { Component, useState } from 'react'
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import HomeComponent from '../pages/HomeComponent';
import Container from 'react-bootstrap/Container';
import ItemComponent from '../pages/ItemComponent';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import ProductService from '../services/ProductService';
// const [show, setShow] = useState(false);
// const handleClose = () => setShow(false);
// const handleShow = () => setShow(true);

class HeaderComponent extends Component {

    
    
    constructor(props) {
        super(props)

        this.state = {
            showModal : false,
            cartitemstotal: this.props.cartitemstotal
        }

        this.handleClose = this.handleClose.bind(this);
        this.showModalOpen = this.showModalOpen.bind(this);
        this.props.getCartCount();
    }

    
    componentWillReceiveProps(props){
        this.setState({
            cartitemstotal: props.cartitemstotal
        });
        // alert(this.props.cartitemstotal);
    }
   

    handleClose(){
        //alert('Sign Out Successfully!');
        this.setState({showModal : false});
        //this.props.history.push('/home');
    }

    showModalOpen(){
        this.setState({showModal : true});
        //this.props.history.push('/home');
    }

    
    

    render() {
        return (
            <div>

                <Modal show={this.state.showModal} onHide={this.handleClose}>
                    <Modal.Header closeButton>
                    <Modal.Title>Sign Out</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>Are you sure?</Modal.Body>
                    <Modal.Footer>
                    <Button variant="secondary" onClick={this.handleClose}>
                        Close
                    </Button>
                    <Button variant="primary" onClick={this.handleClose}>
                        Sign Out
                    </Button>
                    </Modal.Footer>
                </Modal>
                <Navbar bg="light" expand="lg">
                    <Container>
                    <Navbar.Brand href="/home">Shopping Cart</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="me-auto">
                        <Nav.Link href="/home" element={<HomeComponent />}>Home</Nav.Link>
                        <Nav.Link href="/items" element={<ItemComponent />}>Items</Nav.Link>
                        <NavDropdown title={"Cart("+this.state.cartitemstotal+")"} id="basic-nav-dropdown">
                            <NavDropdown.Item href="/items">Add Item</NavDropdown.Item>
                            <NavDropdown.Item href="/items">
                            Check Out
                            </NavDropdown.Item>
                            <NavDropdown.Item href="/something">Something</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item onClick={this.showModalOpen}>
                            Sign Out
                            </NavDropdown.Item>
                        </NavDropdown>
                        </Nav>
                    </Navbar.Collapse>
                    </Container>
                </Navbar>
            </div>
        )
    }
}

export default HeaderComponent
