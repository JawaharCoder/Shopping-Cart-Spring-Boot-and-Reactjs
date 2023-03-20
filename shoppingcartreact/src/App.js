import logo from './logo.svg';
import './App.css';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Routes, Route}
    from 'react-router-dom';
import Home from './pages/Home';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import Item from './pages/Item';

function App() {
  return (
   
    <div>
      <HeaderComponent/>

      <Router>
      <Navbar />
      <Routes>
          <Route exact path='/home' element={<Home />} />
          <Route exact path='/items' element={<Item />} />
      </Routes>
      </Router>

      <FooterComponent/>

    </div>
  );
}

export default App;
