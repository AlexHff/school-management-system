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
	 * @param timestamp
	 * @param c
	 * @param student
	 * @param reportCard
	 */
	public Registration(Integer id, @NotNull Timestamp timestamp, @NotNull Class c, @NotNull Student student,
			ReportCard reportCard) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.c = c;
		this.student = student;
		this.reportCard = reportCard;
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

	/**
	 * @return the timestamp
	 */
	public Timestamp getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the reportCard
	 */
	public ReportCard getReportCard() {
		return reportCard;
	}

	/**
	 * @param reportCard the reportCard to set
	 */
	public void setReportCard(ReportCard reportCard) {
		this.reportCard = reportCard;
	}
}
