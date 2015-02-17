package com.myapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Person")
public class Person implements Serializable {

	private static final long serialVersionUID = -1308795024262635690L;


	@Id
	@Column (name = "personId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

/*
	@Column (name = "departamentId", nullable = false)
	private Long depId;
	public Long getDepId() {
		return depId;
	}
	public void setDepId(Long depId) {
		this.depId = depId;
	}
*/

	//@JoinTable(name = "Departament", joinColumns = @JoinColumn(name = "depId"), inverseJoinColumns = @JoinColumn(name = "ID_STUDENT"))


	//@Column (name = "departamentId", nullable = false)
	@ManyToOne(targetEntity = Departament.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "departamentId",nullable = false)
	private Departament departament;

	/*@ManyToOne
	@JoinColumn(name = "departamentId")
	private Departament departament;*/

	public Departament getDepartament() {return departament; }
	public void setDepartament(Departament departament) {this.departament = departament;}


	@Column (name = "firstName")
	private String firstName;

	@Column (name = "lastName")
	private String lastName;

	public Person() {
	}

	public Person(Departament departament,/* Long departamentId,*/ String firstName, String lastName) {
		//super();
		//this.departamentId = departamentId;

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
