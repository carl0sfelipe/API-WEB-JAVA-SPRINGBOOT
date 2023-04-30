package capital.pix.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.security.SecureRandom;

@Entity
@Table(name = "conta_corrente")
public class ContaCorrente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Cliente cliente;

    @Column(name = "agencia", columnDefinition = "VARCHAR(4) DEFAULT '0001'")
    private String agencia = "0001";

    @Column(name = "numero")
    private String numero;

    @Column(name = "saldo", columnDefinition = "DECIMAL(11, 2)")
    private BigDecimal saldo;

    public ContaCorrente() {
        this.numero = generateRandomNumber(10); // Generate a random 10-digit number
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    private String generateRandomNumber(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10)); // Append a random digit (0-9)
        }

        return sb.toString();
    }
}
