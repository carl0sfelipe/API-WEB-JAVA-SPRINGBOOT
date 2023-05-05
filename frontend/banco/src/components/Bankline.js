import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import Depositar from './Depositar';
import Sacar from './Sacar';
import Transferir from './Transferir';
import ExibirExtrato from './ExibirExtrato';
import './CreateAgency.css';

const Bankline = () => {
  const { id } = useParams();
  const [clientName, setClientName] = useState('');
  const [clientSaldo, setClienteSaldo] = useState(0);
  const [refresh, setRefresh] = useState(false);

  useEffect(() => {
    const fetchClient = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/contaCorrente/cliente/${id}`);
        setClientName(response.data[0].cliente.nome);
        setClienteSaldo(response.data[0].saldo);
      } catch (error) {
        console.error('Erro ao buscar cliente:', error);
      }
    };

    fetchClient();
  }, [id, refresh]);

  return (
    <div className="create-agency-form">
      <h2>Bankline</h2>
      {clientName && clientSaldo !== null && (
        <h3>Bem-vindo, {clientName}. Seu saldo é de: {clientSaldo}</h3>
      )}
      <Depositar clienteId={id} setRefresh={setRefresh} />
      <Sacar clienteId={id} setRefresh={setRefresh} />
      <Transferir clienteId={id} setRefresh={setRefresh} />
      <ExibirExtrato clienteId={id} />
    </div>
  );
};

export default Bankline;
