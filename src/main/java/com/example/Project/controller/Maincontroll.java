package com.example.Project.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.Project.Beans.Feedback;
import com.example.Project.Beans.ServiceProvider;
import com.example.Project.Beans.ServiceRequest;
import com.example.Project.Beans.User;
import com.example.Project.service.FeedbackService;
import com.example.Project.service.ServiceProviderService;
import com.example.Project.service.ServiceRequestService;
import com.example.Project.service.UserService;


@Controller
public class Maincontroll {
	@Autowired
	ServiceRequestService servicerequest;
	@Autowired
    private ServiceProviderService serviceProviderService;
	@Autowired
	private UserService userService;
	@Autowired
	private FeedbackService feedbackService;
	

	
	private long userid;
	private long providerid;
	String Glname;
	String GLdetails;
	String GLaddress;
	Date GLrequestDate;
	String GLstatus;
	String GLserviceType;
	
	
	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}

	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	@GetMapping("/serviceforsubmit")
	public String service() {
		return "service";
	}

	@GetMapping("/service")
	public String services() {
		return "ourservices";
	}
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	@GetMapping("/maintenance")
	public String maintenance() {
		return "servicepage";
	}
	@GetMapping("/electrical")
	public String repair() {
		return "electricalpage";
	}
	@GetMapping("/plumbing")
	public String plumbing() {
		return "plumberpage";
	}
	@GetMapping("/plumberrequest")
	public String plumberrequest() {
		return "plumberrequest";
	}
	@GetMapping("/electricalrequest")
	public String repairrequest() {
		return "electricalrequest";
	}
	@GetMapping("/repairrequest")
	public String maintenancerequest() {
		return "maintanrequest";
	}
	@GetMapping("/serviceproviderprofile")
	public String serviceproviderprofile(){
		return "ServiceProviderProfile";
	}
	@GetMapping("/submitfeedback")
	public String submitfeedback() {
		return "SubmitFeedback";
	}
    @PostMapping("/submitServiceRequest")
	  public ModelAndView submitMaintenanceServiceRequest(@RequestParam("name") String name,
              @RequestParam("details") String details,
              @RequestParam("address") String address,
              @RequestParam("requestDate") Date requestDate,
              @RequestParam("status") String status) {
User user = userService.getUserById(userid);
ServiceProvider serviceProvider = serviceProviderService.getServiceProviderById(providerid);
ServiceRequest serviceRequest = new ServiceRequest();
serviceRequest.setName(name);
serviceRequest.setDetails(details);
serviceRequest.setAddress(address);
serviceRequest.setServiceType("Maintenance");
serviceRequest.setRequestDate(requestDate);
serviceRequest.setStatus(status);
serviceRequest.setUser(user);
serviceRequest.setServiceProvider(serviceProvider);

// Save the service request using the autowired service
servicerequest.saveServiceRequest(serviceRequest);

ModelAndView modelAndView = new ModelAndView("serviceRequestDetails");

// Add the serviceRequest object to the model
modelAndView.addObject("serviceRequest", serviceRequest);

// Return the ModelAndView object
return modelAndView;

}
    @PostMapping("/submitServiceRequestelectrical")
	  public ModelAndView submitEectricalServiceRequest(@RequestParam("name") String name,
              @RequestParam("details") String details,
              @RequestParam("address") String address,
              @RequestParam("requestDate") Date requestDate,
              @RequestParam("status") String status) {
ServiceRequest serviceRequest = new ServiceRequest();
serviceRequest.setName(name);
serviceRequest.setDetails(details);
serviceRequest.setAddress(address);
serviceRequest.setServiceType("Electrical");
serviceRequest.setRequestDate(requestDate);
serviceRequest.setStatus(status);

// Save the service request using the autowired service
servicerequest.saveServiceRequest(serviceRequest);

ModelAndView modelAndView = new ModelAndView("serviceRequestDetails");

// Add the serviceRequest object to the model
modelAndView.addObject("serviceRequest", serviceRequest);

// Return the ModelAndView object
return modelAndView;
}
    @PostMapping("/submitServiceRequestplumber")
	  public ModelAndView submitplumberServiceRequest(@RequestParam("name") String name,
            @RequestParam("details") String details,
            @RequestParam("address") String address,
            @RequestParam("requestDate") Date requestDate,
            @RequestParam("status") String status) {
ServiceRequest serviceRequest = new ServiceRequest();
serviceRequest.setName(name);
serviceRequest.setDetails(details);
serviceRequest.setAddress(address);
serviceRequest.setServiceType("Plumber");
serviceRequest.setRequestDate(requestDate);
serviceRequest.setStatus(status);

//Save the service request using the autowired service
servicerequest.saveServiceRequest(serviceRequest);

ModelAndView modelAndView = new ModelAndView("serviceRequestDetails");

// Add the serviceRequest object to the model
modelAndView.addObject("serviceRequest", serviceRequest);

// Return the ModelAndView object
return modelAndView;
}
    @PostMapping("/submitServiceProviderRegistration")
    public String submitServiceProviderRegistration(@RequestParam("name") String name,
                                                           @RequestParam("age") int age,
                                                           @RequestParam("services") List<String> services,
                                                           @RequestParam("rating") String rating,
                                                           @RequestParam("email") String email,
                                                           @RequestParam("contact") String contact,
                                                           @RequestParam("details") String details,
                                                           @RequestParam("password") String password,Model model) {
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setName(name);
        serviceProvider.setAge(age);
        serviceProvider.setServices(services);
        serviceProvider.setRating(rating);
        serviceProvider.setEmail(email);
        serviceProvider.setContact(contact);
        serviceProvider.setPassword(password);
        serviceProvider.setDetails(details);
        
       
        // Save the service provider using the autowired service
        serviceProviderService.saveServiceProvider(serviceProvider);
        model.addAttribute("serviceProvider", serviceProvider);
        
       

           
        // Return the ModelAndView object
        return "profile";
    }
 
