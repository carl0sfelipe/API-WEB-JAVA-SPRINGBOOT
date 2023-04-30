package capital.pix.models;
import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "cliente_nome")
    private String cliente_nome;
    @Column(name = "cliente_cpf")
    private String cliente_cpf;
    @Column(name = "cliente_fone")
    private String cliente_fone;

    public int getId() {
        return id;
    }

    public String getCliente_nome() {
        return cliente_nome;
    }

    public String getCliente_cpf() {
        return cliente_cpf;
    }

    public String getCliente_fone() {
        return cliente_fone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCliente_nome(String cliente_nome) {
        this.cliente_nome = cliente_nome;
    }

    public void setCliente_cpf(String cliente_cpf) {
        this.cliente_cpf = cliente_cpf;
    }

    public void setCliente_fone(String cliente_fone) {
        this.cliente_fone = cliente_fone;
    }

    public Cliente() {
    }
    
    
}
