<template>
<div class="profile">
    <div class ="cards">
    <div class="bio-card">
        <BioCard></BioCard>
      </div>

      <div class="review-card">
         <ReviewList/>
         <ReviewForm/>
      </div>
    </div>
    
</div>

</template>

<script>

import ReviewList from '../components/ReviewList.vue'
import ReviewForm from '../components/ReviewForm.vue'
import BioCard from '../components/BioCard.vue'

export default {
  
    name: 'review',
    components:{
    BioCard,
    ReviewList,
    ReviewForm
       
  }

}
</script>

<style>

.profile{
  display: flex;
  flex-direction: column;
  height: 100vh;
  background-image: url("../assets/MainBackground.png");
  background-size: cover;
  background-position: top;
  background-repeat: no-repeat;
}

.cards{
  display: flex;
  height: 100%;
  border-radius: 25px;
  align-items: center;
    
}

.bio-card{
  display: flex;
  background-color:#FFFFFF;
  flex-grow: 2;
  margin: 10px 5px 10px 20px;
  border-radius: 15px;
  height: 50%;
}

.review-card{
  display: flex;
  background-color:#FFFFFF;
  flex-grow: 1;
  margin: 10px 20px 10px 5px;
  border-radius: 15px;
  height: 50%;
}

</style>