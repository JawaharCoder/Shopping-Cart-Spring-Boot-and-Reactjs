import React from 'react';
import { Component } from 'react';
import Card from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Button from 'react-bootstrap/Button';
import ProductService from '../services/ProductService';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
const PUBLIC_URL = process.env.PUBLIC_URL;

class HomeComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {
                products: []
        }

        //this.addCartItem = this.addCartItem.bind(this);
        
    }

    componentDidMount(){
        ProductService.getProducts().then((res) => {
            console.log(res.data);
            this.setState({ products: res.data});
        });
    }

    addCartItem = (product) => {
        ProductService.addCartItem(product).then((res) => {
            console.log(res.data);
            this.setState({cartitems: res.data, cartitemstotal: res.data.length})
        });
    }

    render() {
        return (

            <div>

                <div>

                <Row xs={1} md={6} className="g-4">
                    {
                        this.state.products.map(
                            product => 
                            <Col style={{paddingLeft : '0px', paddingRight : '0px'}}>
                                <Card style={{width: '100%', height:'520px', paddingLeft : '0px', paddingRight : '0px'}}>
                                    <Card.Img variant="top" style={{ paddingTop: '10px', width: '120px', height: '200px', margin: 'auto', alignItems: 'center', display: 'flex', justifyContent: 'center' }} src={ PUBLIC_URL + product.imagelink} />
                                    <Card.Body>
                                    <Card.Title>{product.product_name}</Card.Title>
                                    <Card.Text>
                                    {product.product_description}
                                    </Card.Text>
                                    <Button variant="link" style={{width: '100%'}}  onClick={() => this.addCartItem(product)}>Add to cart</Button>
                                    </Card.Body>
                                    <Card.Footer>
                                    <small className="text-muted">{product.updated}</small>
                                    </Card.Footer>
                                </Card>
                            </Col>
                            
                        )
                    }
                </Row>
                </div>
                    <br/>
                    <br/>
                    <br/>
            </div>
        );
}
}
export default HomeComponent;