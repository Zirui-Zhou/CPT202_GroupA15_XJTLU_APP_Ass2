<template>
  <div style="width: 900px; margin: auto">
    <img src="@/assets/xjtlu_banner.svg" style="width: 15%; height: 15%; margin: 10px">
    <TopMenu/>
    <br/>
    <router-view/>
  </div>
</template>

<script>


export default {
  name: "MainPage",
}
</script>

<script setup>
import TopMenu from "@/components/main_page/conmponents/TopMenu";
</script>

<style scoped>

</style>