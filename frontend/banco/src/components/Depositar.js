// src/components/Depositar.js
import React, { useState } from 'react';
import axios from 'axios';

const Depositar = ({ clienteId }) => {
  const [valor, setValor] = useState('');
  const [message, setMessage] = useState('');

  console.log("clienteId" + clienteId);
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(
        `http://localhost:8080/contaCorrente/depositar/${clienteId}`,
         valor ,
        { headers: { 'Content-Type': 'application/json' } }
      );

      setMessage(response.data);
    } catch (error) {
      setMessage('Erro ao depositar. Tente novamente.');
    }
  };

  return (
    <div>
      <h2>Depositar</h2>
      <form onSubmit={handleSubmit}>
        <label htmlFor="valor">Valor:</label>
        <input
          type="number"
          id="valor"
          step="0.01"
          min="0"
          value={valor}
          onChange={(e) => setValor(e.target.value)}
        />
        <button type="submit">Depositar</button>
      </form>
      {message && <p>{message}</p>}
    </div>
  );
};

export default Depositar;
