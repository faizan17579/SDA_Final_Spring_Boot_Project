package com.example.Project.service;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Project.Beans.ServiceProvider;
import com.example.Project.Repository.ServiceProviderRepository;

@Service
public class ServiceProviderService {

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    // Method to get a ServiceProvider by email
    public ServiceProvider getServiceProviderByEmail(String email) {
        return serviceProviderRepository.findByEmail(email).orElse(null);
    }
    

    // Method to get all ServiceProviders
    public List<ServiceProvider> getAllServiceProviders() {
        return serviceProviderRepository.findAll();
    }

    // Method to get a ServiceProvider by id
    public ServiceProvider getServiceProviderById(Long id) {
        return serviceProviderRepository.findById(id).orElse(null);
    }

    // Method to save or update a ServiceProvider
    public ServiceProvider saveOrUpdateServiceProvider(ServiceProvider serviceProvider) {
        return serviceProviderRepository.save(serviceProvider);
    }
    public ServiceProvider saveServiceProvider(ServiceProvider serviceProvider) {
        return serviceProviderRepository.save(serviceProvider);
    }
    

    // Method to delete a ServiceProvider by id
    public void deleteServiceProvider(Long id) {
        serviceProviderRepository.deleteById(id);
    }

    // Method to update a ServiceProvider's profile
    public ServiceProvider updateServiceProvider(Long id, ServiceProvider updatedServiceProvider) {
        java.util.Optional<ServiceProvider> optionalServiceProvider = serviceProviderRepository.findById(id);
        if (optionalServiceProvider.isPresent()) {
            ServiceProvider existingServiceProvider = optionalServiceProvider.get();
            existingServiceProvider.setName(updatedServiceProvider.getName());
            existingServiceProvider.setAge(updatedServiceProvider.getAge());
            existingServiceProvider.setDetails(updatedServiceProvider.getDetails());
            existingServiceProvider.setServices(updatedServiceProvider.getServices());
            existingServiceProvider.setRating(updatedServiceProvider.getRating());
            existingServiceProvider.setEmail(updatedServiceProvider.getEmail());
            existingServiceProvider.setContact(updatedServiceProvider.getContact());
            // Add other fields as necessary
            return serviceProviderRepository.save(existingServiceProvider);
        } else {
            return null;
        }
    }

 

}
