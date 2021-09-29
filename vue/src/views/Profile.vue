<template>
<div class="profile">
  <div class="title"><span id="logo">DrSched</span></div>
    <div class ="cards">
    <div class="bio-card">
        <BioCard></BioCard>
      </div>

      <div class="review-card">
        <div id="review-card-content">
         <ReviewList id="reviewsList"/>
         <ReviewForm id="reviewsForm"/>
         </div>
      </div>
    </div>
    
</div>

</template>

<script>

import ReviewList from '../components/ReviewList.vue'
import ReviewForm from '../components/ReviewForm.vue'
import BioCard from '../components/BioCard.vue'

export default {
  
    name: 'profile',
    components:{
    BioCard,
    ReviewList,
    ReviewForm
       
  }

}
</script>

<style scoped>

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

.profile{
  display: flex;
  flex-direction: column;
  height: 100vh;
  background-image: url("../assets/MainBackground.png");
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  overflow-y: hidden;
  overflow-x: hidden;
}

.cards{
  display: flex;
  height: 100%;
  border-radius: 25px;
  align-items: flex-start;
    
}

.bio-card{
  display: flex;
  background-color:#FFFFFF;
  flex-grow: 2;
  margin: 1rem;
  border-radius: 15px;
  height: 65%;
  width: 60%;
}

.review-card{
  display: flex;
  flex-direction: column;
  background-color:#FFFFFF;
  flex-grow: 1;
  margin: 1rem;
  border-radius: 15px;
  height: 65%;
  width: 40%;
}

#review-card-content {

  display: flex;
  flex-direction: column;
  height: 100%;
  width: 100%;
}

#reviewsList {

  display: flex;
  flex-direction: column;
  height: 80%;
}

#reviewsForm {

  display: flex;
  flex-direction: column;
  /* align-items: center; */
  justify-content: center;
  height: 100%;
  padding: 1rem;
}

</style>