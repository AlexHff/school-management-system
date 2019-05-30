package com.alex.sms.repository;

import org.springframework.data.repository.CrudRepository;

import com.alex.sms.model.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {

}
