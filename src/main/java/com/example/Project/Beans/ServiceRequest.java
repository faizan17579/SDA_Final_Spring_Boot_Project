package com.example.Project.Beans;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class ServiceRequest {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String details;
    private String address;
    private String serviceType;
   
    private Date requestDate;
    private String status;
    private String name;

    @ManyToOne
    @JoinColumn(name = "service_provider_id")
    private ServiceProvider serviceProvider;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Constructors
    public ServiceRequest() {
        // Default constructor
    }

    public ServiceRequest(long id, String details, String address, String serviceType, Date requestDate, String status, String name, ServiceProvider serviceProvider, User user) {
        this.id = id;
        this.details = details;
        this.address = address;
        this.serviceType = serviceType;
        this.requestDate = requestDate;
        this.status = status;
        this.name = name;
        this.serviceProvider = serviceProvider;
        this.user = user;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // toString method
    @Override
    public String toString() {
        return "ServiceRequest{" +
                "id=" + id +
                ", details='" + details + '\'' +
                ", address='" + address + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", requestDate=" + requestDate +
                ", status='" + status + '\'' +
                ", name='" + name + '\'' +
                ", serviceProvider=" + serviceProvider +
                ", user=" + user +
                '}';
    }
}
