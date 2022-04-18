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
import {onBeforeMount} from "vue";
import {getAllArticleTypes} from "@/scripts/handleArticleApi";

onBeforeMount(async ()=> {
  await getUserInfo()
  await getAllArticleTypes()
})
</script>

<style scoped>

</style>
