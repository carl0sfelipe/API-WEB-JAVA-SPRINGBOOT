package capital.pix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import capital.pix.models.Cliente;
import capital.pix.models.ContaCorrente;
//import capital.pix.services.ClienteService;
import capital.pix.services.ContaCorrenteService;
import capital.pix.requests.TransferenciaRequest;

import java.math.BigDecimal;

@RestController
@RequestMapping("api")
public class ContaCorrenteControlador {
    // @Autowired
    // private ClienteService clienteService;

    @Autowired
    private ContaCorrenteService contaCorrenteService;

    // @PostMapping("cliente")
    // public ResponseEntity<?> criarCliente(@RequestBody Cliente cliente) {
    //     Cliente clienteCriado = clienteService.criarCliente(cliente);
    //     //ContaCorrente contaCorrente = ContaCorrenteService.criarContaCorrenteAutomatica(clienteCriado.getId());
    //     return ResponseEntity.status(HttpStatus.CREATED).body(clienteCriado);
    // }

    @PostMapping("conta-corrente/{contaId}/deposito")
    public ResponseEntity<?> depositar(@PathVariable int contaId, @RequestBody BigDecimal valor) {
        contaCorrenteService.depositar(contaId, valor);
        return ResponseEntity.ok().build();
    }

    @PostMapping("conta-corrente/{contaId}/saque")
    public ResponseEntity<?> sacar(@PathVariable int contaId, @RequestBody BigDecimal valor) {
        boolean sucesso = contaCorrenteService.sacar(contaId, valor);
        if (sucesso) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("Saldo insuficiente");
        }
    }

    @GetMapping("conta-corrente/{contaId}/saldo")
    public ResponseEntity<?> consultarSaldo(@PathVariable int contaId) {
        BigDecimal saldo = contaCorrenteService.consultarSaldo(contaId);
        return ResponseEntity.ok(saldo);
    }

    @PostMapping("conta-corrente/{contaOrigemId}/transferencia")
    public ResponseEntity<?> transferir(@PathVariable int contaOrigemId, @RequestBody TransferenciaRequest transferencia) {
        boolean sucesso = contaCorrenteService.transferir(contaOrigemId, transferencia.getContaDestinoId(), transferencia.getValor());
        if (sucesso) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("Saldo insuficiente");
        }
    }

    @GetMapping("conta-corrente/{contaId}")
    public ResponseEntity<?> buscarContaCorrente(@PathVariable int contaId) {
        ContaCorrente contaCorrente = contaCorrenteService.buscarContaCorrente(contaId);
        if (contaCorrente != null) {
            return ResponseEntity.ok(contaCorrente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
