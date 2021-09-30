import axios from 'axios';

export default {

  getAllReviews() {
      return axios.get('/review')
    },

  addReview(userReview){
        return axios.post('/addReview', userReview)
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

  getOfficeByDoctorId(doctorId){
      return axios.get('/getOfficeByDoctorId/'+ doctorId)
    },  

  getOfficeByID(office_id){
      return axios.get('/office/'+ office_id)
    },

  updateOfficeInfoByDoctorId(doctor_id,office){
    return axios.put('/updateDoctorOfficeInfo/'+ doctor_id, office)
  },

  getDoctorByID(doctorId){
      return axios.get('/doctor/' + doctorId)
    },
  
  getAppointmentById(appointmentId){
    return axios.get('/appointment/' + appointmentId)
  },
  
  getIsDoctor(){
    return axios.get('/isDoctor/')
  },


}