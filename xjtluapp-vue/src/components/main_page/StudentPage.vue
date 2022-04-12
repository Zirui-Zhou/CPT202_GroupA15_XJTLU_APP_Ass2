<template>
  <div>
    <img class="demo-image" src="https://www.xjtlu.edu.cn/zh/assets/image-cache/images/campus/campus005.1f5be76d.jpg">
  </div>

  <UserInfoForm/>

  <div>
    <el-tabs v-model="activeName" class="demo-tabs" >
      <el-tab-pane label="Mine" name="first"></el-tab-pane>
      <el-tab-pane label="History" name="second"></el-tab-pane>
      <el-tab-pane label="Favourite" name="third"></el-tab-pane>
    </el-tabs>
  </div>

  <br/>

  <TimeLineList/>

</template>

<script setup>
import {ref} from "vue";
import TimeLineList from "@/components/main_page/conmponents/TimeLineCardList";
import UserInfoForm from "@/components/main_page/conmponents/UserInfoForm";

const activeName = ref()
</script>

<style scoped>

.demo-image{
  background-color: #4a97fc;
  width: 100%;
  height: 200px;
  text-align: center;
}

</style>