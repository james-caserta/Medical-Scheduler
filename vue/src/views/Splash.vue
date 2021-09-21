<template>
  <div class="splash">
    <h1>DrSched</h1>
    <h2>We make booking with your doctor easy.</h2>
    <p>Find your doctor and book today.</p>

    
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        New Patient Registration
      </button><br><br>

      <button class="btn btn-lg btn-primary btn-block" type="submit">
        New Doctor Registration
      </button>

  </div>

  
  
</template>

<style>

    .splash {

        background-image: "src\assets\SplashBackground.png";
    }

    .form-control {

        margin: 3px;
    }

    .btn {
        margin: 3px;
    }

</style>

<script>
import authService from '../services/AuthService';

export default {
  name: "splash",
data() {
    return {
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
      } else {
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