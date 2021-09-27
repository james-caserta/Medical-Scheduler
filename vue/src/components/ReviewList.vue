<template>
<div>
   <body>
 
         <h2>Office Reviews Average rating: {{averageRating}} </h2>

        <div v-for='review in reviews' v-bind:key ='review' class="review"> 
        
            {{ review.review }} {{review.overall_rating}}
        </div>
   </body>  
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
        averageRating(){
            let sum = this.reviews.reduce(
                (total, review)=> {
                  return total + review.reviewRating;
                
                }, 0 
            );

            return sum / this.reviews.length;
        }

    }
}
</script>

<style>


</style>