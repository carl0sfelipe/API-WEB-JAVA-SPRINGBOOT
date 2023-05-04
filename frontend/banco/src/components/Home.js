// src/components/Home.js
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

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
    <div>
      <h1>Bem-vindo ao Bankline</h1>
      <div>
        <h2>Login Funcionário</h2>
        <button onClick={handleEmployeeLogin}>Intra Funcionário</button>
      </div>
      <div>
        <h2>Login Cliente</h2>
        <input
          type="text"
          value={clientId}
          onChange={(e) => setClientId(e.target.value)}
          placeholder="Digite o ID do cliente"
        />
        <button onClick={handleClientLogin}>Login</button>
      </div>
    </div>
  );
};

export default Home;
