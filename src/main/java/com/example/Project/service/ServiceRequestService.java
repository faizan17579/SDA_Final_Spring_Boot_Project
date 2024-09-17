package com.example.Project.service;

import com.example.Project.Beans.ServiceRequest;
import com.example.Project.Repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRequestService {
	   @Autowired
    ServiceRequestRepository serviceRequestRepository;

 
   

    // Method to save a service request
    public ServiceRequest saveServiceRequest(ServiceRequest serviceRequest) {
        return serviceRequestRepository.save(serviceRequest);
    }

    // Method to retrieve all service requests
    public List<ServiceRequest> getAllServiceRequests() {
        return serviceRequestRepository.findAll();
    }

    // Method to retrieve a service request by its ID
    public ServiceRequest getServiceRequestById(Long id) {
        return serviceRequestRepository.findById(id).orElse(null);
    }

    // Method to update a service request
    public ServiceRequest updateServiceRequest(ServiceRequest serviceRequest) {
        return serviceRequestRepository.save(serviceRequest);
    }

    // Method to delete a service request by its ID
    public void deleteServiceRequest(Long id) {
        serviceRequestRepository.deleteById(id);
    }

	public List<ServiceRequest> getServiceRequestByServiceProviderId(Long id) {
		return serviceRequestRepository.findByServiceProviderId(id);
	}

	
	public List<ServiceRequest> getServiceRequestByServiceProviderId1(Long providerId) {
	    return serviceRequestRepository.findByServiceProviderId(providerId);
	}

	public List<ServiceRequest> findByUserId(Long id) {
		return serviceRequestRepository.findByUserId(id);
	}
}
