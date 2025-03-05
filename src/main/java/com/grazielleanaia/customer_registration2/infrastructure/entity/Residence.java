package com.grazielleanaia.customer_registration2.infrastructure.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "residence")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class Residence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street")
    private String street;


    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zipcode")
    private String zipCode;

    @Column(name = "customer_id")
    private Long customer_id;

//    public Residence(Long id, Long customer_id, String street, String city, String state, String zipCode) {
//        this.id = id;
//        this.street = street;
//        this.city = city;
//        this.state = state;
//        this.zipCode = zipCode;
//        this.customer_id = customer_id;
//    }
//
//    public Residence() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getStreet() {
//        return street;
//    }
//
//    public void setStreet(String street) {
//        this.street = street;
//    }
//
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public String getZipCode() {
//        return zipCode;
//    }
//
//    public void setZipCode(String zipCode) {
//        this.zipCode = zipCode;
//    }
//
//    public Long getCustomer_id() {
//        return customer_id;
//    }
//
//    public void setCustomer_id(Long customer_id) {
//        this.customer_id = customer_id;
//    }
}
