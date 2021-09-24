<template>
<div class="userProfile">
    <h2>Dr. Smith</h2>
      <Review></Review>
      <ReviewList></ReviewList>
      <ReviewForm @review-submitted="addReview"></ReviewForm>

</div>

</template>

<script>
import Review from '../components/Review.vue'
import ReviewList from '../components/ReviewList.vue'
import ReviewForm from '../components/ReviewForm.vue'

export default {
    name: 'review',
  components:{
    Review,
    ReviewList,
    ReviewForm
       
  }

}
</script>

<style>

</style>