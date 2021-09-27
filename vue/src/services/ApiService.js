import axios from 'axios';

export default {

    getAllReviews() {
        return axios.get('/review')
      },

    
    addReview(UserReview){
        return axios.post('/addReview', UserReview)
      }




}