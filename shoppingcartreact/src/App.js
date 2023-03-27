import './App.css';
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

function App() {
  return (
   
    <div>
      <HeaderComponent/>

      <Router>
      <Navbar />
      <Routes>
          <Route exact path='/home' element={<HomeComponent />} />
          <Route exact path='/items' element={<ItemComponent />} />
      </Routes>
      </Router>

      <FooterComponent/>

    </div>
  );
}

export default App;
