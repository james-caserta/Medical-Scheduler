<template>
  <form class="reviewForm" @submit.prevent="OnSubmit">

        <label>Submit Review</label>
        <input type="text" required v-model = "review">
        
        <label>Rating</label>
        <select id ="rating" v-model.number="rating">
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>  
        </select>

        <button class="submitButton">Submit</button>
      
    
  </form>
</template>

<script>
export default {

data(){
    return{
        review: null,
        rating: null
    }
},

    method:{
        OnSubmit(){
            let UserReview = {
                review: this.review,
                rating: this.rating
            }
            this.$emit('review-submitted', UserReview)
            this.review = null
            this.rating = null
        },

        addReview(UserReview){
            this.reviews.push(UserReview)
        }

    }
}
</script>

<style scoped>

    *{
        max-width: 420px;
        margin: 30 px auto;
        background: white;
        text-align: left;
       
        border-radius: 10px ;
    }

    #rating{

    }


    label{
        color: #aaa;
        display: inline-block;
        margin: 25px 0 15px;
        font-size: 0.6em;
        text-transform: uppercase;
        letter-spacing: 1px;
        font-weight: bold;        
    }

    input{
        display: block;
        padding: 10px 6px;
        width: 100%;
        box-sizing: border-box;
        border: none;
        border-bottom: 1px solid #ddd;
        color: #555;
    }

    .submitButton{
       margin-left: 80px;
     
       background-color: #0019a8; 
       border: none;
       color: white;
       padding: 5px 50px;

    }

</style>