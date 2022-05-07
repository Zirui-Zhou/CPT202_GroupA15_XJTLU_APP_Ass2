<template>
  <router-view/>
</template>

<script setup>
import {
  enable as enableDarkMode,
  disable as disableDarkMode,
} from 'darkreader';
import {onBeforeMount, watch} from "vue";
import {useStore} from "vuex"
import {useI18n} from "vue-i18n"
import {getAllArticleTypes} from "@/scripts/api/handleArticleApi";
import {getUserInfo} from "@/scripts/api/handleUserApi";

const store = useStore()
const {locale, availableLocales} = useI18n()

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
}

watch(
    ()=>store.getters.getIsDarkMode,
    ()=>changeDarkMode()
)

watch(()=>store.getters.getLang, async ()=>await getAllArticleTypes())

onBeforeMount(()=>{
  changeDarkMode(store.getters.getIsDarkMode)
  changeLang()
})

onBeforeMount(async ()=> {
  await getUserInfo()
  await getAllArticleTypes()
})

</script>