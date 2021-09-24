import axios from 'axios';

export default {

  login(account) {
    return axios.post('/login', account)
  },

  register(account) {
    return axios.post('/register', account)
  }

}
