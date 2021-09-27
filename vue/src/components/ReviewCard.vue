<template>
<div class= "container-review">
    
    <span>Reviews</span>
      

    <ReviewForm @review-submitted="addReview" class="review-form"></ReviewForm>
      
    <ReviewList></ReviewList>
    
</div>
</template>

<script>
import ReviewForm from '../components/ReviewForm.vue'
import ReviewList from '../components/ReviewList.vue'

export default {

    name:'ReviewCard',
    components:{
        ReviewForm,
        ReviewList
    }

}
</script>


<style>


.container-review{
    display: flex;
    justify-content: space-around;
    padding: 1rem;    
    width: 100%;
    height: 100%;
}

body > h2{
    margin: 0;
    

}

.review-form{
    display: block;
    width: 100%;
}
 
</style>