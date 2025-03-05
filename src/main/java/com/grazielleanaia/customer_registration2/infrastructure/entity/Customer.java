package com.grazielleanaia.customer_registration2.infrastructure.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "customer")
@Builder

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Customer implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")

    List<Residence> residences;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    List<Phone> phones;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;
    }

//    public Customer(Long id, String name, String email, String password, List<Residence> residences, List<Phone> phones) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.password = password;
//        this.residences = residences;
//        this.phones = phones;
//    }
//
//    public Customer() {
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
//    public List<Residence> getResidences() {
//        return residences;
//    }
//
//    public void setResidences(List<Residence> residences) {
//        this.residences = residences;
//    }
//
//    public List<Phone> getPhones() {
//        return phones;
//    }
//
//    public void setPhones(List<Phone> phones) {
//        this.phones = phones;
//    }
}
