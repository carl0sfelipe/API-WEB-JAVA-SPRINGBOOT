// src/App.js
import { Route, BrowserRouter as Router, Link, Routes } from "react-router-dom";
import Home from "./components/Home";
import Bankline from "./components/Bankline";
import IntraFuncionario from "./components/IntraFuncionario";

function App() {
  return (
    <Router>
      <nav>
        <Link to="/">Home</Link>
      </nav>
      <div>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/id/:id/*" element={<Bankline />} />
          <Route path="/intra-funcionario" element={<IntraFuncionario />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