@GetMapping("/loginpage")
public String loginpage() {
	return "login";
		
}
@GetMapping("/signuppage")
public String signuppage() {
    return "register";
}
@GetMapping("/serviceprovider")
public String serviceprovider() {
    return "profile";
}
// Method to handle login request and display profile

@PostMapping("/login")
public String loginprovider(@ModelAttribute ServiceProvider provider, Model model) {
    List<ServiceProvider> serviceProviderList = serviceProviderService.getAllServiceProviders();
    for (ServiceProvider serviceProvider : serviceProviderList) {
        String email = serviceProvider.getEmail();
        String email2 = provider.getEmail();
        String pass = serviceProvider.getPassword();
        String pass2 = provider.getPassword();

        // Remove trailing comma if present
        if (email2.length() > 0 && email2.charAt(email2.length() - 1) == ',') {
            email2 = email2.substring(0, email2.length() - 1);
        }

        if (email.equals(email2) && pass.equals(pass2)) {
            // Add the service provider to the model
            providerid = serviceProvider.getId();
            System.out.println("providerid: " + providerid);

            model.addAttribute("serviceProvider", serviceProvider);
            return "profile"; // Return the profile view
        }
    }

    model.addAttribute("loginError", "Invalid email or password");
    return "login"; // Return the login view if no match is found
}

@PostMapping("/submitUserRegistration")
public 	String submitUserRegistration(@RequestParam("name") String name,
        @RequestParam("email") String email,
        @RequestParam("address") String address,@RequestParam("password") String password,Model model) {
	User user = new User();
	user.setName(name);
	user.setEmail(email);
	user.setAddress(address);
	user.setPassword(password);
	// Save the user using the autowired service
	userService.saveUser(user);
	model.addAttribute("user", user);
	return "userdone";
		
}
@GetMapping("/userregister")
public String userregister() {
    return "registeruser";
}
@PostMapping("/loginuser")
public String loginuser(@ModelAttribute User user, Model model) {
    List<User> userlist = userService.getAllUsers();
    for (User u : userlist) {
        String email = u.getEmail();
        String email2 = user.getEmail();
        String pass = u.getPassword();
        String pass2 = user.getPassword();

        // Remove trailing comma if present
        if (email2.length() > 0 && email2.charAt(email2.length() - 1) == ',') {
            email2 = email2.substring(0, email2.length() - 1);
        }

        if (email.equals(email2) && pass.equals(pass2)) {
            // Add the user to the model
            userid = u.getId();
            model.addAttribute("user", u);
            return "userpro"; // Return the profile view
        }
    }

    // Return the login view if no match is found
    model.addAttribute("loginError", "Invalid email or password");
    return "login";
}
@PostMapping("/allprovider")
public String allprovider(@RequestParam("name") String name,
        @RequestParam("details") String details,
        @RequestParam("address") String address,
        @RequestParam("requestDate") Date requestDate,
        @RequestParam("status") String status,@RequestParam("serviceType") String type, Model model) {
	Glname = name;
	GLdetails = details;
	GLaddress = address;
	GLrequestDate = requestDate;
	GLstatus = status;
	GLserviceType = type;
	
	  List<ServiceProvider> serviceProviderList = serviceProviderService.getAllServiceProviders();
	   
	    model.addAttribute("serviceProviderList", serviceProviderList);
	    return "allprovider";


}
@GetMapping("/providerDetails")
public String providerDetails(@RequestParam("id") Long id, Model model) {
    ServiceProvider serviceProvider = serviceProviderService.getServiceProviderById(id);
    providerid = serviceProvider.getId();
    System.out.println("providerid: " + providerid);
    
    // Add the serviceProvider object to the model
    model.addAttribute("serviceProvider", serviceProvider);
    
    // Return the view name for the confirmation page
    return "confirmRequest";
}

