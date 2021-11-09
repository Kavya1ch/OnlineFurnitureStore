package com.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Review;
import com.exception.CustomerFeedbackException;
import com.service.IFeedbackService;


@RestController
@RequestMapping("api/showReview")
public class FeedbackController {

	@Autowired
	IFeedbackService feedbackService;

	
	@PostMapping("/addReview")
	public ResponseEntity<Review> addReview(@RequestBody Review review) throws CustomerFeedbackException {
		Review newVal = feedbackService.addReview(review);
		return new ResponseEntity<Review>(newVal, HttpStatus.OK);

	}

	
	

	@PutMapping("/updateReview/{feedBackId}")
	public ResponseEntity<Review> updateFeedBack(@RequestBody Review review) throws CustomerFeedbackException {
		Review newVal = feedbackService.updateReview(review.getFeedBackId(), review);
		return new ResponseEntity<Review>(newVal, HttpStatus.OK);

	}

	
	
	@GetMapping("/reviews/{feedBackId}")
	public ResponseEntity<Review> viewReview(@PathVariable("feedBackId") int feedBackId) throws CustomerFeedbackException {
		Review resultReview = feedbackService.viewReview(feedBackId);
		return new ResponseEntity<Review>(resultReview, HttpStatus.OK);

	}

	
	@GetMapping("/feedbacks")
	public ResponseEntity<List<Review>> viewAllReview() throws CustomerFeedbackException {
		List<Review> firstFeedBack = feedbackService.viewAllReview();
		return new ResponseEntity<List<Review>>(firstFeedBack, HttpStatus.OK);
	}
	
	
}
