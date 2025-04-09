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

}
