// src/components/Depositar.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Depositar = ({ clienteId }) => {
  const [valor, setValor] = useState('');
  const [message, setMessage] = useState('');
  const [conta, setConta] = useState(null);

  useEffect(() => {
    const fetchConta = async () => {
      const response = await axios.get(`http://localhost:8080/contaCorrente/${clienteId}`);
      setConta(response.data);
    };
    fetchConta();
  }, [clienteId]);

  const formatDate = (date) => {
    const day = date.getDate().toString().padStart(2, '0');
    const month = (date.getMonth() + 1).toString().padStart(2, '0');
    const year = date.getFullYear();
    const hours = date.getHours().toString().padStart(2, '0');
    const minutes = date.getMinutes().toString().padStart(2, '0');
    const seconds = date.getSeconds().toString().padStart(2, '0');

    return `${day}/${month}/${year} ${hours}:${minutes}:${seconds}`;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(
        `http://localhost:8080/contaCorrente/depositar/${clienteId}`,
         valor ,
        { headers: { 'Content-Type': 'application/json' } }
      );

      // Enviar operação de depósito para a tabela de extrato
      if (conta) {
        const requestBody = {
          idExtrato: Math.floor(Math.random() * 1000000),
          dataHoraMovimento: formatDate(new Date()),
          operacao: 'Depósito',
          valorOperacao: parseFloat(valor),
          contaCorrente: {
            ...conta,
            saldo: conta.saldo + parseFloat(valor),
          },
        };

        await axios.post(
          `http://localhost:8080/extrato`,
          JSON.stringify(requestBody),
          { headers: { 'Content-Type': 'application/json' } }
        );
      }

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
