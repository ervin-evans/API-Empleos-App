package com.evans.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evans.models.Vacancy;
import com.evans.requests.responses.RequestVacancy;
import com.evans.services.IVacancyService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/api/v1/vacancies")
public class VacanciesController {

	@Autowired
	private IVacancyService iVacancyService;

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
}
