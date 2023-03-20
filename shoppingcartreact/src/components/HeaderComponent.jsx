import React, { Component } from 'react'
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import Home from '../pages/Home';
import Container from 'react-bootstrap/Container';
import Item from '../pages/Item';

class HeaderComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                 
        }
    }

    render() {
        return (
            <div>
                <Navbar bg="light" expand="lg">
                    <Container>
                    <Navbar.Brand href="/home">Shopping Cart</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="me-auto">
                        <Nav.Link href="/home" element={<Home />}>Home</Nav.Link>
                        <Nav.Link href="/items" element={<Item />}>Items</Nav.Link>
                        <NavDropdown title="Cart(0)" id="basic-nav-dropdown">
                            <NavDropdown.Item href="/additem">Add Item</NavDropdown.Item>
                            <NavDropdown.Item href="/checkout">
                            Check Out
                            </NavDropdown.Item>
                            <NavDropdown.Item href="/something">Something</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item href="/signout">
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
