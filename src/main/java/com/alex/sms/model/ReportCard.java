package com.alex.sms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class ReportCard {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@NotNull
	@ManyToOne
	private Quarter quarter;

	@NotNull
	@OneToOne
	private Registration registration;
	
	@NotNull
	String appreciation;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="reportCard")
    private List<ReportCardDetail> reportCardDetail;

	/**
	 * 
	 */
	public ReportCard() {
		super();
	}

	/**
	 * @param id
	 * @param quarter
	 * @param registration
	 * @param appreciation
	 */
	public ReportCard(Integer id, Quarter quarter, Registration registration, String appreciation) {
		super();
		this.id = id;
		this.quarter = quarter;
		this.registration = registration;
		this.appreciation = appreciation;
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
	 * @return the quarter
	 */
	public Quarter getQuarter() {
		return quarter;
	}

	/**
	 * @param quarter the quarter to set
	 */
	public void setQuarter(Quarter quarter) {
		this.quarter = quarter;
	}

	/**
	 * @return the registration
	 */
	public Registration getRegistration() {
		return registration;
	}

	/**
	 * @param registration the registration to set
	 */
	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	/**
	 * @return the appreciation
	 */
	public String getAppreciation() {
		return appreciation;
	}

	/**
	 * @param appreciation the appreciation to set
	 */
	public void setAppreciation(String appreciation) {
		this.appreciation = appreciation;
	}
}
