<template>
  <router-view/>
</template>

<script>
export default {
  name: 'App',
  mounted(){
    document.body.style.backgroundColor = "#ffffff"
  },
}
</script>

<script setup>
import {
  enable as enableDarkMode,
  disable as disableDarkMode,
} from 'darkreader';
import {onBeforeMount, watch} from "vue";
import {useStore} from "vuex"
import {useI18n} from "vue-i18n"

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
    changeDarkMode
)

onBeforeMount(()=>{
  changeDarkMode(store.getters.getIsDarkMode)
  changeLang()
})

</script>