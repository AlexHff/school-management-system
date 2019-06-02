package com.alex.sms.repository;

import org.springframework.data.repository.CrudRepository;

import com.alex.sms.model.ReportCardDetail;

public interface ReportCardDetailRepository extends CrudRepository<ReportCardDetail, Integer> {
	Iterable<ReportCardDetail> findByReportCardId(Integer id);
}
