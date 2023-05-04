// src/components/IntraFuncionario.js
import React from 'react';
import CriarAgencia from './CriarAgencia';
import CriarCliente from './CriarCliente';
import CriarContaCorrente from './CriarConta';
import ExpandableListAccounts from './MostrarContas';

const IntraFuncionario = () => {
  return (
    <div>
      <h1>Intra Funcionário</h1>
      <CriarAgencia />
      <CriarCliente />
      <CriarContaCorrente />
      <ExpandableListAccounts/>
    </div>
  );
};

export default IntraFuncionario;
