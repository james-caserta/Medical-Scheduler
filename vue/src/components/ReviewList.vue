<template>
<div id="reviewslist">

    <span class="reviewlisttitles">Office Reviews</span>

    <div id="reviewscontent">
 
    

        <div id="reviewtext" v-for='review in reviews' v-bind:key ='review' class="review"> 
        
        {{ review.id }} > {{ review.review }} <br><br>{{review.overall_rating}}

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
width: 100%;
height: 100%;

}

::-webkit-scrollbar {
  width: 15px;
  padding-right: 5px;
}

::-webkit-scrollbar-track {
  background: #F5F1F1;
  border-radius: 15px; 
}
 
::-webkit-scrollbar-thumb {
  background: #6b89c6;
  border-radius: 15px; 
}

#reviewscontent {

    display: flex;
    flex-direction: column;
    padding: 1rem;
    height: 100%;
    overflow: scroll;
    overflow-x: hidden;

}

.reviewlisttitles {

    display: flex;
    font-family: 'Open Sans', sans-serif;
    font-weight: 800;
    font-size: 1.5em;
    height: 15%;
    width: 90%;
    padding: 1rem;
    
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
    background-color: #F5F1F1;

}


</style>