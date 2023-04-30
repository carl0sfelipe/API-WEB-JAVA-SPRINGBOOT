package capital.pix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import capital.pix.models.Cliente;
import capital.pix.services.ClienteServiceIMPL.PSIMPL;

import java.util.List;

@RestController
@RequestMapping("api")
public class ClienteControlador {
    @Autowired
    private PSIMPL impl;

    @GetMapping
    @RequestMapping(value = "cliente",method = RequestMethod.GET)
    public ResponseEntity<?> consultarCliente(){
        List<Cliente> listaCliente = this.impl.consultarCliente();
        return ResponseEntity.ok(listaCliente);
    }

    @PostMapping
    @RequestMapping(value = "cliente",method = RequestMethod.POST)
    public ResponseEntity<?> criarCliente(@RequestBody Cliente Cliente){
       Cliente ClienteCriado = this.impl.criarCliente(Cliente);
       return ResponseEntity.status(HttpStatus.CREATED).body(ClienteCriado);
    }

    @PutMapping
    @RequestMapping(value = "cliente",method = RequestMethod.PUT)
    public ResponseEntity<?> modificarCliente(@RequestBody Cliente Cliente){
        Cliente ClienteModificado = this.impl.modificarCliente(Cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(ClienteModificado);
    }

    @GetMapping
    @RequestMapping(value = "cliente/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> buscarCliente(@PathVariable int id){
        Cliente Cliente = this.impl.buscarCliente(id);
        return ResponseEntity.ok(Cliente);
    }


    @DeleteMapping
    @RequestMapping(value = "cliente/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminarCliente(@PathVariable int id){
        this.impl.eliminarCliente(id);
        return ResponseEntity.ok().build();
    }




}
