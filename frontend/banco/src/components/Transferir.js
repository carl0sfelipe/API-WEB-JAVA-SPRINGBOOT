import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './CreateAgency.css';



const Transferir = ({ clienteId }) => {
  const [contas, setContas] = useState([]);
  const [origem, setOrigem] = useState(clienteId);
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

    // Encontre as informações da conta de origem e destino
    const origemConta = contas.find((conta) => conta.idContaCorrente === parseInt(origem));
    const destinoConta = contas.find((conta) => conta.idContaCorrente === parseInt(destino));

    // Crie o objeto do corpo da solicitação
    const requestBody = {
      idExtrato: Math.floor(Math.random() * 1000000),
      dataHoraMovimento: formatDate(new Date()),
      operacao: 'Transferência',
      valorOperacao: parseFloat(valor),
      contaCorrente: {
        ...origemConta,
        saldo: origemConta.saldo - parseFloat(valor),
      },
    };

    try {

        const responses = await axios.post(
            `http://localhost:8080/contaCorrente/${clienteId}/transferir/${destino}`,
            valor ,
            { headers: { 'Content-Type': 'application/json' } }
          );

      const response = await axios.post(
        `http://localhost:8080/extrato`,
        JSON.stringify(requestBody),
        { headers: { 'Content-Type': 'application/json' } }
      );
      setMessage(responses.data);
    } catch (error) {
      setMessage('Erro ao transferir. Tente novamente.');
    }
  };

  return (
    <div >
      <h2>Transferir</h2>
      <form onSubmit={handleSubmit}>
        <label htmlFor="destino">Conta de Destino:</label>
        <select id="destino" value={destino} onChange={(e) => setDestino(e.target.value)}>
          <option value="">Selecione a conta de Destino</option>
          {contas.map((conta) => (
            <option key={conta.idContaCorrente} value={conta.idContaCorrente}>
              {conta.numero}
            </option>
          ))}
        </select>
        <br/>
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
