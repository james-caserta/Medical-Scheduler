<template>
  <div id="agenda" class="agenda">
  <DxScheduler
    time-zone="America/Los_Angeles"
    :data-source="dataSource"
    :current-date="currentDate"
    :views="views"
    :height="850"
    :start-day-hour="9"
    :adaptivity-enabled="true"
    current-view="agenda"
    
  >
    <DxResource
      :data-source="doctors"
      :use-color-as-default="true"
      :allow-multiple="true"
      field-expr="doctorId"
      label="Doctor"
    />
    <DxResource
      :data-source="priorities"
      field-expr="priorityId"
      label="Priority"
    />
  </DxScheduler>
  </div>
</template>
<script>

let data = [];
let doctors = [];
let offices = [];

import DxScheduler, { DxResource } from 'devextreme-vue/scheduler';
import apiservice from '../services/ApiService.js'

export default {
  
  components: {
    DxScheduler,
    DxResource
  },
  data() {
    return {
      data: [],
      views: ['agenda'],
      currentDate: new Date(),
      dataSource: data,
      doctors: doctors,
      priorities: offices,
    };
  },
  created(){
        apiservice.getAppointmentById(1).then(
            (response) => {
                    this.appointment = response.data
            }

        )
    },
};
</script>
<style scoped>

  .agenda {

    display: flex;
  }

</style>
