package br.com.gustavo.clinicmanagement.resources;

import java.net.URI;
import java.util.List;

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

import br.com.gustavo.clinicmanagement.dto.SpecialtyDTO;
import br.com.gustavo.clinicmanagement.services.SpecialtyService;

@RestController
@RequestMapping(value = "/specialties")
public class SpecialtyResource {

	@Autowired
	private SpecialtyService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SpecialtyDTO> findById (@PathVariable Long id){
		SpecialtyDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<SpecialtyDTO>> findAll (){
		List<SpecialtyDTO> specialties = service.findAll();
		return ResponseEntity.ok().body(specialties);
	}
	
	@PostMapping
	public ResponseEntity<SpecialtyDTO> insert (@RequestBody SpecialtyDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<SpecialtyDTO>update (@PathVariable Long id, @RequestBody SpecialtyDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<SpecialtyDTO>delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
