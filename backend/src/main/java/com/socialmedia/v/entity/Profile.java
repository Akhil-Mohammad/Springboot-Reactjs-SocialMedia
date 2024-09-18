package com.socialmedia.v.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Profile {

    @Id
    private String id;

    private String fullName;

    @Column(unique = true, nullable = false)
    private String username;

    private String image;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @OneToMany(mappedBy = "profileId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Posts> posts;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Profile(){

    }
    public Profile(String id, String fullName, String username, String image, Date dob) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.dob = dob;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", image='" + image + '\'' +
                ", dob=" + dob +
                '}';
    }
}
