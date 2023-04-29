package capital.pix.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ClienteNome")
    private String ClienteNome;

    @Column(name = "ClienteCPF")
    private String ClienteCPF;

    
    @Column(name = "ClienteFone")
    private String ClienteFone;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClienteNome() {
        return ClienteNome;
    }

    public void setClienteNome(String ClienteNome) {
        this.ClienteNome = ClienteNome;
    }

    public String getClienteCPF() {
        return ClienteCPF;
    }

    public void setClienteCPF(String ClienteCPF) {
        this.ClienteCPF = ClienteCPF;
    }    
    
    public String getClienteFone() {
        return ClienteFone;
    }

    public void setClienteFone(String ClienteFone) {
        this.ClienteFone = ClienteFone;
    }
}
