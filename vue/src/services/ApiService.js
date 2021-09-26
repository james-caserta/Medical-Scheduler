import axios from 'axios';

export default {

    createdAgenda(user) {
        return axios.get('/agenda', user)
      }

}