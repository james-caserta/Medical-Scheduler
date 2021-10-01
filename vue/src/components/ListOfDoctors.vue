<template>
<div id="office-list">

    <div id="officecontent">
 
    <span class="officelisttitles">Doctors</span>

        <div id="officelistcontainer">
        
            <div id="officetext" v-for='doctor in offices' v-bind:key ='doctor'>                                
             <p>  Display Doctors information</p>
            </div>
           
        </div>
    </div>
     
</div>
</template> 

<script>
import apiservice from '../services/ApiService.js'

export default {
name: 'list-of-offices',

    created(){
        apiservice.getAllDoctors().then(
            (response) => {
                    this.doctors = response.data
            }
        )

    },
        
    data(){
        return{
            doctors:[],
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

#officetext {

    display: flex;
    flex-direction: column;
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

#officelistcontainer {

    display: flex;
    flex-direction: column;
    overflow: scroll;
    overflow-x: hidden;
    width: 100%;
    height: 70%;

}

</style>