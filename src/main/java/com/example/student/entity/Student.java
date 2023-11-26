package com.example.student.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;

@Entity

@Table(name = "student")
public class Student {
    public Student() {
    }

    public Student(int id, String name, String rank, String email,Address address) {
        this.id = id;
        this.name = name;
        this.rank = rank;
        this.email=email;
        this.street=address.getStreet();
        this.city=address.getCity();


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
    private int id;
    @Column(name="name")
    @NotBlank(message = "not blank")
    private String name;
    @Column(name="rank")
    private String rank;
    @Column(name="email")
    private String email;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @OneToOne
   @JoinColumn(name = "address_id")
   private Address address;
   @Transient
    private String emailandname;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    private String city;

   private String street;









}
