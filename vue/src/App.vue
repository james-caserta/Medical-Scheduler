<template>
  <div id="app">
    
    <router-view id="view"/>
    
  </div>
</template>

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