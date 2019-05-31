package com.alex.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Grade {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	private ReportCardDetail reportCardDetail;
	
	double value;
	
	String appreciation;

	/**
	 * 
	 */
	public Grade() {
		super();
	}

	/**
	 * @param id
	 * @param reportCardDetail
	 * @param value
	 * @param appreciation
	 */
	public Grade(Integer id, ReportCardDetail reportCardDetail, double value, String appreciation) {
		super();
		this.id = id;
		this.reportCardDetail = reportCardDetail;
		this.value = value;
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
	 * @return the reportCardDetail
	 */
	public ReportCardDetail getReportCardDetail() {
		return reportCardDetail;
	}

	/**
	 * @param reportCardDetail the reportCardDetail to set
	 */
	public void setReportCardDetail(ReportCardDetail reportCardDetail) {
		this.reportCardDetail = reportCardDetail;
	}

	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(double value) {
		this.value = value;
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
