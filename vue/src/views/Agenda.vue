<template>
  <div id="agenda" class="agenda">
    <div id="window">
      <div id="actualagenda">
  <DxScheduler
    time-zone="America/Los_Angeles"
    :data-source="dataSource"
    :current-date="currentDate"
    :views="views"
    :height="720"
    :width="1240"
    :start-day-hour="9"
    :adaptivity-enabled="true"
    :on-appointment-added="showAddedToast"
    :on-appointment-updated="showUpdatedToast"
    :on-appointment-deleted="showDeletedToast"
    :editing="editing"
    current-view="week"
    
  >
    <DxResource
      :data-source="doctors"
      :use-color-as-default="true"
      :allow-multiple="true"
      field-expr="doctorId"
      label="Doctor"
    />
    <DxResource
      :data-source="offices"
      field-expr="officeId"
      label="Office"
    />
  </DxScheduler>
  <button class="btn btn-lg btn-primary btn-block" type="submit" v-on:click="goProfile">Back</button>
  </div>
  
    </div>
    
  </div>
</template>
<script>

// let data = [];
// let doctors = [];
// let offices = [];

import DxScheduler, { DxResource } from 'devextreme-vue/scheduler';
import ApiService from '../services/ApiService.js'
import { data, doctors, offices } from '../data.js';
import notify from 'devextreme/ui/notify';

export default {
  
  components: {
    DxScheduler,
    DxResource
  },
  data() {
    return {
      isUserDoctor: false,
      data: [],
      views: ['agenda'],
      currentDate: new Date(),
      dataSource: data,
      doctors: doctors,
      offices: offices,
      allowAdding: false,
      allowDeleting: false,
      allowUpdating: false,
      allowResizing: false,
      allowDragging: false,
    };
  },
  created(){
        ApiService.getIsDoctor().then(response  => {
         if (true == response.data){
            this.allowAdding = true
            this.allowUpdating = true
            this.allowResizing = true
            this.allowDragging = true
            this.allowDeleting = true

         }
         
         
         })
    },

computed: {
    editing() {
      return {
        allowAdding: this.allowAdding,
        allowDeleting: this.allowDeleting,
        allowUpdating: this.allowUpdating,
        allowResizing: this.allowResizing,
        allowDragging: this.allowDragging,
      };
    },
  },

methods: {
    showToast: function(event, value, type) {
      notify(`${event} "${value}" task`, type, 800);
    },

    showAddedToast: function(e) {
      this.showToast('Added', e.appointmentData.text, 'success');
    },

    showUpdatedToast: function(e) {
      this.showToast('Updated', e.appointmentData.text, 'info');
    },

    showDeletedToast: function(e) {
      this.showToast('Deleted', e.appointmentData.text, 'warning');
    },

    goProfile(){this.$router.push("/profile");},
  },


};
</script>
<style scoped>

  #agenda {
    display: flex;
  background-image: url("../assets/MainBackground.png");
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  height: 100vh;
  width: 100vw;
  align-items: center;
  justify-content: center;
  }

  .btn {

/* margin: 0.1rem; */
background: #6b89c6;
/* border-radius: 1rem; */
border-width: thin;
font-family: 'Open Sans', sans-serif;
cursor: pointer;
font-size: 1em;
padding: 1rem;
color: white;
font-weight: 600;
width: 5rem;
  
  }

  #window {

    display: flex;
    flex-direction: column;
    align-items: center;
    height: 100%;
    width: 100%;
  }

  #actualagenda {

    display: flex;
    /* flex-direction: column; */
    /* height: 100%; */
  }

</style>
