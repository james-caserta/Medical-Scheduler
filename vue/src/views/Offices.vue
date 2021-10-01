<template>
    
    <div class="office">
        
             <div class="title"><span id="logo">DrSched</span></div>
             <div class ="cards">
        
        <OfficeInfo/>
            
    </div>
    </div>
    
    
</template>

<script>
import OfficeInfo from '../components/OfficeInfo.vue'

export default {
    name: 'offices',
       
    components: {
        OfficeInfo,
    
    }


}
</script>

<style scoped>

.title {

      display: flex;
      flex-direction: column;
      margin-top: 1rem;
      margin-left: 1rem;
      margin-right: 1rem;
      height: 20%;
      justify-content: flex-start;
    }

    #logo {

    color:#07329E;
    font-size: 4em;
    font-family: 'Open Sans', sans-serif;
    font-weight: 800;
    /* margin-bottom: 5rem; */
    text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  }

.office{
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100vh;
  background-image: url("../assets/MainBackground.png");
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  overflow-y: hidden;
  overflow-x: hidden;
}

.cards{
  display: flex;
  width: 50%;
  height: 70%;
  border-radius: 25px;
  align-items: flex-start;
  background-color: #F5F1F1;
    
}

.office-card{
    display: flex;
  flex-direction: column;
  background-color:#FFFFFF;
  flex-grow: 1;
  margin: 1rem;
  border-radius: 15px;
  height: 65%;
  width: 50%;
}

.doctor-card{
  display: flex;
  flex-direction: column;
  background-color:#FFFFFF;
  flex-grow: 1;
  margin: 1rem;
  border-radius: 15px;
  height: 65%;
  width: 50%;
}

#doctor-card-content {

  display: flex;
  flex-direction: column;
  height: 100%;
  width: 100%;
}

</style>