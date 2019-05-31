package com.alex.sms.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Quarter {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@NotNull
	private Integer number;

	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;

	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "school_year_id")
	private SchoolYear schoolYear;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="quarter")
    private List<ReportCard> reportCards;

	/**
	 * 
	 */
	public Quarter() {
		super();
	}

	/**
	 * @param id
	 * @param number
	 * @param startDate
	 * @param endDate
	 * @param schoolYear
	 */
	public Quarter(Integer id, Integer number, Date startDate, Date endDate, SchoolYear schoolYear) {
		super();
		this.id = id;
		this.number = number;
		this.startDate = startDate;
		this.endDate = endDate;
		this.schoolYear = schoolYear;
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
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the schoolYear
	 */
	public SchoolYear getSchoolYear() {
		return schoolYear;
	}

	/**
	 * @param schoolYear the schoolYear to set
	 */
	public void setSchoolYear(SchoolYear schoolYear) {
		this.schoolYear = schoolYear;
	}
}
