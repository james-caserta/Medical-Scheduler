<template>
  <div class="container-doctor-bio">
      <span id="doctorbio">{{doctor.summary}}</span>
  </div>
</template>

<script>
import apiservice from '../services/ApiService.js'

export default {
  name: 'doctorbio',

  created(){
            apiservice.getDoctorByID().then(
                (response) => {
                    this.doctor = response.data
                }

            )
  },

  data(){
        return{
            doctor:{
              doctorId: '2',
              accountId: '',
              userType: '',
              summary: '',
            },

        }
    },


}
</script>

<style>

.container-doctor-bio {

  background-color: #F5F1F1;
  border-radius: 15px;
  font-family: 'Open Sans', sans-serif;
  font-weight: 800;
  width: 100%;
  height: 100%;
  padding: 0.5rem;
}

</style>