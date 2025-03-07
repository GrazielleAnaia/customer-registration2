package com.grazielleanaia.customer_registration2.infrastructure.repository;

import com.grazielleanaia.customer_registration2.infrastructure.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);

    boolean existsByEmail(String email);

    @Transactional
    void deleteByEmail(String email);

}
