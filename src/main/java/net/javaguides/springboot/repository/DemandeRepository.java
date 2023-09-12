package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import net.javaguides.springboot.model.Demande;

@Repository
@Transactional

public interface DemandeRepository extends JpaRepository<Demande, Long> {

}