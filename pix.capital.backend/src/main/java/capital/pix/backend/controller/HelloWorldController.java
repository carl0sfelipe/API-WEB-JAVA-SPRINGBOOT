package capital.pix.backend.controller;

import capital.pix.backend.model.Cliente;
import capital.pix.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloWorldController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/hello")
    public List<Cliente> helloWorld() {
        return clienteRepository.findAll();
    }
}
