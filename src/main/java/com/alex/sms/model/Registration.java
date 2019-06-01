package com.alex.sms.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Registration {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	private Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());

	@NotNull
	@ManyToOne
	private Class c;

	@NotNull
	@OneToOne
	private Student student;
	
	@OneToOne(cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, mappedBy="registration")
    private ReportCard reportCard;

	/**
	 * 
	 */
	public Registration() {
		super();
	}

	/**
	 * @param id
	 * @param c
	 * @param student
	 */
	public Registration(Integer id, Class c, Student student) {
		super();
		this.id = id;
		this.c = c;
		this.student = student;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the c
	 */
	public Class getC() {
		return c;
	}

	/**
	 * @param c the c to set
	 */
	public void setC(Class c) {
		this.c = c;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
}
