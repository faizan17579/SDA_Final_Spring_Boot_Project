package com.example.Project.service;
import com.example.Project.Beans.*;
import com.example.Project.Repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<Feedback> getFeedbackByUserId(Long userId) {
        return feedbackRepository.findByUserId(userId);
    }

    public List<Feedback> getFeedbackByServiceProviderId(Long serviceProviderId) {
        return feedbackRepository.findByServiceProviderId(serviceProviderId);
    }

    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

	public List<Feedback> getAllFeedback() {
		return feedbackRepository.findAll();
	}

	
}