package com.evans.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evans.models.Vacancy;
import com.evans.services.IVacantService;

@RestController
@RequestMapping("/api/v1/vacancies")
public class VacantController {

	@Autowired
	private IVacantService iVacantService;

	@GetMapping("/get-all")
	public ResponseEntity<Map<String, Object>> getAllVacants() {
		Map<String, Object> response = new HashMap<>();
		try {
			List<Vacancy> vacancies = iVacantService.getAll();
			response.put("vacancies", vacancies);
		} catch (DataAccessException e) {
			response.put("errors",
					"Hubo errores al recuperar las vacantes porque " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
