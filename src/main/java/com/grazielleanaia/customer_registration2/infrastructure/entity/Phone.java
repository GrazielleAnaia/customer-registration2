package com.grazielleanaia.customer_registration2.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "phone")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "customer_id")
    private Long customer_id;


//    public Phone(Long id, String number, Long customer_id) {
//        this.id = id;
//        this.number = number;
//        this.customer_id = customer_id;
//    }
//
//    public Phone() {
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
//    public String getNumber() {
//        return number;
//    }
//
//    public void setNumber(String number) {
//        this.number = number;
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
