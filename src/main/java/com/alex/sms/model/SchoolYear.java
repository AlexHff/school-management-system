package com.alex.sms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SchoolYear {
	@Id
	@Column(unique=true)
	private Integer id;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="schoolYear")
    private List<Class> classes;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="schoolYear")
    private List<Quarter> quarters;

	/**
	 * 
	 */
	public SchoolYear() {
		super();
	}

	/**
	 * @param id
	 */
	public SchoolYear(Integer id) {
		super();
		this.id = id;
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
}
