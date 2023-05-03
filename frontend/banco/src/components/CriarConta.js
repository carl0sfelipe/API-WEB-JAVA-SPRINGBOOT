import React, { useState, useEffect } from 'react';
import axios from 'axios';

const CreateAccount = () => {
    const [saldo, setSaldo] = useState('');
    const [limite, setLimite] = useState('');
    const [numero, setNumero] = useState('');
    const [clienteId, setClienteId] = useState('');
    const [clientes, setClientes] = useState([]);
    const [message, setMessage] = useState('');

    useEffect(() => {
        fetchClients();
    }, []);

    const fetchClients = async () => {
        try {
            const response = await axios.get('http://localhost:8080/cliente');
            setClientes(response.data);
        } catch (error) {
            console.error('Erro ao buscar clientes:', error);
        }
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await axios.post(`http://localhost:8080/contaCorrente/cliente/${clienteId}`, {
                saldo,
                limite,
                numero,
            });

            if (response.status === 201) {
                setMessage('Conta corrente criada com sucesso!');
            } else {
                setMessage('Erro ao criar conta corrente. Tente novamente.');
            }
        } catch (error) {
            setMessage('Erro ao criar conta corrente. Tente novamente.');
        }
    };

    return (
        <div>
            <h2>Criar Conta Corrente</h2>
            <form onSubmit={handleSubmit}>
                <label htmlFor="saldo">Saldo:</label>
                <input
                    type="number"
                    id="saldo"
                    value={saldo}
                    onChange={(e) => setSaldo(e.target.value)}
                />
                <br />

                <label htmlFor="limite">Limite:</label>
                <input
                    type="number"
                    id="limite"
                    value={limite}
                    onChange={(e) => setLimite(e.target.value)}
                />
                <br />

                <label htmlFor="numero">Número:</label>
                <input
                    type="text"
                    id="numero"
                    value={numero}
                    onChange={(e) => setNumero(e.target.value)}
                />
                <br />

                <label htmlFor="clienteId">Cliente:</label>
                <select
                    id="clienteId"
                    value={clienteId}
                    onChange={(e) => setClienteId(e.target.value)}
                    onClick={fetchClients}
                >
                    <option value="">Selecione o cliente</option>
                    {clientes.map((cliente) => (
                        <option key={cliente.clienteId} value={cliente.clienteId}>
                            {cliente.nome} - ID: {cliente.id}
                        </option>
                    ))}
                </select>
                <br />

                <button type="submit">Criar Conta Corrente</button>
            </form>
            {message && <p>{message}</p>}
        </div>
    );
};

export default CreateAccount;
