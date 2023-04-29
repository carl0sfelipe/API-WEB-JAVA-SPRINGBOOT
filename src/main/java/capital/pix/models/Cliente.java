package capital.pix.models;
import jakarta.persistence.*;

@Entity
@Table(name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "ClienteNome")
    private String ClienteNome;
    @Column(name = "ClienteCPF")
    private String ClienteCPF;
    @Column(name = "ClienteFone")
    private String ClienteFone;

    public int getId() {
        return id;
    }

    public String getNome() {
        return ClienteNome;
    }

    public String getApellido() {
        return ClienteCPF;
    }

    public String getClienteFone() {
        return ClienteFone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClienteNome(String ClienteNome) {
        this.ClienteNome = ClienteNome;
    }

    public void setClienteCPF(String ClienteCPF) {
        this.ClienteCPF = ClienteCPF;
    }

    public void setClienteFone(String ClienteFone) {
        this.ClienteFone = ClienteFone;
    }
}
