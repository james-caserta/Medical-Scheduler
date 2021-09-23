<template>
  <div>
      <h5>Review by {{ firstName}} {{ lastName }}</h5>

      <div class="stars">
          <img 
            src='../assets/star.png'
            v-for='n in rating' 
            v-bind:key = 'n'
          />
      </div>

      <p>{{ review }}</p>
  </div>
</template>

<script>
export default {
data(){
        return{
            firstName: 'Yousef',
            lastName: 'Khudair',
            review: 'Great experience the staff is very nice and office very clean',
            rating: 3
        }
    }

}
</script>
    
<style scoped>

</style>
