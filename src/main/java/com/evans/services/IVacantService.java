package com.evans.services;

import java.util.List;
import java.util.Optional;

import com.evans.models.Vacancy;

public interface IVacantService {

	public List<Vacancy> getAll();

	public Optional<Vacancy> getById(Long id);

	public Vacancy save(Vacancy vacant);

	public Vacancy delete(Long id);

}
