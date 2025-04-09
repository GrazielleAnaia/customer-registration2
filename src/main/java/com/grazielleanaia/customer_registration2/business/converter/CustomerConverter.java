package com.grazielleanaia.customer_registration2.business.converter;


import com.grazielleanaia.customer_registration2.business.dto.CustomerDTO;
import com.grazielleanaia.customer_registration2.business.dto.PhoneDTO;
import com.grazielleanaia.customer_registration2.business.dto.ResidenceDTO;
import com.grazielleanaia.customer_registration2.infrastructure.entity.Customer;
import com.grazielleanaia.customer_registration2.infrastructure.entity.Phone;
import com.grazielleanaia.customer_registration2.infrastructure.entity.Residence;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class CustomerConverter {

    public Customer convertToCustomer(CustomerDTO customerDTO) {
        return Customer.builder()
                .name(customerDTO.getName())
                .email(customerDTO.getEmail())
                .password(customerDTO.getPassword())
                .phones(customerDTO.getPhones() != null ? convertToPhoneList(customerDTO.getPhones()) : null)
                .residences(customerDTO.getResidences() != null ? convertToResidenceList(customerDTO.getResidences()) : null)
                .build();
    }

    public List<Residence> convertToResidenceList(List<ResidenceDTO> residenceDTOS) {
        return residenceDTOS.stream()
                .map(this::convertToResidence).toList();
    }

    public Residence convertToResidence(ResidenceDTO residenceDTO) {
        return Residence.builder()
                .street(residenceDTO.getStreet())
                .city(residenceDTO.getCity())
                .state(residenceDTO.getState())
                .zipCode(residenceDTO.getZipCode())
                .build();
    }

    public Phone convertToPhone(PhoneDTO phoneDTO) {
        return Phone.builder()
                .number(phoneDTO.getNumber())
                .build();
    }

    public List<Phone> convertToPhoneList(List<PhoneDTO> phoneDTOS) {
        return phoneDTOS.stream().map(this::convertToPhone).toList();
    }


    //Convert to DTOs
    public CustomerDTO convertToCustomerDTO(Customer customer) {
        return CustomerDTO.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .password(customer.getPassword())
                .residences(customer.getResidences() != null ? convertToListResidenceDTO(customer.getResidences()) : null)
                .phones(customer.getPhones() != null ? convertToListPhoneDTO(customer.getPhones()) : null)
                .build();
    }

    public ResidenceDTO convertToResidenceDTO(Residence residence) {
        return ResidenceDTO.builder()
                .id(residence.getId())
                .street(residence.getStreet())
                .city(residence.getCity())
                .state(residence.getState())
                .zipCode(residence.getZipCode())
                .build();
    }

    public List<ResidenceDTO> convertToListResidenceDTO(List<Residence> residences) {
        return residences.stream().map(this::convertToResidenceDTO).toList();
    }

    public PhoneDTO convertToPhoneDTO(Phone phone) {
        return PhoneDTO.builder()
                .id(phone.getId())
                .number(phone.getNumber())
                .build();
    }

    public List<PhoneDTO> convertToListPhoneDTO(List<Phone> phones) {
        return phones.stream().map(this::convertToPhoneDTO).toList();
    }

    //Update methods

    public Customer updateCustomer(CustomerDTO customerDTO, Customer customer) {
        return Customer.builder()
                .name(customerDTO.getName() != null ? customerDTO.getName() : customer.getName())
                .email(customerDTO.getEmail() != null ? customerDTO.getEmail() : customer.getEmail())
                .password(customerDTO.getPassword() != null ? customerDTO.getPassword() : customer.getPassword())
                .phones(customer.getPhones())
                .residences(customer.getResidences())
                .id(customer.getId())
                .build();
    }

    public Residence updateResidence(ResidenceDTO residenceDTO, Residence residence) {
        return Residence.builder()
                .street(residenceDTO.getStreet() != null ? residenceDTO.getStreet() : residence.getStreet())
                .city(residenceDTO.getCity() != null ? residenceDTO.getStreet() : residence.getCity())
                .state(residenceDTO.getState() != null ? residenceDTO.getState() : residence.getState())
                .zipCode(residenceDTO.getZipCode() != null ? residenceDTO.getZipCode() : residence.getZipCode())
                .id(residence.getId())
                .build();
    }

    public Phone updatePhone(PhoneDTO phoneDTO, Phone phone) {
        return Phone.builder()
                .number(phoneDTO.getNumber() != null ? phoneDTO.getNumber() : phone.getNumber())
                .id(phone.getId())
                .build();
    }

    //Adding

    public Residence addResidence(ResidenceDTO residenceDTO, Long customerID) {
        return Residence.builder()
                .street(residenceDTO.getStreet())
                .city(residenceDTO.getCity())
                .state(residenceDTO.getState())
                .zipCode(residenceDTO.getZipCode())
                .customer_id(customerID)
                .build();
    }

    public Phone addPhone(PhoneDTO phoneDTO, Long customerID) {
        return Phone.builder()
                .number(phoneDTO.getNumber())
                .customer_id(customerID)
                .build();
    }


}
