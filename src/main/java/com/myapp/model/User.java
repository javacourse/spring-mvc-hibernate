package com.myapp.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Ilya Ten
 * Date: 3/22/2015
 */
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "user_id")
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private boolean enabled;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Role> roles;

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}
