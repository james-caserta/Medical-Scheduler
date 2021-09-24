<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''">Home</router-link>&nbsp; &nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
     
    </div>
    <router-view />
  </div>
</template>

<script>



export default {
  name: 'App',
  components:{
    
  }
  
}
</script>
<style>

  #app {

    font-family: 'Open Sans', sans-serif;
    height: 100%;
    width: 100%;
    display: flex;
    
  }

</style>

<script>

export default {
  name: "app",
  
};

</script>