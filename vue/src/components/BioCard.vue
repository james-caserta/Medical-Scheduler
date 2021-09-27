<template>
<div class="container-bio">

    <div id="upperprofile">
        <div id="profileitems">
      <span id="profilename">Dr. Smith</span>
      <img id="profilepic" src="../assets/dsicon.png" alt="Profile Picture">
        </div>
        <div id="officeinfo">
            <OfficeInfo></OfficeInfo>
        </div>
    </div>
    

    <div id="doctorbio">
      <DoctorBio></DoctorBio>
    </div>
    
</div>
</template>

<script>
import OfficeInfo from '../components/OfficeInfo.vue'
import DoctorBio from '../components/DoctorBio.vue'
export default {
name:'ReviewCard',
    components:{
        OfficeInfo,
        DoctorBio
      }
}
</script>

<style scoped>

.container-bio{
    display: flex;
    flex-direction: column;
    /* justify-content: space-around; */
    padding: 1rem;
    width: 100%;
    height: 100%;
    
}

#upperprofile {

    display: flex;
    flex-direction: row;
    height: 45%;
    width: 100%;
}

#profileitems {

    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: left;
    height: 100%;
    width: 50%;
}

#profilename {

    display: flex;
    font-family: 'Open Sans', sans-serif;
    font-weight: 800;
    font-size: 2em;
}

#profilepic {

    display: flex;
    height: 50%;
    width: 25%;
    border-radius: 50%;
    background-color: #F5F1F1;
    border-radius: 50%;
    
}

#officeinfo {
    display: flex;
    width: 50%;
    height: 80%;
}

#doctorbio {

    display: flex;
    justify-content: flex-end;
    width: 100%;
    height: 42%;
}



</style>