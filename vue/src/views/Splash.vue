<template>
  <div class="splash">
    <div id="nav"><span id="logo">DrSched</span>
      
      <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token = ''">Login</router-link>
      <!-- <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''">Home</router-link>&nbsp; &nbsp; -->
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <!-- <splashslogan id="splashslogan"></splashslogan> -->
    <registration id="registration"></registration>

  </div>

</template>

<style>

    .splash {

    display: flex;
    height: 100vh;
    width: 100vw;
    background-image: url("../assets/SplashBackground.png");
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    
    
    }
    
    #registration {

    display: flex;
    align-items: center;
    justify-content: right;
    margin-right: 5rem;
      
    }

    #splashslogan {

      display: flex;
      justify-content: left;
      align-items: top;

    }

    #logo {

    color:#07329E;
    font-size: 3em;
    font-family: 'Open Sans', sans-serif;
    font-weight: 800;
  }


</style>

<script>
import registration from '../components/Registration.vue';
// import splashslogan from '../components/SplashSlogan.vue';

export default {
  name: "splash",
  components: {
    registration,
    // splashslogan,
  },
}

</script>