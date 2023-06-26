package com.evans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evans.models.Vacancy;

@Repository
public interface IVacancyRepository extends JpaRepository<Vacancy, Long> {

}
