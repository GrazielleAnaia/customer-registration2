package com.grazielleanaia.customer_registration2.business.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class ResidenceDTO {

    private Long id;

    private String street;

    private String city;

    private String state;

    private String zipCode;

}
