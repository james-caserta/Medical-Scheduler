<template>
<div id="reviewslist">

    <div id="reviewscontent">
 
    <span class="reviewlisttitles">Office Reviews</span>

        <div id="reviewtext" v-for='review in reviews' v-bind:key ='review' class="review"> 
        
        {{ review.id }} > {{ review.review }} {{review.rating}}

        </div>

    </div>
    <!-- <span class="reviewlisttitles">Average Rating: {{averageRating}} </span> -->
     
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

<style scoped>

#reviewslist{

display: flex;
flex-direction: column;
padding: 1rem;
width: 94%;
height: 100%;
}

.reviewlisttitles {

    font-family: 'Open Sans', sans-serif;
    font-weight: 800;
    font-size: 1.5em;
}

#reviewtext {

    display: flex;
    flex-direction: column;
    border: solid;
    border-width: medium;
    border-radius: 10px;
    border-color:#F5F1F1;
    font-family: 'Open Sans', sans-serif;
    font-weight: 600;
    font-size: 0.75em;
    margin: 0.5rem 0;
    padding: 0.5rem;
    overflow: auto;
    background-color: #F5F1F1;

}


</style>