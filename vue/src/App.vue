<template>
  <div id="app">
    
    <router-view id="view"/>
    
  </div>
</template>

<style>

  #app {

    font-family: 'Open Sans', sans-serif;
    height: 100vh;
    width: 100vw;
    display: flex;
    
  }

</style>

<script>

export default {
  name: "app",
  
};

</script>