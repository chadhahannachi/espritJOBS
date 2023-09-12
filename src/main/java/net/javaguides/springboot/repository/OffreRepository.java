package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import net.javaguides.springboot.model.Offre;

@Repository
@Transactional

public interface OffreRepository extends JpaRepository<Offre, Long> {

}
