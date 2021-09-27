package com.techelevator.controller;

import com.techelevator.dao.DoctorResponseDao;
import com.techelevator.dao.ReviewsDao;
import com.techelevator.model.DoctorResponse;
import com.techelevator.model.Reviews;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
// @RequestMapping("review")
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
    return reviewsDao.getReview(patientReviewId);
}

    // create review
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping( path = "/addReview", method = RequestMethod.POST)
    public Reviews addReview(@RequestBody Reviews reviews) {
        return reviewsDao.createReview(reviews);
    }

    // Doctor response to review based on review_id
    @RequestMapping(path = "/doctorResponse/{id}", method = RequestMethod.GET)
    public DoctorResponse getDoctorReview(@PathVariable long doctorResponseId){
        return doctorResponseDao.getDoctorResponse(doctorResponseId);
    }

    // Connect the doctorResponse to patient review??


// update review
//    @RequestMapping(path = "/review/{id}", method = RequestMethod.PUT)
//    public void update(@Valid @RequestBody Reviews reviews, @PathVariable long patientReviewId) {
//       return reviewsDao.updateReview(reviews, patientReviewId);
//    }



}
