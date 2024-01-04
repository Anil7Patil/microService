package com.micro.AdministratorService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micro.AdministratorService.model.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    // Additional custom queries can be added here if needed
}