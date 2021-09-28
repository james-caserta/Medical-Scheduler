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
<<<<<<< HEAD

  getAllOffices(){
      return axios.get('/getAllOffices')
    },

  getDoctorsByOfficeId(office_id){
      return axios.get('/getDoctorsByOfficeId',office_id)
    },

  getOfficeByDoctorId(doctor_id){
      return axios.get('/getOfficeByDoctorId',doctor_id)
    },  
=======

  getDoctorByID(doctor_id){
      return axios.get('/doctor/', { params: { id: doctor_id } })
    },
>>>>>>> eb84045f71ac8a7a926d834c0c61ca56e971bdb1

  getOfficeByID(office_id){
      return axios.get('/office', office_id)
    },


}