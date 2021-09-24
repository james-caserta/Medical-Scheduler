package com.techelevator.controller;

import com.techelevator.dao.ReviewsDao;
import com.techelevator.model.Reviews;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
// @RequestMapping("review")
public class ReviewController {

    private ReviewsDao reviewsDao;

    public ReviewController(ReviewsDao reviewsDao) {
        this.reviewsDao = reviewsDao;
    }

// get all reviews
    @RequestMapping(path = "/review", method = RequestMethod.GET)
    public List<Reviews> findALlReviews(){
        return reviewsDao.findAllReviews();
    }

//get review
    @RequestMapping(path = "/review/{id}", method = RequestMethod.GET)
    public Reviews get(@PathVariable long patientReviewId) {
    return reviewsDao.getReviews(patientReviewId);
}


// create review
    @RequestMapping( path = "/review/{id}", method = RequestMethod.POST)
    public Reviews addReview(@RequestBody Reviews reviews, @PathVariable("id") long patientReviewId) {
        return reviewsDao.createReview(reviews);
    }

// update review
    @RequestMapping(path = "/review/{id}", method = RequestMethod.PUT)
    public void update(@Valid @RequestBody Reviews reviews, @PathVariable long patientReviewId) {
     //   return reviewsDao.updateReview(reviews, patientReviewId);
    }

//delete review
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/review/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long patientReviewId) {
        reviewsDao.deleteReview(patientReviewId);
    }





}
