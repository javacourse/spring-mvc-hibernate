package com.myapp.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by dma on 3/3/15.
 */
@Entity
public class Company  implements Serializable {
    private static final long serialVersionUID = -1308795024262635690L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String companyName;

    @Column
    private String companyAddress;

    public Company() {
    }

    public Company(String companyName, String lastName) {
        super();
        this.companyName = companyName;
        this.companyAddress = companyAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    @Override
    public String toString() {

        return super.toString() + " name = " + companyName + " " + companyAddress + " id = " + id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((companyName == null) ? 0 : companyName.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result
                + ((companyAddress == null) ? 0 : companyAddress.hashCode());
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
        Company other = (Company) obj;
        if (companyName == null) {
            if (other.companyName != null)
                return false;
        } else if (!companyName.equals(other.companyName))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (companyAddress == null) {
            if (other.companyAddress != null)
                return false;
        } else if (!companyAddress.equals(other.companyAddress))
            return false;
        return true;
    }


}
