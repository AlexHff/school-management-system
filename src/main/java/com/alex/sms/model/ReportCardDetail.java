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
public class ReportCardDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@NotNull
	@OneToOne
	private ReportCard reportCard;

	@NotNull
	@ManyToOne
	private Teaching teaching;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="reportCardDetail")
    private List<Grade> grades;
	
	String appreciation;

	/**
	 * 
	 */
	public ReportCardDetail() {
		super();
	}

	/**
	 * @param id
	 * @param reportCard
	 * @param teaching
	 * @param appreciation
	 */
	public ReportCardDetail(Integer id, ReportCard reportCard, Teaching teaching, String appreciation) {
		super();
		this.id = id;
		this.reportCard = reportCard;
		this.teaching = teaching;
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

	/**
	 * @return the teaching
	 */
	public Teaching getTeaching() {
		return teaching;
	}

	/**
	 * @param teaching the teaching to set
	 */
	public void setTeaching(Teaching teaching) {
		this.teaching = teaching;
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
