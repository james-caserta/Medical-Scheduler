<template>

    <div id="register">
<form class="form-register" @submit.prevent="register">
      <button class="btn btn-lg btn-primary btn-block" id="registerbtn">Register</button><br>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only">Username</label><br>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      /><br>
      <label for="password" class="sr-only">Password</label><br>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      /><br>
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      /><br>
      
      <input type="checkbox" id="doctor-box" class="form-control" v-model="isDoctor"> <label for="doctor-box" class="sr-only">Are you a doctor?</label><br>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Submit
      </button><br><br>

      <!-- <router-link :to="{ name: 'login' }">Already registered?</router-link> -->
</form>
     </div>
  
</template>

<style>

    .form-control {

        margin: 3px;
    }

    .btn {
  margin: 3px;
  background: black;
	border-radius: 15px;
	font-family: 'Open Sans', sans-serif;
	cursor: pointer;
  font-size: 1.25em;
  color: white;
  width: 140px;
  height: 35px;
  font-weight: 600;
  }

  #registerbtn {

    cursor: default;
  }

  .sr-only {

    font-weight: 600;
  }

    

</style>

<script>
import authService from '../services/AuthService';

export default {
  name: "registration",
data() {
    return {
    isDoctor: false,
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } 
      
      else if(this.isDoctor === true) {
          this.user.role = "doctor";
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
      
      else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>