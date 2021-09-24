<template>
<div>
  <h2>Office Reviews Average rating: {{ averageRating }}</h2>

    <div v-for='review in reviews' v-bind:key ='review' class="review"> 
      
      {{ review.id }} > {{ review.review }} {{review.rating}}
    </div>
  
</div>
</template>

<script>
export default {
name: 'list-of-reviews',
    data(){
        return{
            reviews:[]

        }
    },

    computed:{
        averageRating(){
            let sum = this.reviews.reduce(
                (total, review)=> {
                  return total + review.rating;
                
                }, 0 
            );

            return sum / this.reviews.length;
        }

    }
}
</script>

<style>

</style>