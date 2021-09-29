<template>
 <div id="officeContent">
 
    <span class="officeListTitle">Offices</span>

        <div id="officeLoop" v-for='office in offices' v-bind:key ='office' class="office"> 
        
         {{office.street_address}} {{office.city}} {{office.state}} {{office.zip}}

        </div>

    </div>
</template>

<script>
import apiservice from '../services/ApiService.js'

export default {
    name: 'list-of-offices',

        created(){
            apiservice.getAllOffices().then(
                (response) => {
                    this.offices = response.data
                }

            )
        },

}
</script>

<style>

</style>