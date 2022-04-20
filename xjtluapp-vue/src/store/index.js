import { createStore } from 'vuex'

export default createStore({
  state: {
    token: [localStorage.getItem("token"), sessionStorage.getItem("token")]
        .filter((item)=>item)
        .pop(),
    userInfo: JSON.parse(sessionStorage.getItem("userInfo")),
    serverUrl: "http://47.110.224.16:8081",
    staticUrl: "/static",
    articleTypeList: [],
    guideTypeList: [],
    selectedTags: [],
    isDarkMode: Boolean(localStorage.getItem("isDarkMode")),
    lang: localStorage.getItem("lang")
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
    REMOVE_USER: (state) => {
      state.token = ""
      state.userInfo = null
      localStorage.removeItem("token")
      sessionStorage.removeItem("token")
      sessionStorage.removeItem("userInfo")
    },
    SET_ARTICLE_TYPE_LIST: (state, type_list) => {
      state.articleTypeList = type_list
    },
    SET_GUIDE_TYPE_LIST: (state, type_list) => {
      state.guideTypeList = type_list
    },
    PUSH_SELECTED_TAG: (state, tag) => {
      state.selectedTags.push(tag)
    },
    POP_SELECTED_TAG: (state, tag) => {
      state.selectedTags.forEach((item, index, array) => {
        if (item === tag) {
          array.splice(index,1);
        }
      })
    },
    SET_DARK_MODE: (state, value) => {
      state.isDarkMode = value
      localStorage.setItem("isDarkMode", value)
    },
    SET_LANG: (state, value) => {
      state.lang = value
      localStorage.setItem("lang", value)
    }
  },
  getters: {
    // get
    getUserInfo: state => {
      return state.userInfo
    },

    getToken: state => {
      return state.token
    },

    getServerUrl: state => {
      return state.serverUrl
    },

    getStaticUrl: state => {
      return state.serverUrl + state.staticUrl
    },

    getArticleTypeList: state => {
      return state.articleTypeList
    },

    getGuideTypeList: state => {
      return state.guideTypeList
    },

    getSelectedTags: state => {
      return state.selectedTags
    },

    getIsDarkMode: state => {
      return state.isDarkMode
    },

    getLang: state => {
      return state.lang
    }
  },
  actions: {
  },
  modules: {
  }
})
