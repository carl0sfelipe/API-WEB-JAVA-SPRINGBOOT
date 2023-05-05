// src/components/ExibirExtrato.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './ExpandableListAccounts.css'

const ExibirExtrato = ({ clienteId }) => {
  const [extrato, setExtrato] = useState([]);
  const [showExtrato, setShowExtrato] = useState(false);
  const [extratoLoaded, setExtratoLoaded] = useState(false);

  useEffect(() => {
    if (extratoLoaded) {
      fetchExtrato();
    }
  }, [extratoLoaded, clienteId]);

  const fetchExtrato = async () => {
    const response = await axios.get(`http://localhost:8080/extrato`);
    console.log(response.data);
    const extratoCliente = response.data.filter(
      (item) => item.contaCorrente.cliente.clienteId == clienteId
    );
    console.log(extratoCliente);
    setExtrato(extratoCliente);
    setExtratoLoaded(true);
  };

  const handleShowExtrato = () => {
   // if (!extratoLoaded) {
      fetchExtrato();
  //  }
    setShowExtrato(!showExtrato);
  };

  return (
    <div className="expandable-container" >
      <button onClick={handleShowExtrato}>Exibir Extrato</button>
      {showExtrato && (
        <div className="expandable-container" >
          <h2>Extrato</h2>
          <table className="table" >
            <thead>
              <tr>
                <th>Data e Hora</th>
                <th>Operação</th>
                <th>Valor</th>
              </tr>
            </thead>
            <tbody>
              {extrato.map((item) => (
                <tr key={item.idExtrato}>
                  <td>{item.dataHoraMovimento}</td>
                  <td>{item.operacao}</td>
                  <td>{item.valorOperacao.toFixed(2)}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
};

export default ExibirExtrato;
