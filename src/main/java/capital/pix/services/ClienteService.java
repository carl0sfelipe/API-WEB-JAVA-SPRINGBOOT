package capital.pix.services;

import java.util.List;

import capital.pix.models.Cliente;

public interface ClienteService {
    public List<Cliente> consultarCliente();
    public Cliente criarCliente(Cliente cliente);
    public Cliente modificarCliente(Cliente cliente);
    public Cliente buscarCliente(int id);
    public void eliminarCliente(int id);
}
