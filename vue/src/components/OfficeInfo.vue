<template>
  <div class="container-office-info">
      <span>Office Information</span>
    <p>Address: {{office.streetAddress}}, {{office.city}}, {{office.state}} {{office.zip}}</p>
   <p>Phone: +1({{office.phoneNumber}} </p>
   <p>Office Hours: Monday-Friday 9am-5pm</p>
   <p class="covid">COVID-19 Testing Center</p>
  </div>
</template>

<script>
import apiservice from '../services/ApiService.js'
export default {

     data(){
        return{
            doctorId: 2,
            office: [],
        }
    },

  created(){
            apiservice.getOfficeByDoctorId(this.doctorId).then(
                (response) => {
                  this.office = response.data
                }
              )
        },
        
  
}
</script>

<style scoped>

.container-office-info {

  background-color: #F5F1F1;
  border-radius: 15px;
  font-family: 'Open Sans', sans-serif;
  font-weight: 800;
  width: 100%;
  height: 100%;
  padding: 0.5rem;
}

.covid{
  color: red;
}


</style>