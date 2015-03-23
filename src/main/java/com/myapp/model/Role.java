package com.myapp.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ilya Ten
 * Date: 3/23/2015
 */
@Entity
@Table(name = "user_roles")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "role_id")
    private Long id;

    @Column
    private String authority;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}
