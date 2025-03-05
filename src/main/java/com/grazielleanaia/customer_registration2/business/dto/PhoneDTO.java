package com.grazielleanaia.customer_registration2.business.dto;

import lombok.*;

@Builder

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class PhoneDTO {

    private Long id;

    private String number;

    private Long customer_id;

//    public String getNumber() {
//        return number;
//    }
//
//    public void setNumber(String number) {
//        this.number = number;
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
//    public PhoneDTO(String number, Long id) {
//        this.number = number;
//        this.id = id;
//    }
//
//    public PhoneDTO() {
//    }
}
