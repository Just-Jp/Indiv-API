package org.serratec.backend.controller;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;

import org.serratec.backend.models.Funcionario;
import org.serratec.backend.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@PostMapping
	public ResponseEntity<?> inserir(@Valid @RequestBody Funcionario funcionario) {
		funcionario = funcionarioRepository.save(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(funcionario);
	}
	
	@GetMapping
	public List<Funcionario> listar() {
		return funcionarioRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> pesquisar(@PathVariable Long id) {
		Optional<Funcionario> funcionarioOpt = funcionarioRepository.findById(id);
		if (funcionarioOpt.isPresent()) {
			return ResponseEntity.ok(funcionarioOpt.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id, @Valid @RequestBody Funcionario funcionario) {
		boolean exists = funcionarioRepository.existsById(id);
		if (!exists) {
			return ResponseEntity.notFound().build();
		}
		
		funcionario.setId(id);  
		funcionario = funcionarioRepository.save(funcionario);
		return ResponseEntity.ok(funcionario);
	}
		
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!funcionarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		funcionarioRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
}
