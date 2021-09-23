<template>
  <div id="login" class="loginview">
    <form class="form-signin" @submit.prevent="login">
      <button class="btn btn-lg btn-primary btn-block" id="registerbtn">Login</button><br>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
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
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Sign in
      </button><br><br>
      <!-- <router-link :to="{ name: 'register' }">Need an account?</router-link> -->
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>
<style>

.loginview {

    display: flex;
    height: 100vh;
    width: 100vw;
    background-image: url("../assets/Loginbackground.png");
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    align-items: center;
    justify-content: flex-end;
    padding-right: 3rem;

}

</style>