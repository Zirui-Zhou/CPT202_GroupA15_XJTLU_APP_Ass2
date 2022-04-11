<template>

  <CarouselList/>

  <br/>

  <el-tabs v-model="activeName" class="demo-tabs">
    <el-tab-pane label="News" name="first"></el-tab-pane>
    <el-tab-pane label="University" name="second"></el-tab-pane>
    <el-tab-pane label="Clubs" name="third"></el-tab-pane>
    <el-tab-pane label="Academic" name="fourth"></el-tab-pane>
  </el-tabs>

  <CardGroup/>

</template>

<script>
export default {
  name: "HomePage"
}
</script>

<script setup>
import {ref} from 'vue'
import CardGroup from "@/components/main_page/conmponents/SingleColumnCardList";
import CarouselList from "@/components/main_page/conmponents/CarouselList";

const activeName = ref('first')

</script>

<style scoped>

  .demo-tabs > .el-tabs__content {
    padding: 32px;
    color: #6b778c;
    font-size: 32px;
    font-weight: 600;
  }

  .demo-tabs{
    background-color: white;
  }

</style>