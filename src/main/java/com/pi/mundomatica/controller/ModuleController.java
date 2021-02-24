package com.pi.mundomatica.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi.mundomatica.dto.ModuleDto;
import com.pi.mundomatica.model.ModuleEntity;
import com.pi.mundomatica.repository.ModuleRepository;

@RestController
@RequestMapping("/module")
public class ModuleController {

	@Autowired
	private ModuleRepository moduleRepository;

	@GetMapping
	public List<ModuleDto> listModules() {
		List<ModuleEntity> modules = moduleRepository.findAll();
		return ModuleDto.convertToList(modules);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ModuleDto> listOneModule(@PathVariable Long id) {
		Optional<ModuleEntity> optional = moduleRepository.findById(id);

		if (optional.isPresent()) {
			return ResponseEntity.ok(new ModuleDto(optional.get()));
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@PostMapping
	public ResponseEntity<ModuleDto> createModule(@RequestBody @Valid ModuleDto dto) {
		ModuleEntity entity = dto.covertToEntity(dto);
		moduleRepository.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ModuleDto(entity));
	}

	@PutMapping
	public ResponseEntity<ModuleDto> updateModule(@RequestBody @Valid ModuleDto dto) {
		Optional<ModuleEntity> optional = moduleRepository.findById(dto.getId());

		if (optional.isPresent()) {
			ModuleEntity entity = optional.get();
			
			entity.setContent(dto.getContent());
			entity.setName(dto.getName());
			entity.setThematic(dto.getThematic());

			moduleRepository.save(entity);
			 
			return ResponseEntity.ok(dto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteModule(@PathVariable Long id) {
		Optional<ModuleEntity> optional = moduleRepository.findById(id);

		if (optional.isPresent()) {
			moduleRepository.deleteById(id);
			return ResponseEntity.ok("Removido com sucesso");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modulo não encontrado");
		}
		
	}

}
