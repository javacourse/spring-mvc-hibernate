package com.myapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Departament")
public class Departament implements Serializable {

    private static final long serialVersionUID = -1308795024262635690L;

    @Id @Column(name="depId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long depId;

    @Column
    private String depName;

    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "Departament")
    private List<Departament> list;*/

    public Departament() {
    }

    public Departament(String depName) {
        super();
        this.depName = depName;
    }

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Override
    public String toString() {

       return super.toString() + " Departament = " + depName + " depId = " + depId;
    }

    @Override
    public int hashCode() {
        final int prime = 30;
        int result = 1;
        result = prime * result
                + ((depName == null) ? 0 : depName.hashCode());
        result = prime * result + ((depId == null) ? 0 : depId.hashCode());
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
        if (depId == null) {
            if (other.depId != null)
                return false;
        } else if (!depId.equals(other.depId))
            return false;
        return true;
    }

}
