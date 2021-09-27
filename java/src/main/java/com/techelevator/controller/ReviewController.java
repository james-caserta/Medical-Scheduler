package com.techelevator.controller;

import com.techelevator.dao.DoctorResponseDao;
import com.techelevator.dao.ReviewsDao;
import com.techelevator.model.DoctorResponse;
import com.techelevator.model.Reviews;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class ReviewController {

    private ReviewsDao reviewsDao;
    private DoctorResponseDao doctorResponseDao;
    public ReviewController(ReviewsDao reviewsDao, DoctorResponseDao doctorResponseDao) {
        this.reviewsDao = reviewsDao;
        this.doctorResponseDao = doctorResponseDao;

    }

// get all reviews
    @RequestMapping(path = "/review", method = RequestMethod.GET)
    public List<Reviews> findAllReviews(){
        return reviewsDao.findAllReviews();
    }

//get review
    @RequestMapping(path = "/review/{id}", method = RequestMethod.GET)
    public Reviews get(@PathVariable long patientReviewId) {
    return reviewsDao.getReviews(patientReviewId);
}


// create review
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping( path = "/addReview/{id}", method = RequestMethod.POST)
    public Reviews addReview(@RequestBody Reviews reviews, @PathVariable("id") long patientReviewId) {
        return reviewsDao.createReview(reviews);
    }

// Doctor response to review based on review_id
    @RequestMapping(path = "/doctorResponse/{id}", method = RequestMethod.GET)
    public DoctorResponse getDoctorReview(@PathVariable long doctorResponseId){
        return doctorResponseDao.getDoctorResponse(doctorResponseId);
    }

    // Connect the doctorResponse to patient review??

}
