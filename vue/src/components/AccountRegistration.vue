<template>

    <div id="registeraccount">
<form class="form-register" @submit.prevent="register">
      <span class="registerbtn">Register</span>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="firstname" class="sr-only">First name</label>
      <input
        type="text"
        id="firstname"
        class="form-control"
        placeholder="First name"
        v-model="account.firstName"
        required
        autofocus
      />
      <label for="lastname" class="sr-only">Last name</label>
      <input
        type="text"
        id="lastname"
        class="form-control"
        placeholder="Last name"
        v-model="account.lastName"
        required
        autofocus
      />
      <label for="email" class="sr-only">E-mail</label>
      <input
        type="email"
        id="email"
        class="form-control"
        placeholder="E-mail"
        v-model="account.email"
        required
        autofocus
      />
      
      <!-- <div class="doctor-box"><input type="checkbox" id="doctor-box" class="form-control" v-model="user.is_doctor"> <label for="doctor-box">Are you a doctor?</label></div> -->
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Submit
      </button>

      <!-- <router-link :to="{ name: 'login' }" id="alreadyuser">I have an account</router-link> -->

      <!-- <router-link :to="{ name: 'login' }">Already registered?</router-link> -->
</form>
     </div>
  
</template>

<style scoped>

#registeraccount {

  display: flex;
  flex-direction: column;
}

    .form-register {
      display: flex;
      flex-direction: column;
      align-items: center;
      gap: 5px;
      background: #009cdd;
      border-radius: 1rem;
      padding: 2rem;
      
        
    }

    .btn {
  margin: 3px;
  background: black;
	border-radius: 1rem;
  border-width: thin;
	font-family: 'Open Sans', sans-serif;
	cursor: pointer;
  font-size: 1.25em;
  color: white;
  width: 140px;
  height: 35px;
  font-weight: 600;
  padding-left: 5px;
  
  }

  .registerbtn {

  font-family: 'Open Sans', sans-serif;
  font-weight: 600;
  /*text-decoration: underline;*/
  margin-bottom: 1rem;
  font-weight: 800;
  font-size: 1.5em;
  color:white;
  text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  
  }

  .sr-only {

    font-weight: 600;
    /* margin-right: 5.5rem; */
    align-items: left;
    justify-content: flex-start;
    color: white;
    text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  }

  /* .doctor-box {

    margin-right: 1rem;
    text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    font-weight: 600;
    color: white;
    font-family: 'Open Sans', sans-serif;
  } */

  /* #alreadyuser {

  font-size: 1em;
  color: white;
  font-family: 'Open Sans', sans-serif;
  font-weight: 600;
  text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  } */

  .alert {

      color: white;
  }
    

</style>

<script>
import ApiService from '../services/ApiService';

export default {
  name: "accountregistration",
data() {
    return {
      user: {
        userId: '',
        username: '',
        password: '',
        confirmPassword: '',
        role: '',
        is_doctor: '',
      },
      account: {
        accountId: '',
        firstName: '',
        lastName: '',
        email: '',
        userId: '',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    addUserID(){
      this.account.userId = this.user.userId;

    },

    register() {
        ApiService
          .addAccount(this.account)
          .then((response) => {
 
            if (response.status == 201) {
              this.$router.push('/profile')
            }
          })
          .catch(() => {});
      }
    },
    

    created(){

      ApiService.getUserIDPrincipal().then(response => {this.account.userId = response.data})


  }
  }
</script>