@PostMapping("/submitRequestplumbing")
public ModelAndView submitRequestplumbing() {
ServiceRequest serviceRequest = new ServiceRequest();
serviceRequest.setName(Glname);
serviceRequest.setDetails(GLdetails);
serviceRequest.setAddress(GLaddress);
serviceRequest.setServiceType(GLserviceType);
serviceRequest.setRequestDate(GLrequestDate);
serviceRequest.setStatus(GLstatus);
serviceRequest.setServiceType(GLserviceType);
serviceRequest.setUser(userService.getUserById(userid));


serviceRequest.setUser(userService.getUserById(userid));
serviceRequest.setServiceProvider(serviceProviderService.getServiceProviderById(providerid));
servicerequest.saveServiceRequest(serviceRequest);
ModelAndView modelAndView = new ModelAndView("serviceRequestDetails");

//Add the serviceRequest object to the model
modelAndView.addObject("serviceRequest", serviceRequest);

//Return the ModelAndView object
return modelAndView;

  
}
@RequestMapping(value = { "/allRequestsPage", "/allRequestsPage/{providerId}" }, method = { RequestMethod.GET, RequestMethod.POST })
public String allRequestsPage(Model model) {
    // Assuming you have a global variable named providerId
    List<ServiceRequest> serviceRequestList = servicerequest.getServiceRequestByServiceProviderId(providerid);
    model.addAttribute("serviceRequestList", serviceRequestList);
    return "allRequests";
}


@PostMapping("/completeRequest/{id}")
public String completeRequest(@PathVariable Long id, Model model) {
    ServiceRequest serviceRequest = servicerequest.getServiceRequestById(id);
    if (serviceRequest != null) {
        serviceRequest.setStatus("Completed");
        servicerequest.saveServiceRequest(serviceRequest);
    }
    
    List<ServiceRequest> serviceRequestList = servicerequest.getAllServiceRequests();
    model.addAttribute("serviceRequestList", serviceRequestList);
    
    return "Completestatus"; // Redirect back to the all requests page
}

@RequestMapping(value = { "/viewAllRequests", "/viewAllRequests/{userid}" }, method = { RequestMethod.GET, RequestMethod.POST })
public String alluserRequestsPage(Model model) {
    // Assuming you have a global variable named providerId
	    List<ServiceRequest> serviceRequestList = servicerequest.findByUserId(userid);
	        model.addAttribute("serviceRequestList", serviceRequestList);
	        return "alluserrequest";
}
@GetMapping("/allproviderforuser")
public String allproviderforuser(Model model) {   
      List<ServiceProvider> serviceProviderList = serviceProviderService.getAllServiceProviders();
       
        model.addAttribute("serviceProviderList", serviceProviderList);
        return "allproviderforuser";
}

@GetMapping("/Givefeedback")
public String selectProvider(@RequestParam("id") Long id, Model model) {
	providerid = id;
  ServiceProvider serviceProvider = serviceProviderService.getServiceProviderById(id);
  model.addAttribute("serviceProvider", serviceProvider);
  
	
    
  return "feedback";
}



@PostMapping("/submitFeedback")

public String submitFeedback(@RequestParam("providerId") Long providerId,
                             @RequestParam("comments") String comments,
                             @RequestParam("rating") int rating) {
    ServiceProvider serviceProvider = serviceProviderService.getServiceProviderById(providerId);
    User user = userService.getUserById(userid);
    Feedback feedback = new Feedback(user, serviceProvider, comments, rating);
    feedbackService.saveFeedback(feedback);
    return "feedbackdone";
}
@GetMapping("/viewYourFeedback")
public String viewFeedback(Model model) {
	
	List<Feedback> feedbackList = feedbackService.getFeedbackByUserId(userid);
	model.addAttribute("feedbackList", feedbackList);
	return "viewfeedback";
}
@GetMapping("/feedbacks")
public String feedbacks(Model model) {
    List<Feedback> feedbackList = feedbackService.getAllFeedback();
    model.addAttribute("feedbackList", feedbackList);
    return "feedbacks";
   
} 
@GetMapping("/payment")
public String showPaymentMethods(@RequestParam("requestId") Long requestId) {
    // Logic to fetch service request details and proceed to payment
    // You can pass the service request ID to the payment page
    return "payment";
}
@GetMapping("/pay")
public String pay(Model model) {
	// Logic to fetch service request details and proceed to payment
	
	ServiceRequest serviceRequest = new ServiceRequest();
	serviceRequest.setStatus(GLstatus);
	serviceRequest.setServiceType(GLserviceType);
	serviceRequest.setAddress(GLaddress);
	serviceRequest.setDetails(GLdetails);
	serviceRequest.setName(Glname);
	serviceRequest.setRequestDate(GLrequestDate);
	serviceRequest.setUser(userService.getUserById(userid));
double price = calculatePrice(serviceRequest.getServiceType());
    
    // Add service request details and price to the model
    model.addAttribute("serviceRequest", serviceRequest);
    model.addAttribute("price", price);
	return "Reciept";
	
	
}
private double calculatePrice(String serviceType) {
    // Implement logic to determine price based on service type
    // This is just a placeholder, replace it with your actual logic
    if ("Electrical".equals(serviceType)) {
        return 100.0; // Example price for ServiceTypeA
    } else if ("Plumbing".equals(serviceType)) {
        return 150.0; // Example price for ServiceTypeB
    } else if("Maintenance".equals(serviceType)) {
        return 200.0; // Example price for ServiceTypeC
    }
    else {
        return 0.0;
    }
}
}


    

