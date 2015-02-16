package com.myapp.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ilya Ten
 * Date: 2/15/2015
 */
@Entity
public class Phone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String number;

    @Column
    private Person person;

    public Phone() {}

    public Phone(Person person) {
        super();
        this.person = person;
    }

    public Phone(Person person, String number) {
        super();
        this.person = person;
        this.number = number;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @ManyToOne
    @JoinColumn
    public Person getPerson() { return person; }
    public void setPerson(Person person) { this.person = person; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Phone other = (Phone) obj;
        if (number == null) {
            if (other.getNumber() != null)
                return false;
        } else if (!number.equals(other.getNumber()))
            return false;
        if (id == null) {
            if (other.getId() != null)
                return false;
        } else if (!id.equals(other.getId()))
            return false;
        return true;
    }
}
