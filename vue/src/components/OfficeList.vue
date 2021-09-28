<template>
    <div id="officelist">

    <div v-for='office in offices' v-bind:key ='office' class="office"> 
        
        {{ office.doctorId }}

    </div>

    </div>
</template>

<style scoped>

</style>

<script>
import apiservice from "../services/ApiService.js";

export default {
    name: 'list-of-offices',
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