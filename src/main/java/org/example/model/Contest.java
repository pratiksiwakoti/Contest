package org.example.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
public class Contest {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private int capacity;


    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(nullable = true)
    private Date date;

    @Column(nullable = true)
    private boolean registration_allowed;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(nullable = true)
    private Date registration_from;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(nullable = true)
    private Date registration_to;

    private boolean writable;


    @OneToMany(mappedBy = "superContest"/*, cascade = CascadeType.ALL, fetch = FetchType.LAZY*/)
    //annotation bellow is just for Jackson serialization in controller
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIdentityReference(alwaysAsId=true)
    private Set<Contest> subContests = new HashSet<>();

    @ManyToOne(/*, cascade = CascadeType.ALL, fetch = FetchType.LAZY*/)
    @JoinColumn(name = "CONTEST_ID")
    //annotation bellow is just for Jackson serialization in controller
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIdentityReference(alwaysAsId=true)
    private Contest superContest;


    @ManyToMany(/*, cascade = CascadeType.ALL, fetch = FetchType.LAZY*/)
    @JoinTable(
            name = "managers",
            joinColumns = @JoinColumn(name = "contest_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    //annotation bellow is just for Jackson serialization in controller
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() { return capacity; }

    public void setCapacity(int capacity) { this.capacity = capacity; }

    public Date getDate() { return date; }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean getRegistration_allowed() { return registration_allowed;}

    public void setRegistration_allowed(boolean registration_allowed) { this.registration_allowed = registration_allowed;}

    public Date getRegistration_from() { return registration_from; }

    public void setRegistration_from(Date registration_from) {
        this.registration_from = registration_from;
    }

    public Date getRegistration_to() { return registration_to; }

    public void setRegistration_to(Date registration_to) {
        this.registration_to = registration_to;
    }

    public boolean getWritable(){return writable;}

    public void setWritable(boolean writable){this.writable = writable;}

    //public void setReadOnly(Contest c){this.editable = false;}


    public Set<Contest> getSubContests() { return subContests; }

    public void setSubContests(Set<Contest> subContests) {
        this.subContests = subContests;
    }

    public Contest getSuperContest(){return superContest;}

    public void setSuperContest(Contest superContest) {
        this.superContest = superContest;
    }



    @Override
    public int hashCode() {
        return Objects.hash(id, name, capacity, date, registration_allowed, registration_from, registration_to, writable);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contest other = (Contest) obj;
        return Objects.equals(id, other.id) && Objects.equals(name, other.name) && capacity == other.capacity
                && writable == other.writable && registration_allowed == other.registration_allowed;
    }



}

