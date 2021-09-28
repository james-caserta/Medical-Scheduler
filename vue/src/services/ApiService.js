import axios from 'axios';

export default {

  getAllReviews() {
      return axios.get('/review')
    },

    
<<<<<<< HEAD
  addReview(UserReview){
      return axios.post('/addReview', UserReview)
    },

  getAllDoctors() {
      return axios.get('/allDoctors')
    },
=======
    addReview(UserReview){
        return axios.post('/addReview', UserReview)
      },

    getAllDoctors(){
      return axios.get('/allDoctors')
    }
>>>>>>> ac5be98a75c803494adb909dd79ee64311fc6611




}