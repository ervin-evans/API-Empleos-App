package com.evans.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evans.models.Vacancy;
import com.evans.repository.IVacantRepository;
import com.evans.services.IVacantService;

@Service
public class VacantsServicesImpl implements IVacantService {

	@Autowired
	private IVacantRepository iVacantRepository;

	@Override
	public List<Vacancy> getAll() {
		return iVacantRepository.findAll();
	}

	@Override
	public Optional<Vacancy> getById(Long id) {
		return iVacantRepository.findById(id);
	}

	@Override
	public Vacancy save(Vacancy vacant) {
		return iVacantRepository.save(vacant);
	}

	@Override
	public Vacancy delete(Long id) {
		Optional<Vacancy> vacant = iVacantRepository.findById(id);
		if (vacant.isPresent()) {
			iVacantRepository.delete(vacant.get());
			return vacant.get();
		}
		return null;
	}

}
