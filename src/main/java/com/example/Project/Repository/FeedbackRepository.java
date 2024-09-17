package com.example.Project.Repository;

import com.example.Project.Beans.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByUserId(Long userId);
    List<Feedback> findByServiceProviderId(Long serviceProviderId);
}
