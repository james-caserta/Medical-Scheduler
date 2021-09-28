import axios from 'axios';

export default {

  getAllReviews() {
      return axios.get('/review')
    },

  addReview(UserReview){
        return axios.post('/addReview', UserReview)
    },

  getAllDoctors(){
      return axios.get('/allDoctors')
    },

  getDoctorByID(doctor_id){
      return axios.get('/doctor', doctor_id)
    },

  getOfficeByID(office_id){
      return axios.get('/office', office_id)
    },


}