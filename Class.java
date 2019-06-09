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
public class Class {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	private String name;
	
	@NotNull
	@ManyToOne
	private School school;
	
	@NotNull
	@ManyToOne
	private Level level;
	
	@NotNull
	@ManyToOne
	private SchoolYear schoolYear;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="c")
    private List<Teaching> teachings;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="c")
    private List<Registration> registrations;

	/**
	 * 
	 */
	public Class() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param school
	 * @param level
	 * @param schoolYear
	 */
	public Class(Integer id, String name, School school, Level level, SchoolYear schoolYear) {
		super();
		this.id = id;
		this.name = name;
		this.school = school;
		this.level = level;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the school
	 */
	public School getSchool() {
		return school;
	}

	/**
	 * @param school the school to set
	 */
	public void setSchool(School school) {
		this.school = school;
	}

	/**
	 * @return the level
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(Level level) {
		this.level = level;
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
