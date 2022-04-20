<template>
  <div style="width: 900px; margin: auto">
    <TopMenu/>
    <br/>
    <router-view/>
  </div>
  <el-backtop :right="100" :bottom="100" />
</template>

<script setup>
import TopMenu from "@/components/TopMenu";
import {getUserInfo} from "@/scripts/handleUserApi";
import {onBeforeMount, watch} from "vue";
import {getAllArticleTypes} from "@/scripts/handleArticleApi";
import {useStore} from "vuex"

const store = useStore()

watch(()=>store.getters.getLang, async ()=>await getAllArticleTypes())

onBeforeMount(async ()=> {
  await getUserInfo()
  await getAllArticleTypes()
})
</script>

<style scoped>

</style>
