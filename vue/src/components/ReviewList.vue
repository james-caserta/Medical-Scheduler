<template>
<div id="reviewslist">
<<<<<<< HEAD

    <div id="reviewscontent">
 
    <span class="reviewlisttitles">Office Reviews</span>
=======
 <body> 
         <h2>Office Reviews Average rating: {{averageRating}} </h2>
>>>>>>> ac5be98a75c803494adb909dd79ee64311fc6611

        <div v-for='review in reviews' v-bind:key ='review' class="review"> 
        
<<<<<<< HEAD
        {{ review.id }} > {{ review.review }} {{review.rating}}

        </div>

    </div>
    <span class="reviewlisttitles">Average rating: {{averageRating}} </span>
     
=======
            {{ review.review }} {{review.overall_rating}}
        </div>
   </body>  
>>>>>>> ac5be98a75c803494adb909dd79ee64311fc6611
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

#reviewslist{

display: flex;
padding: 1rem;
width: 100%;
height: 100%;
}

.reviewlisttitles {

    font-family: 'Open Sans', sans-serif;
    font-weight: 800;
}


</style>