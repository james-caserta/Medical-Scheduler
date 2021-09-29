<template>
    <div id="doctorlist">

    <div v-for='doctor in doctors' v-bind:key ='doctor' class="doctor"> 
        
        {{ doctor.doctorId }}

    </div>

    </div>
</template>

<style scoped>

#doctorlist {

    display: flex;
    flex-direction: column;
}

.doctor {

    display: flex;
    flex-direction: column;
}

</style>

<script>
import apiservice from "../services/ApiService.js";

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