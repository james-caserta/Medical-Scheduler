<template>
    <div>
        <p>List of Doctors</p>
        <Offices/>
        <ListOfDoctors/>
    </div>
</template>

<script>
import ListOfDoctors from '../components/ListOfDoctors.vue'
import Offices from '../components/Offices.vue'

export default {
    name:{

    },
    components: {
        ListOfDoctors,
        Offices
      
    }


}
</script>

<style>


</style>