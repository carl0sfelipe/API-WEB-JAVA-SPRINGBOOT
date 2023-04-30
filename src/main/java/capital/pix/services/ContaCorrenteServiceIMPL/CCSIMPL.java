package capital.pix.services.ContaCorrenteServiceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import capital.pix.models.Cliente;
import capital.pix.models.ContaCorrente;
import capital.pix.repository.ContaCorrenteRepo;
import capital.pix.services.ClienteService;
import capital.pix.services.ContaCorrenteService;

import java.math.BigDecimal;

@Service
public class CCSIMPL implements ContaCorrenteService {
    @Autowired
    private ContaCorrenteRepo contaCorrenteRepo;

    @Autowired
    private ClienteService clienteService;

    //@Override
    public ContaCorrente criarContaCorrenteAutomatica(int clienteId) {
        Cliente cliente = clienteService.buscarCliente(clienteId);
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setCliente(cliente);
        contaCorrente.setSaldo(BigDecimal.ZERO);
        return contaCorrenteRepo.save(contaCorrente);
    }

    @Override
    public boolean depositar(int contaId, BigDecimal valor) {
        ContaCorrente contaCorrente = contaCorrenteRepo.findById(contaId).orElse(null);
        if (contaCorrente != null) {
            contaCorrente.setSaldo(contaCorrente.getSaldo().add(valor));
            contaCorrenteRepo.save(contaCorrente);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean sacar(int contaId, BigDecimal valor) {
        ContaCorrente contaCorrente = contaCorrenteRepo.findById(contaId).orElse(null);
        if (contaCorrente != null) {
            BigDecimal novoSaldo = contaCorrente.getSaldo().subtract(valor);
            if (novoSaldo.compareTo(BigDecimal.ZERO) >= 0) {
                contaCorrente.setSaldo(novoSaldo);
                contaCorrenteRepo.save(contaCorrente);
                return true;
            }
        }
        return false;
    }

    @Override
    public BigDecimal consultarSaldo(int contaId) {
        ContaCorrente contaCorrente = contaCorrenteRepo.findById(contaId).orElse(null);
        if (contaCorrente != null) {
            return contaCorrente.getSaldo();
        } else {
            return BigDecimal.ZERO;
        }
    }

    @Override
    public boolean transferir(int contaOrigemId, int contaDestinoId, BigDecimal valor) {
        ContaCorrente contaOrigem = contaCorrenteRepo.findById(contaOrigemId).orElse(null);
        ContaCorrente contaDestino = contaCorrenteRepo.findById(contaDestinoId).orElse(null);
        if (contaOrigem != null && contaDestino != null) {
            BigDecimal novoSaldoOrigem = contaOrigem.getSaldo().subtract(valor);
            if (novoSaldoOrigem.compareTo(BigDecimal.ZERO) >= 0) {
                BigDecimal novoSaldoDestino = contaDestino.getSaldo().add(valor);
                contaOrigem.setSaldo(novoSaldoOrigem);
                contaDestino.setSaldo(novoSaldoDestino);
                contaCorrenteRepo.save(contaOrigem);
                contaCorrenteRepo.save(contaDestino);
                return true;
            }
        }
        return false;
    }

    @Override
    public ContaCorrente buscarContaCorrente(int contaId) {
        return contaCorrenteRepo.findById(contaId).orElse(null);
    }

    @Override
    public List<ContaCorrente> listarContas() {
        return contaCorrenteRepo.findAll();
    }
}
