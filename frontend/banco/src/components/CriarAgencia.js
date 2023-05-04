import React, { useState } from 'react';
import axios from 'axios';
import './CreateAgency.css';

const CreateAgency = () => {
  const [nome, setNome] = useState('');
  const [endereco, setEndereco] = useState('');
  const [telefone, setTelefone] = useState('');
  const [message, setMessage] = useState('');
  const [showForm, setShowForm] = useState(false);

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post('http://localhost:8080/agencia', {
        nome,
        endereco,
        telefone,
      });

      if (response.status === 201) {
        setMessage('Agência criada com sucesso!');
      } else {
        setMessage('Erro ao criar agência. Tente novamente.');
      }
    } catch (error) {
      setMessage('Erro ao criar agência. Tente novamente.');
      console.log(error);
    }
  };

  const handleButtonClick = () => {
    setShowForm(true);
  };

  const handleCloseButtonClick = () => {
    setShowForm(false);
    setMessage('');
    setNome('');
    setEndereco('');
    setTelefone('');
  };

  return (
    <div>
      {showForm ? (
        <div className="create-agency-form">
          <h2>Criar Agência</h2>
          <form onSubmit={handleSubmit}>
            <div className="form-group">
              <label htmlFor="nome">Nome:</label>
              <input
                type="text"
                id="nome"
                value={nome}
                onChange={(e) => setNome(e.target.value)}
              />
            </div>

            <div className="form-group">
              <label htmlFor="endereco">Endereço:</label>
              <input
                type="text"
                id="endereco"
                value={endereco}
                onChange={(e) => setEndereco(e.target.value)}
              />
            </div>

            <div className="form-group">
              <label htmlFor="telefone">Telefone:</label>
              <input
                type="text"
                id="telefone"
                value={telefone}
                onChange={(e) => setTelefone(e.target.value)}
              />
            </div>

            <div className="form-actions">
              <button type="submit">Criar Agência</button>
              <button className="cancel-button" onClick={handleCloseButtonClick}>
                Fechar
              </button>
            </div>
          </form>
        </div>
      ) : (
        <button className="create-agency-button" onClick={handleButtonClick}>
          Criar Agência
        </button>
      )}
      {message && <p>{message}</p>}
    </div>
  );
};

export default CreateAgency;
