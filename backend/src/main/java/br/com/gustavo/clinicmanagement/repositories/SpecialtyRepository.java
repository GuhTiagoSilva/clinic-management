package br.com.gustavo.clinicmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gustavo.clinicmanagement.entities.Specialty;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long>{

}
