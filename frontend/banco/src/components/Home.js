// src/components/Home.js
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './CreateAgency.css';

const Home = () => {
  const [clientId, setClientId] = useState('');
  const navigate = useNavigate();

  const handleEmployeeLogin = () => {
    navigate('/intra-funcionario');
  };

  const handleClientLogin = () => {
    if (clientId.trim() !== '') {
      navigate(`/id/${clientId}`);
    }
  };

  return (
    <div className="create-agency-form">
      <h1>Bem-vindo ao Bankline</h1>
      <div className="section-container">
        <h2>Login Funcionário</h2>
        <button className="home-button" onClick={handleEmployeeLogin}>
          Intra Funcionário
        </button>
      </div>
      <div className="section-container">
        <h2>Login Cliente</h2>
        <input
          className="home-input"
          type="text"
          value={clientId}
          onChange={(e) => setClientId(e.target.value)}
          placeholder="Digite o ID do cliente"
        />
        <button className="home-button" onClick={handleClientLogin}>
          Login
        </button>
      </div>
    </div>
  );
};

export default Home;
