package com.grazielleanaia.customer_registration2.infrastructure.repository;

import com.grazielleanaia.customer_registration2.infrastructure.entity.Residence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ResidenceRepository extends JpaRepository<Residence, Long> {
}
