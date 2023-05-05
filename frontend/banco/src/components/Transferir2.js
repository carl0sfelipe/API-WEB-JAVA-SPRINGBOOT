import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Transferir = ({ clienteId }) => {
  const [contas, setContas] = useState([]);
  //const [origem, setOrigem] = useState('');
  const [destino, setDestino] = useState('');
  const [valor, setValor] = useState('');
  const [message, setMessage] = useState('');

  useEffect(() => {
    const fetchContas = async () => {
      const response = await axios.get(`http://localhost:8080/contaCorrente`);
      setContas(response.data);
    };
    fetchContas();
  }, [clienteId]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(
        `http://localhost:8080/contaCorrente/${clienteId}/transferir/${destino}`,
        valor ,
        { headers: { 'Content-Type': 'application/json' } }
      );
      setMessage(response.data);
    } catch (error) {
      setMessage('Erro ao transferir. Tente novamente.');
    }
  };

  return (
    <div>
      <h2>Transferir</h2>
      <form onSubmit={handleSubmit}>
        <label htmlFor="origem">Favoritos</label>
        <select id="origem" value={destino} onChange={(e) => setDestino(e.target.value)}>
          <option value="">Selecione a conta de Destino </option>
          {contas.map((conta) => (
            <option key={conta.idContaCorrente} value={conta.idContaCorrente}>
              {conta.numero}
            </option>
          ))}
        </select>
        <label htmlFor="valor">Valor:</label>
        <input
          type="number"
          id="valor"
          step="0.01"
          min="0"
          value={valor}
          onChange={(e) => setValor(e.target.value)}
        />
        <button type="submit">Transferir</button>
      </form>
      {message && <p>{message}</p>}
    </div>
  );
};

export default Transferir;


