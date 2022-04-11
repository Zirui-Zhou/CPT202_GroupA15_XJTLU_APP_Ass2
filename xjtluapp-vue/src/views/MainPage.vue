<template>
  <div style="width: 900px; margin: auto">
    <img src="@/assets/xjtlu_banner.svg" style="width: 15%; height: 15%; margin: 10px">
    <TopMenu/>
    <br/>
    <router-view/>
  </div>
  <el-backtop :right="100" :bottom="100" />
</template>

<script>


export default {
  name: "MainPage",
}
</script>

<script setup>
import TopMenu from "@/components/main_page/conmponents/TopMenu";
import {getUserInfo} from "@/components/handleUser";
import {onBeforeMount} from "vue";

onBeforeMount(async ()=> await getUserInfo())

</script>

<style scoped>

</style>
