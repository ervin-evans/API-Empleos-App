package com.evans.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evans.models.Vacancy;
import com.evans.repository.IVacancyRepository;
import com.evans.services.IVacancyService;

@Service
public class VacancyServicesImpl implements IVacancyService {

	@Autowired
	private IVacancyRepository iVacancyRepository;

	@Override
	public List<Vacancy> getAll() {
		return iVacancyRepository.findAll();
	}

	@Override
	public Optional<Vacancy> getById(Long id) {
		return iVacancyRepository.findById(id);
	}

	@Override
	public Vacancy save(Vacancy vacant) {
		return iVacancyRepository.save(vacant);
	}

	@Override
	public Vacancy delete(Long id) {
		Optional<Vacancy> vacant = iVacancyRepository.findById(id);
		if (vacant.isPresent()) {
			iVacancyRepository.delete(vacant.get());
			return vacant.get();
		}
		return null;
	}

}
