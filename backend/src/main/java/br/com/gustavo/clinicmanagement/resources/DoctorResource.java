package br.com.gustavo.clinicmanagement.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gustavo.clinicmanagement.dto.DoctorDTO;
import br.com.gustavo.clinicmanagement.services.DoctorService;

@RestController
@RequestMapping(value = "/doctors")
public class DoctorResource {

	@Autowired
	private DoctorService service;

	@PostMapping
	public ResponseEntity<DoctorDTO> insert(@RequestBody DoctorDTO dto) {
		dto = service.insert(dto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<DoctorDTO> update(@PathVariable Long id, @RequestBody DoctorDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<DoctorDTO> findById(@PathVariable Long id) {
		DoctorDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<DoctorDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
