package com.alex.sms.repository;

import org.springframework.data.repository.CrudRepository;

import com.alex.sms.model.Grade;

public interface GradeRepository extends CrudRepository<Grade, Integer> {
	Iterable<Grade> findByReportCardDetailId(Integer id);
}
