package com.alex.sms.repository;

import org.springframework.data.repository.CrudRepository;

import com.alex.sms.model.SchoolYear;

public interface SchoolYearRepository extends CrudRepository<SchoolYear, Integer> {
	Iterable<SchoolYear> findFirst5ByOrderByIdDesc();
}
