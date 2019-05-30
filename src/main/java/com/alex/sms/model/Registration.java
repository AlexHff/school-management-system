package com.alex.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Registration {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	private Class c;
	
	@OneToOne
	private Student student;

	/**
	 * 
	 */
	public Registration() {
		super();
	}

	/**
	 * @param id
	 * @param c
	 * @param person
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
	 * @return the person
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Student student) {
		this.student = student;
	}
}
