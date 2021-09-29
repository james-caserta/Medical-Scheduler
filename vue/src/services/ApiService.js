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

  getAllOffices(){
      return axios.get('/getAllOffices')
    },

  getDoctorsByOfficeId(office_id){
      return axios.get('/getDoctorsByOfficeId',office_id)
    },

  getOfficeByDoctorId(doctor_id){
      return axios.get('/getOfficeByDoctorId',doctor_id)
    },  

  getOfficeByID(office_id){
      return axios.get('/office', office_id)
    },


}