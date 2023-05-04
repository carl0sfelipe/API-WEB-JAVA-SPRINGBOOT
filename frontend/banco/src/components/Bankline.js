import React from 'react';
import { useParams } from 'react-router-dom';
import Depositar from './Depositar';
import Sacar from './Sacar';
import Transferir from './Transferir';

const Bankline = () => {
  const { id } = useParams();
  console.log("id"+id)

  return (
    <div>
      <h2>Bankline</h2>
      <h3>Cliente ID: {id}</h3>
      <Depositar clienteId={id} />
       <Sacar clienteId={id} />
      <Transferir clienteId={id} />
    </div>
  );
};

export default Bankline;
