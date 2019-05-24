package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SchoolYear {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

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
