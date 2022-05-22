<template>
  <router-view/>
</template>

<script setup>
import { onBeforeMount, watch } from "vue";
import { useStore } from "vuex"
import { useI18n } from "vue-i18n"
import {
  enable as enableDarkMode,
  disable as disableDarkMode,
} from 'darkreader';
import { getAllArticleTypes } from "@/scripts/api/handleArticleApi";
import { getUserInfo } from "@/scripts/api/handleUserApi";
import VMdEditor from '@kangc/v-md-editor';

const store = useStore()
const {locale, availableLocales} = useI18n()

const VMdEditorLang = {}
const files = require.context('@kangc/v-md-editor/lib/lang/', false, /\.\/.+\.js$/)

files.keys().forEach(file => {
  const moduleName = file.replace(/(^\.\/)|(.js$)/g, '');
  VMdEditorLang[moduleName] = files(file).default || files(file);
});

const changeDarkMode = (isDarkMode)=>{
  if(isDarkMode){
    enableDarkMode();
  }else{
    disableDarkMode()
  }
}

const changeLang = () => {
  const lang = store.getters.getLang
  if(availableLocales.indexOf(lang) !== -1) {
    locale.value = lang
  }
  if(Object.keys(VMdEditorLang).indexOf(lang) !== -1) {
    VMdEditor.lang.use(lang, VMdEditorLang[lang]);
  } else {
    VMdEditor.lang.use("en-US", VMdEditorLang["en-US"]);
  }
}

watch(
    ()=>store.getters.getIsDarkMode,
    changeDarkMode
)

watch(()=>store.getters.getLang, async ()=> {
  changeLang()
  await getAllArticleTypes()
})

onBeforeMount(async ()=> {
  changeDarkMode(store.getters.getIsDarkMode)
  changeLang()
  await getUserInfo()
  await getAllArticleTypes()
})

</script>