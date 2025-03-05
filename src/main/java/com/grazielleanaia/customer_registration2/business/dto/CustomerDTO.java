package com.grazielleanaia.customer_registration2.business.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class CustomerDTO {

    private String name;

    private String email;

    private String password;

    List<PhoneDTO> phones;

    List<ResidenceDTO> residences;



//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public List<PhoneDTO> getPhones() {
//        return phones;
//    }
//
//    public void setPhones(List<PhoneDTO> phones) {
//        this.phones = phones;
//    }
//
//    public List<ResidenceDTO> getResidences() {
//        return residences;
//    }
//
//    public void setResidences(List<ResidenceDTO> residences) {
//        this.residences = residences;
//    }
//
//    public CustomerDTO(String name, String email, String password, List<PhoneDTO> phones, List<ResidenceDTO> residences) {
//        this.name = name;
//        this.email = email;
//        this.password = password;
//        this.phones = phones;
//        this.residences = residences;
//    }
//
//    public CustomerDTO() {
//    }
}
