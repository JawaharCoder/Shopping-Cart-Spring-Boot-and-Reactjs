import './App.css';
import React from 'react';
import { Component } from 'react';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Routes, Route}
    from 'react-router-dom';
import HomeComponent from './pages/HomeComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import ItemComponent from './pages/ItemComponent';
import ProductService from './services/ProductService';


class AppComponent extends Component {

  constructor(props) {
    super(props)

    this.state = {
      cartitems: [],
      cartitemstotal: 0
    }

    this.getCartItemsCount = this.getCartItemsCount.bind(this);
    this.handleAddToCart = this.handleAddToCart.bind(this);
    this.handleRemoveFromCart = this.handleRemoveFromCart.bind(this);

    
   
}


 getCartItemsCount = () => {
  ProductService.getCartItems().then((res) => {
    this.setState({ cartitemstotal : res.data.length});
    console.log(this.state.cartitemstotal);
  });
}


 handleAddToCart = (product) => {
  ProductService.getCartItems().then((res) => {
    this.setState({ cartitemstotal : res.data.length});
    console.log(this.state.cartitemstotal);
  });
};

 handleRemoveFromCart = (product) => {
  ProductService.getCartItems().then((res) => {
    this.setState({ cartitemstotal : res.data.length});
    console.log(this.state.cartitemstotal);
  });
 };

 render() {
  // let cartitemstotal = 0;
  return (
   
    <div>
      <HeaderComponent getCartCount={this.getCartItemsCount} cartitemstotal={this.state.cartitemstotal}/>

      <Router>
      <Navbar />
      <Routes>
          <Route exact path='/home' element={<HomeComponent addToCart={this.handleAddToCart} />} />
          <Route exact path='/items' element={<ItemComponent removeFromCart={this.handleRemoveFromCart} />} />
      </Routes>
      </Router>

      <FooterComponent/>

    </div>
  );
}
}

export default AppComponent;
