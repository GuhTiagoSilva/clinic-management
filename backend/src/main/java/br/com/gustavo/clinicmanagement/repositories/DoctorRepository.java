package br.com.gustavo.clinicmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gustavo.clinicmanagement.entities.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{

}
