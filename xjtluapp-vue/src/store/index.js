import { createStore } from 'vuex'

const modules = {}
const files = require.context('./modules', true, /\.js$/)

files.keys().forEach(file => {
  const moduleName = file.replace(/(^\.\/)|(.js$)/g, '');
  modules[moduleName] = files(file).default || files(file);
});

export default createStore({
  state: {
    // serverUrl: "http://47.110.224.16:8081",
    serverUrl: "http://localhost:8081",
    staticUrl: "/static",
  },
  getters: {
    getServerUrl: state => {
      return state.serverUrl
    },
    getStaticUrl: state => {
      return state.serverUrl + state.staticUrl
    },
  },
  modules: {
    ...modules
  }
})
