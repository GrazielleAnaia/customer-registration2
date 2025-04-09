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

}
