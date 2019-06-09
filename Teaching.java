package com.alex.sms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Teaching {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@NotNull
	@ManyToOne
	private Class c;

	@NotNull
	@ManyToOne
	private Subject subject;

	@NotNull
	@ManyToOne
	private Teacher teacher;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="teaching")
    private List<ReportCardDetail> ReportCardDetails;

	/**
	 * 
	 */
	public Teaching() {
		super();
	}

	/**
	 * @param id
	 * @param c
	 * @param subject
	 * @param teacher
	 */
	public Teaching(Integer id, Class c, Subject subject, Teacher teacher) {
		super();
		this.id = id;
		this.c = c;
		this.subject = subject;
		this.teacher = teacher;
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
	 * @return the subject
	 */
	public Subject getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	/**
	 * @return the teacher
	 */
	public Teacher getTeacher() {
		return teacher;
	}

	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
