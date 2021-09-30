<template>
<div id="office-list">

    <div id="officecontent">
 
    <span class="officelisttitles">Offices</span>

        <div id="officelistcontainer">

            <div id="officeObject" v-for='office in offices' v-bind:key ='office'> 
               <img class="office-image" src="../assets/officeImage.png">                 
               
               <p id="officetext">
                Address: {{office.streetAddress}} 
               {{office.city}},
               {{office.state}}
               {{office.zip}} <br>
                Phone Number:  {{office.phoneNumber}} </p>

                <Button v-on:click = "selectOffice(officeId)" class="btn">View Doctors</Button>
            </div>
           

        </div>

    </div>
     
</div>
</template> 

<script>
import apiservice from '../services/ApiService.js'

export default {
name: 'office-page',

    created(){
        apiservice.getAllOffices().then(
            (response) => {
                    this.offices = response.data
            }
        )
    },
        
    data(){
        return{
            offices:[],
            doctors:[]
        }
    },

    methods:{
        selectOffice(){
            apiservice.getDoctorsByOfficeId(2).then(
                (response) => {
                    this.doctors = response.data
        });




        }

    }

}
</script>

<style scoped>

#office-list{

display: flex;
flex-direction: column;
width: 100%;
height: 100%;

}

::-webkit-scrollbar {
  width: 15px;
}

::-webkit-scrollbar-track {
  background: #F5F1F1;
  border-radius: 15px; 
}
 
::-webkit-scrollbar-thumb {
  background: #6b89c6;
  border-radius: 15px; 
}

#officecontent {

    display: flex;
    flex-direction: column;
    padding: 1rem;
    height: 100%;
    

}

.officelisttitles {

    display: flex;
    font-family: 'Open Sans', sans-serif;
    font-weight: 800;
    font-size: 1.5em;
    height: 10%;
    width: 90%;
    padding: 1rem;
    
}

#officeObject {

    display: flex;
    flex-direction:row;
    justify-content: space-between;
    border-radius: 10px;
    font-family: 'Open Sans', sans-serif;
    font-weight: 800;
    font-size: 1em;
    margin: 0.5rem 0;
    padding: 0.5rem;
    background-color: #F5F1F1;
    width: 90%;
    height: 100%;

}
.btn {

margin: 0.1rem;
background: #6b89c6;
border-radius: 1rem;
font-family: 'Open Sans', sans-serif;
cursor: pointer;
font-size: 1em;
color: white;
font-weight: 600;
width: 5rem;
  
}


#officelistcontainer {

    display: flex;
    flex-direction: column;
    overflow: scroll;
    overflow-x: hidden;
    width: 100%;
    height: 70%;

}

.office-image{
    display: flex;
    height: 5rem;
    width: 5rem;
}

</style>