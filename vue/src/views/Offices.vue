<template>
    
    <div class="office">
        
             <div class="title"><span id="logo">DrSched</span></div>
             <div class ="cards">
        
            <div class="office-card">
            <OfficesCard/>
            </div>

        <div class="doctor-card">
            <div id="doctor-card-content">
                <DoctorsCard/>
            </div>
        </div>
    </div>
    </div>
    
    
</template>

<script>
import DoctorsCard from '../components/ListOfDoctors.vue'
import OfficesCard from '../components/Offices.vue'

export default {
    name: 'offices',
       
    components: {
        DoctorsCard,
        OfficesCard
    
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
      align-items: left;
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
  height: 100%;
  border-radius: 25px;
  align-items: flex-start;
    
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