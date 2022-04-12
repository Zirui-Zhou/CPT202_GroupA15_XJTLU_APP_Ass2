<template>
  <div style="width: 900px; margin: auto">
    <TopMenu/>
    <br/>
    <router-view/>
  </div>
  <el-backtop :right="100" :bottom="100" />
</template>

<script setup>
import TopMenu from "@/components/main_page/conmponents/TopMenu";
import {getUserInfo} from "@/scripts/handleUserApi";
import {onBeforeMount} from "vue";

onBeforeMount(async ()=> await getUserInfo())
</script>

<style scoped>

</style>
