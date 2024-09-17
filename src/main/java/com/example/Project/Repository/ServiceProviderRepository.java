package com.example.Project.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Project.Beans.ServiceProvider;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {

    // Method to find a ServiceProvider by email
    Optional<ServiceProvider> findByEmail(String email);

    // Other existing methods...

}
