package com.evans.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evans.models.Vacancy;
import com.evans.services.IVacancyService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/api/v1/vacancy")
public class VacanciesController {

	@Autowired
	private IVacancyService iVacancyService;

	private Vacancy vacancy;

	@GetMapping("/get-all")
	public ResponseEntity<Map<String, Object>> getAllVacants() {
		Map<String, Object> response = new HashMap<>();
		try {
			List<Vacancy> vacancies = iVacancyService.getAll();
			response.put("vacancies", vacancies);
		} catch (DataAccessException e) {
			response.put("errors",
					"Hubo errores al recuperar las vacantes porque " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> getById(@PathVariable("id") @Min(1) Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			Optional<Vacancy> vacancy = iVacancyService.getById(id);
			if (vacancy.isPresent()) {
				response.put("vacancy", vacancy.get());
			} else {
				response.put("message", "No hay vacante con el id proporcionado");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException e) {
			response.put("errors",
					"Hubo errores al recuperar el usuario por id porque " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Map<String, Object>> addVacancy(@Valid @RequestBody Vacancy request, BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		// Validamos los campos del formulario
		if (result.hasErrors()) {
			List<String> errors = new ArrayList<String>();
			result.getFieldErrors().forEach(e -> {
				errors.add(e.getDefaultMessage());
			});
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			vacancy = iVacancyService.save(request);
			response.put("message", "La vacante de " + vacancy.getName() + " ha sido guardado!");
			response.put("vacancy", vacancy);

		} catch (DataAccessException e) {
			response.put("errors", "Hubo errores al guardar la vacante porque " + e.getRootCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Map<String, Object>> updateVacancy(@Valid @RequestBody Vacancy request, BindingResult result,
			@PathVariable("id") Long id) {
		Map<String, Object> response = new HashMap<>();
		// Verificamos los errores de validacion
		if (result.hasErrors()) {
			List<String> errors = new ArrayList<String>();
			result.getFieldErrors().forEach(e -> {
				errors.add(e.getDefaultMessage());
			});

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		// En caso de no haber erroes procedemos a guardar al vacante

		try {
			Optional<Vacancy> vacancyOptional = iVacancyService.getById(id);
			if (!vacancyOptional.isPresent()) {
				response.put("errors", "No fue encontrada la vacante con el id proporcionado");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
			vacancy = iVacancyService.save(request);
			response.put("message", "La vacante " + vacancy.getName() + " fue guardada existosamente!");
			response.put("vacancy", vacancy);

		} catch (DataAccessException e) {
			response.put("errors", "Hubo errores al actualizar la vacante porque " + e.getRootCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
