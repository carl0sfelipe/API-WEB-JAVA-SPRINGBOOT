package capital.pix.repository;

import org.springframework.data.repository.CrudRepository;
import capital.pix.models.Cliente;

public interface ClienteRepo extends CrudRepository <Cliente, Integer> {
    
}
