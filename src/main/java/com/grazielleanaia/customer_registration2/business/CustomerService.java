package com.grazielleanaia.customer_registration2.business;


import com.grazielleanaia.customer_registration2.business.converter.CustomerConverter;
import com.grazielleanaia.customer_registration2.business.dto.CustomerDTO;
import com.grazielleanaia.customer_registration2.business.dto.PhoneDTO;
import com.grazielleanaia.customer_registration2.business.dto.ResidenceDTO;
import com.grazielleanaia.customer_registration2.infrastructure.entity.Customer;
import com.grazielleanaia.customer_registration2.infrastructure.entity.Phone;
import com.grazielleanaia.customer_registration2.infrastructure.entity.Residence;
import com.grazielleanaia.customer_registration2.infrastructure.exception.ConflictException;
import com.grazielleanaia.customer_registration2.infrastructure.exception.ResourceNotFoundException;
import com.grazielleanaia.customer_registration2.infrastructure.repository.CustomerRepository;
import com.grazielleanaia.customer_registration2.infrastructure.repository.PhoneRepository;
import com.grazielleanaia.customer_registration2.infrastructure.repository.ResidenceRepository;
import com.grazielleanaia.customer_registration2.infrastructure.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerConverter converter;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final ResidenceRepository residenceRepository;
    private final PhoneRepository phoneRepository;

    public CustomerService(CustomerRepository repository, CustomerConverter converter,
                           PasswordEncoder passwordEncoder, JwtUtil jwtUtil, ResidenceRepository residenceRepository,
                           PhoneRepository phoneRepository) {
        this.repository = repository;
        this.converter = converter;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.residenceRepository = residenceRepository;
        this.phoneRepository = phoneRepository;
    }

    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        emailExist(customerDTO.getEmail());
        customerDTO.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
        Customer customer = converter.convertToCustomer(customerDTO);
        return converter.convertToCustomerDTO(repository.save(customer));
    }

    public void emailExist(String email) {
        try {
            boolean exist = verifyEmail(email);
            if (exist) {
                throw new ConflictException("Email already registered.");
            }
        } catch (ConflictException e) {
            throw new ConflictException("Email already found.", e.getCause());
        }
    }

    boolean verifyEmail(String email) {
        return repository.existsByEmail(email);
    }

    public CustomerDTO findCustomerByEmail(String email) {
        Customer customer = repository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException(
                "Email not found." + email));
        return converter.convertToCustomerDTO(customer);
    }

    public void deleteCustomerByEmail(String email) {
        repository.deleteByEmail(email);
    }

    public CustomerDTO updateCustomer(CustomerDTO customerDTO, String token) {
        String email = jwtUtil.extractUsername(token.substring(7));
        Customer customer = repository.findByEmail(email).orElseThrow(() ->
                new ResourceNotFoundException("Email not found."));
        Customer customer1 = converter.updateCustomer(customerDTO, customer);
        return converter.convertToCustomerDTO(repository.save(customer1));
    }

    public ResidenceDTO updateResidence(ResidenceDTO residenceDTO, Long id) {
        Residence residence = residenceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Id not found."));
        Residence residence1 = converter.updateResidence(residenceDTO, residence);
        return converter.convertToResidenceDTO(residenceRepository.save(residence1));
    }

    public PhoneDTO updatePhone(PhoneDTO phoneDTO, Long id) {
      Phone phone = phoneRepository.findById(id).orElseThrow(() ->
              new ResourceNotFoundException("Id not found."));
      Phone phone1 = converter.updatePhone(phoneDTO, phone);
      return converter.convertToPhoneDTO(phoneRepository.save(phone1));
    }

    public ResidenceDTO addResidence(ResidenceDTO residenceDTO, String token) {
        String email = jwtUtil.extractUsername(token.substring(7));
        Customer customer = repository.findByEmail(email).orElseThrow(() ->
                new ResourceNotFoundException("Email not found."));
        Residence residence = converter.addResidence(residenceDTO, customer.getId());
        Residence residence1 = residenceRepository.save(residence);
        return converter.convertToResidenceDTO(residence1);
    }

    public PhoneDTO addPhone(PhoneDTO phoneDTO, String token) {
        String email = jwtUtil.extractUsername(token.substring(7));
        Customer customer = repository.findByEmail(email).orElseThrow(() ->
                new ResourceNotFoundException("Email not found." + email));
        Phone phone = converter.addPhone(phoneDTO, customer.getId());
        return converter.convertToPhoneDTO(phoneRepository.save(phone));
    }



}
