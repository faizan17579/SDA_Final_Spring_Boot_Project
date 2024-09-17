
package com.example.Project.Beans;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ServiceProvider {
    
    // Properties
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	

	private int age;
	private List<String> services;
	private String rating;
    private String details;
	private String name;
    private String email;
    private String contact;
    private String password;

    // Constructors
    public ServiceProvider() {
        // Default constructor
    }

    public ServiceProvider(long id, String name, int age, String details,  List<String> services, String rating, String email, String contact) 
    {
        this.id = id;
        this.details = details;
        this.services = services;
        this.age = age;
        this.rating = rating;
        this.email = email;
        this.contact = contact;
        this.name = name;
        this.password = password;
    }
    
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getServices() {
		return services;
	}

	public void setServices(List<String> services) {
		this.services = services;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

    // toString method
    @Override
    public String toString() {
        return "ServiceRequest{" +
                "id='" + id + '\'' +
                ", details='" + details + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", services=" + services +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
