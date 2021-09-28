<template>
  <div id="reviewFormContainer">
    <button
      class="btn"
      href="#"
      v-if="showForm === false"
      v-on:click.prevent="showForm = true"
    >
      Add Review
    </button>

    <form class="reviewForm" v-if="showForm === true" v-on:submit.prevent="onSubmit">
      <label>Submit Review</label>
      <input type="text" required v-model="review" />
      <label>Rating</label>
      <select id="rating" v-model.number="overall_rating">
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
      </select>
      <button class="btn">Submit</button>
      <button
        class="btn"
        href="#"
        v-if="showForm === true"
        v-on:click.prevent="showForm = false"
      >
        Cancel
      </button>
    </form>
  </div>
</template>

<script>
import apiservice from "../services/ApiService.js";

export default {
  data() {
    return {
      showForm: false,

      review: "",
      overall_rating: -1,
    };
  },

  methods: {
    onSubmit() {
      let UserReview = {
        patientId: 1,
        doctorId: 3,
        overall_rating: this.overall_rating,
        review: this.review,
      };

      console.log("** DEBUG **");
      console.log(UserReview);

      apiservice.addReview(UserReview).then((response) => {
         if (response.status === 201) {
              this.$router.push(`/profile`).catch( () => {});
            }
      });

      // TODO: call axios webservice method
      // that will process the post, include
      // the object UserReview above on the request.

      this.review = null;
      this.overall_rating = null;
    },
  }
};
</script>

<style scoped>
#reviewFormContainer {

  display: flex;
  width: 94%;
  padding: 1rem;
}

label {
  color: #aaa;
  display: inline-block;
  margin: 25px 0 15px;
  font-size: 0.6em;
  text-transform: uppercase;
  letter-spacing: 1px;
  font-weight: bold;
}

input {
  display: block;
  padding: 10px 6px;
  width: 100%;
  box-sizing: border-box;
  border: none;
  border-bottom: 1px solid #ddd;
  color: #555;
}

/* .submit-button {
  margin-left: 25px;
  padding: 5px 30px;
} */

/* button {
  margin: 1%;
  background-color: #0019a8;
  border: none;
  color: white;
  padding: 5px 10px;
} */

.btn {

margin: 0.1rem;
background: #6b89c6;
border-radius: 1rem;
font-family: 'Open Sans', sans-serif;
cursor: pointer;
font-size: 1em;
color: white;
font-weight: 600;
  
  }

  .reviewForm {

    width: 100%
  }
</style>