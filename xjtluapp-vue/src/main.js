import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import * as ElIconModules from '@element-plus/icons'


import VueAxios from 'vue-axios'
import axios from 'axios'


const app = createApp(App)
for (const iconName in ElIconModules) {
    if (Reflect.has(ElIconModules, iconName)) {
        const item = ElIconModules[iconName]
        app.component(iconName, item)
    }
}

app.use(store)
app.use(router)
app.use(ElementPlus)
app.use(VueAxios, axios);
app.config.globalProperties.$axios = axios // 自定义添加
app.mount('#app')