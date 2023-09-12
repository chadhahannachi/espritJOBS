package net.javaguides.springboot.repository;

//import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.javaguides.springboot.model.Entreprise;

@Repository
@Transactional
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
	//List<Entreprise> findByTitleContainingIgnoreCase(String keyword);

}
