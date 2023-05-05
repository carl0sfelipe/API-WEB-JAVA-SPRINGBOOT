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

  useEffect(() => {
    const fetchClient = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/cliente/${id}`);
        setClientName(response.data.nome);
      } catch (error) {
        console.error('Erro ao buscar cliente:', error);
      }
    };

    fetchClient();
  }, [id]);

  return (
    <div className="create-agency-form">
      <h2>Bankline</h2>
      {clientName && <h3>Bem-vindo, {clientName}</h3>}
      <Depositar clienteId={id} />
      <Sacar clienteId={id} />
      <Transferir clienteId={id} />
      <ExibirExtrato clienteId={id} />
    </div>
  );
};

export default Bankline;
