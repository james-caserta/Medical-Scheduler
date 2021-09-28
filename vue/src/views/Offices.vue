<template>
    <div>
        <p>List of Doctors</p>
        <ListOfOffices/>
        <ListOfDoctors/>
    </div>
</template>

<script>
import ListOfDoctors from '../components/ListOfDoctors.vue'
import ListOfOffices from '../components/Offices.vue'

export default {
    name:{

    },
    components: {
        ListOfDoctors,
        ListOfOffices
      
    }


}
</script>

<style>


</style>