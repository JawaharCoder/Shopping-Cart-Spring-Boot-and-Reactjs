import React from 'react';
import Table from 'react-bootstrap/Table';
import { Component } from 'react';
import ProductService from '../services/ProductService';
import { GrAdd, GrCart } from 'react-icons/gr';
import Card from 'react-bootstrap/Card';
const PUBLIC_URL = process.env.PUBLIC_URL;

class ItemComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                cartitems: []
        }

        this.addProduct = this.addProduct.bind(this);
       
    }

    componentDidMount(){
        ProductService.getCartItems().then((res) => {
            this.setState({ cartitems: res.data});
        });
    }

    addProduct(){
        alert('Under Construction');
        //this.props.history.push('/home');
    }
   
    removeCartItem = (ItemId) => {
        ProductService.removeCartItem(ItemId).then((res) => {
            console.log(res.data);
            this.setState({ cartitems: res.data});
        });
        this.props.removeFromCart(ItemId);
    }

    render() {
        return (

            <div>
                 
                 <div className = "row">
                    <h2 className="text-center">Product List</h2>
                 </div>
                
                 
                
                 <br></br>
                <div className = "row" style={{ margin: 'auto', paddingBottom:'200px', width: 860, height: 'auto', alignItems: 'center', display: 'flex', justifyContent: 'center' }}>
                    <Table striped bordered hover>
                        <thead>
                            <tr>
                            <th>#</th>
                            <th>Product Image</th>
                            <th>Product Name</th>
                            <th>Product Type</th>
                            <th style={{width:'280px'}}>   
                                 <button style={{width:'160px'}} className="btn btn-primary" onClick={this.addProduct}> 
                                 <GrAdd/>&nbsp;&nbsp;&nbsp;Add Product
                                 </button>
                            </th>
                            </tr>
                        </thead>
                        <tbody>
                        {
                        this.state.cartitems.map(
                                product => 
                                <tr>
                                <td>{product.id}</td>
                                <td><Card.Img variant="top" style={{ paddingTop: '10px', width: '120px', height: '200px', margin: 'auto', alignItems: 'center', display: 'flex', justifyContent: 'center' }} src={ PUBLIC_URL + product.imagelink} /></td>
                                <td>{product.product_name}</td>
                                <td>Mobile</td>
                                <td>
                                    <button className="btn btn-info">Update </button>
                                    <button style={{marginLeft: "10px"}} onClick={()=> this.removeCartItem(product.id)} className="btn btn-danger">Remove </button>
                                    <button style={{marginLeft: "10px"}} className="btn btn-info">View </button>
                                </td>
                                </tr>
                            )
                        }
                        </tbody>
                        <tfoot>
                            <tr>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th>   
                                 <button style={{width:'160px'}} className="btn btn-primary" onClick={this.addProduct}> 
                                 <GrCart/>&nbsp;&nbsp;&nbsp;Check Out
                                 </button>
                            </th>
                            </tr>
                        </tfoot>
                    </Table>
                </div>
            </div>
        )
    }
}

export default ItemComponent;