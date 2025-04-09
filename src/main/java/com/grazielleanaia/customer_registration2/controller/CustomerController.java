package com.grazielleanaia.customer_registration2.controller;


import com.grazielleanaia.customer_registration2.business.CustomerService;
import com.grazielleanaia.customer_registration2.business.dto.CustomerDTO;
import com.grazielleanaia.customer_registration2.business.dto.PhoneDTO;
import com.grazielleanaia.customer_registration2.business.dto.ResidenceDTO;
import com.grazielleanaia.customer_registration2.infrastructure.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")

public class CustomerController {
    private final CustomerService service;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public CustomerController(CustomerService service, AuthenticationManager authenticationManager,
                              JwtUtil jwtUtil) {
        this.service = service;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(service.saveCustomer(customerDTO));
    }

    @PostMapping("/login")
    public String customerLogin(@RequestBody CustomerDTO customerDTO) {
        Authentication authentication = authenticationManager.authenticate(new
                UsernamePasswordAuthenticationToken(customerDTO.getEmail(), customerDTO.getPassword()));
        return "Bearer " + jwtUtil.generateToken(authentication.getName());
    }

    @GetMapping
    public ResponseEntity<CustomerDTO> findCustomerByEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(service.findCustomerByEmail(email));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteCustomerByEmail(@PathVariable String email) {
        service.deleteCustomerByEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<CustomerDTO> updateCustomerData(@RequestBody CustomerDTO customerDTO,
                                                          @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(service.updateCustomer(customerDTO, token));
    }

    @PutMapping("/residence")
    public ResponseEntity<ResidenceDTO> updateResidence(@RequestBody ResidenceDTO residenceDTO,
                                                        @RequestParam("id") Long id) {
        return ResponseEntity.ok(service.updateResidence(residenceDTO, id));
    }

    @PutMapping("/phone")
    public ResponseEntity<PhoneDTO> updatePhone(@RequestBody PhoneDTO phoneDTO,
                                                @RequestParam("id") Long id) {
        return ResponseEntity.ok(service.updatePhone(phoneDTO, id));
    }

    @PostMapping("/residence")
    public ResponseEntity<ResidenceDTO> addResidence(@RequestBody ResidenceDTO residenceDTO,
                                                     @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(service.addResidence(residenceDTO, token));
    }

    @PostMapping("/phone")
    public ResponseEntity<PhoneDTO> addPhone(@RequestBody PhoneDTO phoneDTO,
                                             @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(service.addPhone(phoneDTO, token));
    }



}
