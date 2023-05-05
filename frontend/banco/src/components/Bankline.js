import React from 'react';
import { useParams } from 'react-router-dom';
import Depositar from './Depositar';
import Sacar from './Sacar';
import Transferir from './Transferir';
import ExibirExtrato from './ExibirExtrato';
import './CreateAgency.css';


const Bankline = () => {
  const { id } = useParams();
  console.log("id"+id)

  return (
    <div className="create-agency-form" >
      <h2>Bankline</h2>
      <h3>Cliente ID: {id}</h3>
      <Depositar clienteId={id} />
       <Sacar clienteId={id} />
      <Transferir clienteId={id} />
      <ExibirExtrato clienteId={id}/>
    </div>
  );
};

export default Bankline;
