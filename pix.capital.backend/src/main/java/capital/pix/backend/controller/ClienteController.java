package capital.pix.backend.controller;

import capital.pix.backend.model.Cliente;
import capital.pix.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public List<Cliente> GetClientes() {
        List<Cliente> ListaClientes = clienteRepository.findAll();
        return ListaClientes;
    }
}
