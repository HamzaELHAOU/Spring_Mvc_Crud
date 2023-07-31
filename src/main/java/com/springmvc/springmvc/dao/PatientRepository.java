package com.springmvc.springmvc.dao;

import com.springmvc.springmvc.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    public Page<Patient> findAllByNameContains(String mc, Pageable pageable);

}
