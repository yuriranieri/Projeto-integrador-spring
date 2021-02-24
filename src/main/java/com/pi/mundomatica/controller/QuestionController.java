package com.pi.mundomatica.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

import com.pi.mundomatica.dto.CreateQuestionDto;
import com.pi.mundomatica.dto.QuestionDto;
import com.pi.mundomatica.dto.UpdateQuestionDto;
import com.pi.mundomatica.model.AlternativeEntity;
import com.pi.mundomatica.model.ModuleEntity;
import com.pi.mundomatica.model.QuestionEntity;
import com.pi.mundomatica.repository.AlternativeRepository;
import com.pi.mundomatica.repository.ModuleRepository;
import com.pi.mundomatica.repository.QuestionRepository;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private ModuleRepository moduleRepository;

	@Autowired
	private AlternativeRepository alternativeRepository;

	@GetMapping
	public List<QuestionDto> listQuestions() {
		List<QuestionEntity> questions = questionRepository.findAll();
		return QuestionDto.convertToList(questions);
	}

	@GetMapping("/{id}")
	public ResponseEntity<QuestionDto> listOndeQuestion(@PathVariable Long id) {
		Optional<QuestionEntity> optional = questionRepository.findById(id);

		if (optional.isPresent()) {
			return ResponseEntity.ok(new QuestionDto(optional.get()));
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@PostMapping
	public ResponseEntity<QuestionDto> creteQuestion(@RequestBody @Valid CreateQuestionDto dto) {
		Optional<ModuleEntity> optional = moduleRepository.findById(dto.getModuleId());

		if (optional.isPresent()) {
			ModuleEntity module = optional.get();
			QuestionEntity question = new QuestionEntity(module);

			List<AlternativeEntity> alternatives = buildListAlternatives(question, dto);

			question.setAlternatives(alternatives);
			question.setDescription(dto.getDescription());
			question.setDifficulty(dto.getDifficulty());

			questionRepository.save(question);
			return ResponseEntity.status(HttpStatus.CREATED).body(new QuestionDto(question));
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@PutMapping
	public ResponseEntity<QuestionDto> updateQuestion(@RequestBody @Valid UpdateQuestionDto dto) {
		Optional<QuestionEntity> optional = questionRepository.findById(dto.getId());
		Optional<ModuleEntity> optional2 = moduleRepository.findById(dto.getModuleId());

		if (optional.isPresent() && optional2.isPresent()) {
			QuestionEntity question = optional.get();
			ModuleEntity module = optional2.get();
			List<AlternativeEntity> alternatives = updateListAlternatives(question, dto);

			question.setAlternatives(alternatives);
			question.setDescription(dto.getDescription());
			question.setDifficulty(dto.getDifficulty());
			question.setModule(module);

			questionRepository.save(question);

			return ResponseEntity.ok(new QuestionDto(question));
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable Long id) {
		Optional<QuestionEntity> optional = questionRepository.findById(id);

		if (optional.isPresent()) {
			questionRepository.deleteById(id);
			return ResponseEntity.ok("deletado com sucesso");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("questão não encontrada");
		}

	}

	private List<AlternativeEntity> buildListAlternatives(QuestionEntity question, @Valid CreateQuestionDto dto) {
		return dto.getAlternatives().stream().map(alternative -> {
			try {
				return new AlternativeEntity(alternative.getTrueFalse(), alternative.getValue(), question);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}).collect(Collectors.toList());
	}

	private List<AlternativeEntity> updateListAlternatives(QuestionEntity question, @Valid UpdateQuestionDto dto) {
		return dto.getAlternatives().stream().map(a -> {
			try {
				AlternativeEntity alternative = alternativeRepository.findById(a.getId()).get();
				
				alternative.setTrueFalse(a.getTrueFalse());
				alternative.setValue(a.getValue());
				
				return alternative;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}).collect(Collectors.toList());
	}

}
