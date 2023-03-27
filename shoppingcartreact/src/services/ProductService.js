import axios from 'axios';

const PRODUCT_API_BASE_URL = "http://localhost:8080/api/v1/products";
const ITEM_API_BASE_URL = "http://localhost:8080/api/v1/items";


class ProductService {

    getProducts(){
        return axios.get(PRODUCT_API_BASE_URL);
    }

    
    createProduct(product){
        return axios.post(PRODUCT_API_BASE_URL, product);
    }

    deleteProduct(productId){
        return axios.delete(PRODUCT_API_BASE_URL + '/' + productId);
    }

    getProductById(productId){
        return axios.get(PRODUCT_API_BASE_URL + '/' + productId);
    }

    updateProduct(product, productId){
        return axios.put(PRODUCT_API_BASE_URL + '/' + productId, product);
    }

    getCartItems(){
        return axios.get(ITEM_API_BASE_URL);
    }

    addCartItem(item){
        return axios.post(ITEM_API_BASE_URL, item);
    }

    removeCartItem(itemId){
        return axios.delete(ITEM_API_BASE_URL + '/' + itemId);
    }

    
}

export default new ProductService()