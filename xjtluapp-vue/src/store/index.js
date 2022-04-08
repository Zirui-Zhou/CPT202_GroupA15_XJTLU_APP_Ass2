import { createStore } from 'vuex'

export default createStore({
  state: {
    token: localStorage.getItem("token"),
    userInfo: JSON.parse(sessionStorage.getItem("userInfo"))
  },
  mutations: {
    SET_TEMP_TOKEN: (state, token) => {
      state.token = token
      sessionStorage.setItem("token", token)
    },
    SET_PERM_TOKEN: (state, token) => {
      state.token = token
      localStorage.setItem("token", token)
    },
    SET_USERINFO: (state, userInfo) => {
      state.userInfo = userInfo
      sessionStorage.setItem("userInfo", JSON.stringify(userInfo))
    },
    REMOVE_INFO: (state) => {
      state.token = ''
      state.userInfo = {}
      localStorage.setItem("token", '')
      sessionStorage.setItem("userInfo", JSON.stringify(''))
    }
  },
  getters: {
    // get
    getUserInfo: state => {
      return state.userInfo
    },

    getToken: state => {
      return state.token
    }
  },
  actions: {
  },
  modules: {
  }
})
