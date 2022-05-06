<template>
  <div style="width: 900px; margin: auto">
    <TopMenu/>
    <br/>
    <router-view/>
  </div>
  <BackTopButton/>
</template>

<script setup>
import TopMenu from "@/components/TopMenu";
import {getUserInfo} from "@/scripts/api/handleUserApi";
import {onBeforeMount, watch} from "vue";
import {getAllArticleTypes} from "@/scripts/api/handleArticleApi";
import {useStore} from "vuex"
import BackTopButton from "@/components/BackTopButton";

const store = useStore()

watch(()=>store.getters.getLang, async ()=>await getAllArticleTypes())

onBeforeMount(async ()=> {
  await getUserInfo()
  await getAllArticleTypes()
})
</script>

<style scoped>

</style>
