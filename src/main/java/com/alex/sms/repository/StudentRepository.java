package com.alex.sms.repository;

import org.springframework.data.repository.CrudRepository;

import com.alex.sms.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
