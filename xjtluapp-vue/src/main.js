import { createApp } from 'vue'

import ElementPlus from 'element-plus'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import 'element-plus/dist/index.css'

import VMdEditor from '@kangc/v-md-editor';
import '@kangc/v-md-editor/lib/style/base-editor.css';
import VMdPreview from '@kangc/v-md-editor/lib/preview';
import '@kangc/v-md-editor/lib/style/preview.css';
import githubTheme from '@kangc/v-md-editor/lib/theme/github.js';
import '@kangc/v-md-editor/lib/theme/style/github.css';
import hljs from 'highlight.js';

import App from './App'
import axios from "axios"
import router from "@/router";
import store from "@/store";
import i18n from "@/i18n"

const app = createApp(App)

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}

VMdEditor.use(githubTheme, {
    hljs: hljs,
});
VMdPreview.use(githubTheme, {
    hljs: hljs,
});

axios.defaults.withCredentials=true

app.use(ElementPlus)
    .use(router)
    .use(store)
    .use(VMdEditor)
    .use(VMdPreview)
    .use(i18n)

app.mount('#app')