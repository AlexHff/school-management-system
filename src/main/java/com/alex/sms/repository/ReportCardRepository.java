package com.alex.sms.repository;

import org.springframework.data.repository.CrudRepository;

import com.alex.sms.model.ReportCard;

public interface ReportCardRepository extends CrudRepository<ReportCard, Integer> {
	ReportCard findByRegistrationId(Integer id);
}
