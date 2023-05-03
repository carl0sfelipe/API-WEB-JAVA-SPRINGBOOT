import logo from './logo.svg';
import './App.css';
import CreateAgency from './components/CriarAgencia';
import CreateClient from './components/CriarCliente';
import CreateAccount from './components/CriarConta';
import ExpandableListAccounts from './components/MostrarContas';

function App() {
  return (
    <div className="App">
<CreateAgency/>  
<CreateClient/>
<CreateAccount/>
<ExpandableListAccounts/>
  </div>
  );
}

export default App;
