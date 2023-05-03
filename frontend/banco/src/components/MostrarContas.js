import React, { useState } from 'react';
import axios from 'axios';

const ExpandableListAccounts = () => {
    const [accounts, setAccounts] = useState([]);
    const [isExpanded, setIsExpanded] = useState(false);

    const fetchAccounts = async () => {
        try {
            const response = await axios.get('http://localhost:8080/contaCorrente');
            setAccounts(response.data);
        } catch (error) {
            console.error('Erro ao buscar contas correntes:', error);
        }
    };

    const handleClick = async () => {
        if (!isExpanded) {
            await fetchAccounts();
        }
        setIsExpanded(!isExpanded);
    };

    return (
        <div>
            <h2>Contas Correntes</h2>
            <button onClick={handleClick}>{isExpanded ? 'Ocultar' : 'Exibir'}</button>
            {isExpanded && (
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Número</th>
                            <th>Saldo</th>
                            <th>Cliente</th>
                            <th>Agência</th>
                        </tr>
                    </thead>
                    <tbody>
                        {accounts.map((account) => (
                            <tr key={account.idContaCorrente}>
                                <td>{account.idContaCorrente}</td>
                                <td>{account.numero}</td>
                                <td>{account.saldo.toFixed(2)}</td>
                                <td>{account.cliente.nome}</td>
                                <td>{account.cliente.agencia.nome}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            )}
        </div>
    );
};

export default ExpandableListAccounts;
