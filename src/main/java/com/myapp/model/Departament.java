package com.myapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Departament")
public class Departament implements Serializable {

    private static final long serialVersionUID = -1308795024262635690L;

    @Id
    @Column (name = "departamentId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /*@OneToMany(targetEntity = Person.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "departament")
    private List<Person> persons;*/
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "departamentId")
    private List<Person> persons;

    @Column
    private String depName;

    public Departament() {
    }

    public Departament(String depName) {
        //super();
        this.depName = depName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = id;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public List<Person> getPersons() {
        return persons;
    }
    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {

        return super.toString() + " Departament = " + depName + " id = " + id;
    }

    @Override
    public int hashCode() {
        final int prime = 30;
        int result = 1;
        result = prime * result
                + ((depName == null) ? 0 : depName.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Departament other = (Departament) obj;
        if (depName == null) {
            if (other.depName != null)
                return false;
        } else if (!depName.equals(other.depName))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
