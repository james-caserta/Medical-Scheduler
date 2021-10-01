<template>
<div class="container-bio">

    <div id="upperprofile">
        <div id="profileitems">
      <span id="profilename">Dr. {{account.lastName}}</span>
      <img id="profilepic" src="../assets/dsicon.png" alt="Profile Picture">
        </div>
        <div id="officeinfo">
            <OfficeInfo></OfficeInfo>
        </div>
        <div id="agendabutton">
            <AgendaButtonDoc v-if="isUserDoctor"></AgendaButtonDoc>
            <AgendaButtonUser v-if="!isUserDoctor"></AgendaButtonUser>
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
import AgendaButtonDoc from '../components/AgendaButtonDoc.vue'
import ApiService from '../services/ApiService.js'
import AgendaButtonUser from '../components/AgendaButtonUser.vue'

export default {
name:'BioCard',
    components:{
        OfficeInfo,
        DoctorBio,
        AgendaButtonDoc,
        AgendaButtonUser,
      },

created() {
  ApiService.getIsDoctor().then(response  => {this.isUserDoctor = response.data})
  ApiService.getDoctorPrincipal().then(response => {this.doctor = response.data})
  ApiService.getAccountPrincipal().then(response => {this.account = response.data})

  },

data(){

  return{

    isUserDoctor: false,
    doctor: {
    "doctorId": '',
    "accountId": '',
    "userType": '',
    "summary": '',
    },
    account: {
    "accountId": '',
    "firstName": '',
    "lastName": '',
    "email": '',
    "userId": '',

    },
  }
    
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
    gap: 1rem;
}

#profileitems {

    display: flex;
    flex-direction: column;
    justify-content: left;
    align-items: center;
    height: 100%;
    width: 25%;
    gap: 0.5rem;
}

#profilename {

    display: flex;
    font-family: 'Open Sans', sans-serif;
    font-weight: 800;
    font-size: 1.5em;
}

#profilepic {

    display: flex;
    height: 50%;
    width: 50%;
    border-radius: 50%;
    background-color: #F5F1F1;
    
}

#officeinfo {
    display: flex;
    width: 50%;
    height: 90%;
    background-color: #F5F1F1;
    border-radius: 15px;
}

#agendabutton {

    display: flex;
    width: 25%;
    height: 80%;
}

#doctorbio {

    display: flex;
    justify-content: flex-end;
    width: 100%;
    height: 42%;
}



</style>