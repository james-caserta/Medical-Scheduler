<template>
<div id="reviewslist">
 
    <span>Office Reviews Average rating:</span>

    <div v-for='review in reviews' v-bind:key ='review' class="review"> 
        
    {{ review.id }} > {{ review.review }} {{review.rating}}

    </div>
     
</div>
</template>

<script>
import apiservice from '../services/ApiService.js'

export default {
name: 'list-of-reviews',

        created(){
            apiservice.getAllReviews().then(
                (response) => {
                    this.reviews = response.data
                }

            )
        },

    data(){
        return{
            reviews:[]

        }
    },

    computed:{
     /*   averageRating(){
            let sum = this.reviews.reduce(
                (total, review)=> {
                  return total + review.rating;
                
                }, 0 
            );

            return sum / this.reviews.length;
        }*/

    }
}
</script>

<style>

#reviewslist{

display: flex;
padding: 1rem;
width: 100%;
height: 100%;
}


</style>