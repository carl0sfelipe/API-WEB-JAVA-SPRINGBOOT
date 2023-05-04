import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './CreateAgency.css';

const CreateClient = () => {
    const [nome, setNome] = useState('');
    const [cpf, setCpf] = useState('');
    const [endereco, setEndereco] = useState('');
    const [telefone, setTelefone] = useState('');
    const [agenciaId, setAgenciaId] = useState('');
    const [agencias, setAgencias] = useState([]);
    const [message, setMessage] = useState('');
    const [showForm, setShowForm] = useState(false);

    useEffect(() => {
        fetchAgencies();
    }, []);

    const fetchAgencies = async () => {
        try {
            const response = await axios.get('http://localhost:8080/agencia');
            setAgencias(response.data);
        } catch (error) {
            console.error('Erro ao buscar agências:', error);
        }
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await axios.post(`http://localhost:8080/agencia/cliente/${agenciaId}`, {
                nome,
                cpf,
                endereco,
                telefone,
            });

            if (response.status === 201) {
                setMessage('Cliente criado com sucesso!');
            } else {
                setMessage('Erro ao criar cliente. Tente novamente.');
            }
        } catch (error) {
            setMessage('Erro ao criar cliente. Tente novamente.');
        }
    };

    const handleButtonClick = () => {
        setShowForm(true);
    };

    const handleCloseButtonClick = () => {
        setShowForm(false);
        setMessage('');
        setNome('');
        setCpf('');
        setEndereco('');
        setTelefone('');
        setAgenciaId('');
    };

    return (
        <div >
        {showForm ? (
          <div className="create-agency-form" >
            <form onSubmit={handleSubmit}>
              <label htmlFor="nome">Nome:</label>
              <input
                type="text"
                id="nome"
                value={nome}
                onChange={(e) => setNome(e.target.value)}
              />
              <br />
      
              <label htmlFor="cpf">CPF:</label>
              <input
                type="text"
                id="cpf"
                value={cpf}
                onChange={(e) => setCpf(e.target.value)}
              />
              <br />
      
              <label htmlFor="endereco">Endereço:</label>
              <input
                type="text"
                id="endereco"
                value={endereco}
                onChange={(e) => setEndereco(e.target.value)}
              />
              <br />
      
              <label htmlFor="telefone">Telefone:</label>
              <input
                type="text"
                id="telefone"
                value={telefone}
                onChange={(e) => setTelefone(e.target.value)}
              />
              <br />
      
              <label htmlFor="agenciaId">Agência:</label>
              <select
                id="agenciaId"
                value={agenciaId}
                onChange={(e) => setAgenciaId(e.target.value)}
                onClick={fetchAgencies}
              >
                <option value="">Selecione a agência</option>
                {agencias.map((agencia) => (
                  <option key={agencia.idAgencia} value={agencia.idAgencia}>
                    {agencia.nome} - ID: {agencia.idAgencia}
                  </option>
                ))}
              </select>
              <br />
              <button type="submit">Criar Cliente</button>
              <button className="cancel-button" onClick={handleCloseButtonClick}>Fechar</button>
            </form>
            {message && <p>{message}</p>}
          </div>
        ) : (
          <button className="create-agency-button" onClick={handleButtonClick}>Criar Cliente</button>
        )}
      </div>
      
      );}      

      export default CreateClient;



