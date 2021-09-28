<template>
  <div>
      <body>
          
        <div v-for='doctor in doctors' v-bind:key ='doctor' class="doctor-List"> 
           <!--have to modify SQL statement to get doctor on 
           server to grab doctor's user information
           {{doctor.firstName}}{{doctor.lastName}} etc.
           
           -->

        </div>
      </body>
  </div>
</template>

<script>
import apiservice from '../services/ApiService.js'

export default {
name: 'list-of-doctors',

        created(){
            apiservice.getAllDoctors().then(
                (response) => {
                    this.doctors = response.data
                }

            )
        },
        

    data(){
        return{
            doctors:[]
        }
    },

}
</script>

<style>

</style>