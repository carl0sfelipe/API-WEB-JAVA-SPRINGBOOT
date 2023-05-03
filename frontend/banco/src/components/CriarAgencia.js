import React, { useState } from 'react';
import axios from 'axios';

const CreateAgency = () => {
    const [nome, setNome] = useState('');
    const [endereco, setEndereco] = useState('');
    const [telefone, setTelefone] = useState('');
    const [message, setMessage] = useState('');

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

    return (
        <div>
            <h2>Criar Agência</h2>
            <form onSubmit={handleSubmit}>
          

                <label htmlFor="nome">Nome:</label>
                <input
                    type="text"
                    id="nome"
                    value={nome}
                    onChange={(e) => setNome(e.target.value)}
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

                <button type="submit">Criar Agência</button>
            </form>
            {message && <p>{message}</p>}
        </div>
    );
};

export default CreateAgency;
