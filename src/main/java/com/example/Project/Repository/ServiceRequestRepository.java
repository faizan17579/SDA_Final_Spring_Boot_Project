package com.example.Project.Repository;

import com.example.Project.Beans.ServiceRequest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRequestRepository extends JpaRepository<ServiceRequest,Long> {
	List<ServiceRequest> findByServiceProviderId(Long id);

	List<ServiceRequest> findByUserId(Long id);

	
	
}
