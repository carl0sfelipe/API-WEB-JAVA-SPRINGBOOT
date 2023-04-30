package capital.pix.repository;

import capital.pix.models.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaCorrenteRepo extends JpaRepository<ContaCorrente, Integer> {
}
