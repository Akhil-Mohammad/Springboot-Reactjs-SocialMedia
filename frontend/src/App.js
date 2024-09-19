import logo from './logo.svg';
import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css"

import Navbar from './layouts/Navbar';

function App() {
  return (
    <div className="App d-flex flex-column min-vh-100">
      <Navbar />
    </div>
  );
}

export default App;
