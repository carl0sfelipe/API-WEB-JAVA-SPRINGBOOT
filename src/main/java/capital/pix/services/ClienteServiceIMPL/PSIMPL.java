package capital.pix.services.ClienteServiceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capital.pix.models.Cliente;
import capital.pix.repository.ClienteRepo;
import capital.pix.services.ClienteService;

import java.util.List;

@Service

public class PSIMPL implements ClienteService{
    @Autowired
    private ClienteRepo repo;
    @Override
    public List<Cliente> consultarCliente() {
        return (List<Cliente>) this.repo.findAll();
    }

    @Override
    public Cliente criarCliente(Cliente cliente) {
        return this.repo.save(cliente);
    }

    @Override
    public Cliente modificarCliente(Cliente cliente) {
        return this.repo.save(cliente);
    }

    @Override
    public Cliente buscarCliente(int id) {
        return this.repo.findById(id).get();
    }

    @Override
    public void eliminarCliente(int id) {
        this.repo.deleteById(id);
    }
}
