<template>
  <div class="splash">
    <!-- <h1 style="color:#07329E" id="title1">DrSched</h1>
    <h2 style="color:#07329E" id="title2">We make booking with your doctor easy.</h2>
    <p style="color:#07329E" id="title3">Find your doctor and book today.</p> -->
    <registration id="registration"></registration>
  </div>

</template>

<style>

    .splash {

      
    
    }
    
    #registration {

    
      
      
    }


</style>

<script>
import registration from '../components/Registration.vue';

export default {
  name: "splash",
  components: {
    registration,
  },
}

</script>