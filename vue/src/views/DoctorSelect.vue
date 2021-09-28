<template>
    <div id="doctorselect">

        <div class="title"><span id="logo">DrSched</span></div>

        <div id="doctorscontainer">
        <DoctorList id="doctorslist"></DoctorList>
        </div>

    </div>
</template>

<style>
#doctorselect{
  display: flex;
  flex-direction: column;
  height: 100vh;
  background-image: url("../assets/MainBackground.png");
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
}

.title {

      display: flex;
      flex-direction: column;
      margin-top: 1rem;
      margin-left: 1rem;
      margin-right: 1rem;
      height: 20%;
      justify-content: flex-start;
      align-items: left;
      /* gap: 3rem; */
    }

    #logo {

    color:#07329E;
    font-size: 4em;
    font-family: 'Open Sans', sans-serif;
    font-weight: 800;
    /* margin-bottom: 5rem; */
    text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  }

  #doctorscontainer {

    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    
    border-radius: 15px;
    font-family: 'Open Sans', sans-serif;
    font-weight: 600;
    width: 100%;
    height: 50%;
    /* padding: 0.5rem; */
  }

  #doctorslist {

    display: flex;
    background-color: #F5F1F1;

  }

</style>

<script>
import DoctorList from '../components/DoctorList.vue'

export default {
  
    name: 'doctorselect',
    components:{
    DoctorList,
       
  },

}
</script>