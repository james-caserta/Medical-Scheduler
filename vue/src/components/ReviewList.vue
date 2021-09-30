<template>
<div id="reviewslist">

    <div id="reviewscontent">
 
    <span class="reviewlisttitles">Office Reviews</span>

        <div id="reviewlistcontainer">

            <div id="reviewtext" v-for='review in reviews' v-bind:key ='review' class="review"> 
                
                <div id="reviewstars">
                <img v-if="review.overall_rating >= 1" class="reviewstarimg" src="../assets/GoldStar.png" alt="">
                <img v-if="review.overall_rating >= 2" class="reviewstarimg" src="../assets/GoldStar.png" alt="">
                <img v-if="review.overall_rating >= 3" class="reviewstarimg" src="../assets/GoldStar.png" alt="">
                <img v-if="review.overall_rating >= 4" class="reviewstarimg" src="../assets/GoldStar.png" alt="">
                <img v-if="review.overall_rating >= 5" class="reviewstarimg" src="../assets/GoldStar.png" alt="">
            
                </div><br>

            {{ review.id }} "{{ review.review }}"
            
            <!-- {{review.overall_rating}} -->

            

            </div>

            

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
    },

    },
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
    

}

.reviewlisttitles {

    display: flex;
    font-family: 'Open Sans', sans-serif;
    font-weight: 800;
    font-size: 1.5em;
    height: 10%;
    width: 90%;
    padding: 1rem;
    
}

#reviewtext {

    display: flex;
    flex-direction: column;
    /* border: solid; */
    /* border-width: medium; */
    border-radius: 10px;
    /* border-color:#F5F1F1; */
    font-family: 'Open Sans', sans-serif;
    font-weight: 600;
    font-size: 0.75em;
    margin: 0.5rem 0;
    padding: 0.5rem;
    background-color: #F5F1F1;
    width: 90%;
    height: 100%;

}

#reviewlistcontainer {

    display: flex;
    flex-direction: column;
    overflow: scroll;
    overflow-x: hidden;
    width: 100%;
    height: 70%;

}

#reviewstars {

    display: flex;
    height: 1rem;
    width: 1rem;
}

.reviewstarimg {

    width: 100%;
    height: 100%;
}


</style>