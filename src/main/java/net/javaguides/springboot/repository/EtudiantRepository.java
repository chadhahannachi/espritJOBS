package net.javaguides.springboot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import net.javaguides.springboot.model.Etudiant;

@Repository
@Transactional
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
  List<Etudiant> findByNomContainingIgnoreCase(String keyword);

}