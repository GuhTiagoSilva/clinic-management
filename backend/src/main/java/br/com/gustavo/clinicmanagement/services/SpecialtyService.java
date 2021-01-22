package br.com.gustavo.clinicmanagement.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gustavo.clinicmanagement.dto.SpecialtyDTO;
import br.com.gustavo.clinicmanagement.entities.Specialty;
import br.com.gustavo.clinicmanagement.repositories.SpecialtyRepository;
import br.com.gustavo.clinicmanagement.services.exceptions.ResourceNotFoundException;

@Service
public class SpecialtyService {

	@Autowired
	private SpecialtyRepository repository;

	@Transactional(readOnly = true)
	public List<SpecialtyDTO> findAll() {
		List<Specialty> specialties = repository.findAll();
		return specialties.stream().map(specialty -> new SpecialtyDTO(specialty)).collect(Collectors.toList());
	}

	@Transactional
	public SpecialtyDTO insert(SpecialtyDTO dto) {
		Specialty entity = new Specialty();
		entity.setIsActive(true);
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new SpecialtyDTO(entity);
	}

	@Transactional
	public SpecialtyDTO update(Long id, SpecialtyDTO dto) {

		try {
			Specialty entity = repository.getOne(id);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new SpecialtyDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Entity Not Found");
		}
	}

	@Transactional(readOnly = true)
	public SpecialtyDTO findById(Long id) {
		Optional<Specialty> specialty = repository.findById(id);
		Specialty entity = specialty.orElseThrow(() -> new ResourceNotFoundException("Id Not Found: " + id));
		return new SpecialtyDTO(entity);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Entity Not Found");
		}
	}
}
