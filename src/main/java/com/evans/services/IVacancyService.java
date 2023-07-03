package com.evans.services;

import java.util.List;
import java.util.Optional;

import com.evans.models.Vacancy;

public interface IVacancyService {

	public List<Vacancy> getAll();

	public Optional<Vacancy> getById(Long id);

	public Vacancy save(Vacancy vacancy);

	public Vacancy delete(Long id);

}
