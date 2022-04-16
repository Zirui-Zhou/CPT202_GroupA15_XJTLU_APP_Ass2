<template>
  <div>
    <img class="demo-image" src="https://www.xjtlu.edu.cn/zh/assets/image-cache/images/campus/campus005.1f5be76d.jpg">
  </div>

  <UserInfoForm/>

  <div>
    <el-tabs v-model="activeTab" class="demo-tabs" >
      <el-tab-pane label="Mine" name="mine"></el-tab-pane>
      <el-tab-pane label="History" name="history"></el-tab-pane>
      <el-tab-pane label="Favourite" name="favourite"></el-tab-pane>
    </el-tabs>
  </div>

  <br/>

  <TimeLineList :key="activeTab" :list-type="activeTab"/>

</template>

<script setup>
import {ref} from "vue";
import TimeLineList from "@/components/main_page/conmponents/single_card_list/TimeLineCardList";
import UserInfoForm from "@/components/main_page/conmponents/UserInfoForm";

const activeTab = ref("mine")

</script>

<style scoped>

.demo-image{
  background-color: #4a97fc;
  width: 100%;
  height: 200px;
  text-align: center;
}

</style>