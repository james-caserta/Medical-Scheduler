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

  getDoctorByID(doctorId){
      return axios.get('/doctor/' + doctorId)
    },
  
  getAppointmentById(appointmentId){
    return axios.get('/appointment/' + appointmentId)
  },
  getIsDoctor(){
    return axios.get('/isDoctor/')
  }

}