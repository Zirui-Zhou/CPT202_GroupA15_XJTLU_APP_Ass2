import { createApp } from 'vue'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

import VMdEditor from '@kangc/v-md-editor';
import '@kangc/v-md-editor/lib/style/base-editor.css';
import VMdPreview from '@kangc/v-md-editor/lib/preview';
import '@kangc/v-md-editor/lib/style/preview.css';
import githubTheme from '@kangc/v-md-editor/lib/theme/github.js';
import '@kangc/v-md-editor/lib/theme/style/github.css';
import hljs from 'highlight.js';

import App from './App'
import router from "@/router";
import store from "@/store";

const app = createApp(App)

VMdEditor.use(githubTheme, {
    hljs: hljs,
});
VMdPreview.use(githubTheme, {
    hljs: hljs,
});

app.use(VMdEditor);

app.use(ElementPlus)
    .use(router)
    .use(store)
    .use(VMdEditor)
    .use(VMdPreview)
    .mount('#app')