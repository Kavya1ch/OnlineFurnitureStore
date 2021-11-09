package com.service;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.entity.Review;
import com.exception.CustomerFeedbackException;
import com.repository.IFeedbackRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class FeedbackService implements IFeedbackService {

	
	@Autowired
	private IFeedbackRepository feedbackRepository;

	
	@Transactional
	@Override
	public Review addReview(Review review) throws CustomerFeedbackException {
		
		Review addReview = feedbackRepository.save(review);
		
		return addReview;
	}

	
	@Transactional(readOnly = true)
	@Override
	public Review updateReview(int feedBackId, Review review) throws CustomerFeedbackException {
		Review updReview;
		Review resultReview = feedbackRepository.findById(review.getFeedBackId()).orElse(null);
		try {
			
			if (resultReview!=null) {
				updReview = feedbackRepository.save(review);
			
			} else {
				throw new CustomerFeedbackException("Id no found");
			}
		} catch (Exception e) {
			throw new CustomerFeedbackException("id not found");
		}
		return updReview;
	}

	
	@Transactional
	@Override
	public Review viewReview(int feedBackId) throws CustomerFeedbackException {

		Review getReview;
		try {
			
			getReview = feedbackRepository.findById(feedBackId).orElse(null);
			if (getReview.getFeedBackId() == feedBackId) {
				getReview = feedbackRepository.findById(feedBackId).orElse(null);
				
			} else {
				throw new CustomerFeedbackException("Id is not found");
			}
		} catch (Exception e) {
			throw new CustomerFeedbackException("Id is not found");
		}
		return getReview;
	}

	
	@Transactional
	@Override
	public List<Review> viewAllReview() throws CustomerFeedbackException {
		List<Review> getReview;
		try {
			
			getReview = feedbackRepository.findAll();
			if (!getReview.isEmpty()) {
				
				return getReview;
			} else {
				throw new CustomerFeedbackException("There is no values in thre review");
			}
		} catch (Exception e) {
			throw new CustomerFeedbackException("There is no value in the review");
		}
	}
	
	

}

