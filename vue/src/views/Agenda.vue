<template>
  <div id="agenda" class="agenda">
    <div id="window">
  <DxScheduler
    time-zone="America/Los_Angeles"
    :data-source="dataSource"
    :current-date="currentDate"
    :views="views"
    :height="720"
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
  },


};
</script>
<style scoped>

  .agenda {

  background-image: url("../assets/MainBackground.png");
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  height: 100vh;
  width: 100vw;
  }

</style>
