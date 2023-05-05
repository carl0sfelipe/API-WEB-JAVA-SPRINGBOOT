// src/components/IntraFuncionario.js
import React from 'react';
import CriarAgencia from './CriarAgencia';
import CriarCliente from './CriarCliente';
import CriarContaCorrente from './CriarConta';
import ExpandableListAccounts from './MostrarContas';
import './CreateAgency.css'

const IntraFuncionario = () => {
  return (
    <div className='create-agency-form' >
      <h1>Intranet Funcionário</h1>
      <CriarAgencia />
      <CriarCliente />
      <CriarContaCorrente />
      <ExpandableListAccounts/>
    </div>
  );
};

export default IntraFuncionario;
