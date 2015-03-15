package com.myapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Person")
public class Person implements Serializable {

	private static final long serialVersionUID = -1308795024262635690L;
	//private String depName;

	@Id
	@Column (name = "personId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(targetEntity = Departament.class, cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "departamentId",nullable = false)
	private Departament departament;

	/*
	@ManyToOne(targetEntity = Company.class, cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "company_id")
	private Company company;
	* */

 	@Column (name = "firstName")
	private String firstName;

	@Column (name = "lastName")
	private String lastName;

	public Person() {
	}

	public Person(Departament departament, String firstName, String lastName) {

		this.departament = departament;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Departament getDepartament() {return departament; }
	public void setDepartament(Departament departament) {this.departament = departament;}

	@Override
	public String toString() {

		return super.toString() + " name = " + firstName + " " + lastName
				+ " id = " + id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

}
