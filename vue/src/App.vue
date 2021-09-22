<template>
  <div id="app">
    <!-- <div id="nav">
      <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''">Home</router-link>&nbsp; &nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div> -->
    <router-view id="view"/>
    
  </div>
</template>

<style>

  #app {

    height: 100vh;
    width: 100vw;
    background-image: url("./assets/SplashBackground.png");
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
   
  }

  #view {

    display: flex;
    justify-content: center;
    align-items: flex-end;
    margin-right: 3rem;
    margin-left: 3rem;
  }


 

</style>

<script>

export default {
  name: "app",
  
};

</script>