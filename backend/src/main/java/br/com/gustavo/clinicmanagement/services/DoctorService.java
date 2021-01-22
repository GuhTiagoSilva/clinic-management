package br.com.gustavo.clinicmanagement.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gustavo.clinicmanagement.dto.DoctorDTO;
import br.com.gustavo.clinicmanagement.dto.SpecialtyDTO;
import br.com.gustavo.clinicmanagement.entities.Doctor;
import br.com.gustavo.clinicmanagement.entities.Specialty;
import br.com.gustavo.clinicmanagement.repositories.DoctorRepository;
import br.com.gustavo.clinicmanagement.repositories.SpecialtyRepository;
import br.com.gustavo.clinicmanagement.services.exceptions.ResourceNotFoundException;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository repository;

	@Autowired
	private SpecialtyRepository specialtyRepository;

	@Transactional(readOnly = true)
	public Page<DoctorDTO> findAllPaged(PageRequest pageRequest) {
		Page<Doctor> list = repository.findAll(pageRequest);
		return list.map(x-> new DoctorDTO(x));
	}

	@Transactional
	public DoctorDTO insert(DoctorDTO dto) {
		Doctor entity = new Doctor();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new DoctorDTO(entity);
	}

	@Transactional
	public DoctorDTO update(Long id, DoctorDTO dto) {
		try {
			Doctor entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new DoctorDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Entity Not Found");
		}
	}

	@Transactional(readOnly = true)
	public DoctorDTO findById(Long id) {
		Optional<Doctor> doctor = repository.findById(id);
		Doctor entity = doctor.orElseThrow(() -> new ResourceNotFoundException("Id Not Found: " + id));
		return new DoctorDTO(entity);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Entity Not Found");
		}

	}

	private void copyDtoToEntity(DoctorDTO dto, Doctor entity) {
		entity.setAddress(dto.getAddress());
		entity.setCellphoneNumber(dto.getCellphoneNumber());
		entity.setComplement(dto.getComplement());
		entity.setCrmNumber(dto.getCrmNumber());
		entity.setHomeNumber(dto.getHomeNumber());
		entity.setName(dto.getName());
		entity.setNeighborhood(dto.getNeighborhood());
		entity.setZipCode(dto.getZipCode());
		entity.setPhoneNumber(dto.getPhoneNumber());
		entity.setIsActive(true);

		entity.getSpecialties().clear();

		for (SpecialtyDTO specialtyDTO : dto.getSpecialties()) {
			Optional<Specialty> specialty = specialtyRepository.findById(specialtyDTO.getId());
			Specialty specialtyEntity = specialty.get();
			entity.getSpecialties().add(specialtyEntity);
		}
	}

}
