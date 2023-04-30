package capital.pix.services;

import capital.pix.models.ContaCorrente;

import java.math.BigDecimal;
import java.util.List;

public interface ContaCorrenteService {
    public ContaCorrente criarContaCorrenteAutomatica(int clienteId) ;

    public boolean depositar(int contaId, BigDecimal valor);

    public boolean sacar(int contaId, BigDecimal valor);

    public BigDecimal consultarSaldo(int contaId);

    public boolean transferir(int contaOrigemId, int contaDestinoId, BigDecimal valor);

    public ContaCorrente buscarContaCorrente(int contaId);

    public List<ContaCorrente> listarContas();
}
