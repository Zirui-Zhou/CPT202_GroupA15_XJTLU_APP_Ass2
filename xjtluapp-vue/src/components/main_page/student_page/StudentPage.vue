<template>
  <div>
    <img class="demo-image" src="https://www.xjtlu.edu.cn/zh/assets/image-cache/images/campus/campus005.1f5be76d.jpg">
  </div>

  <UserInfoForm/>

  <div>
    <el-tabs v-model="activeTab">
      <el-tab-pane :label="$t('message.student_page.tab_item_mine')" name="mine"/>
      <el-tab-pane :label="$t('message.student_page.tab_item_history')" name="history"/>
      <el-tab-pane :label="$t('message.student_page.tab_item_favourite')" name="favourite"/>
    </el-tabs>
  </div>

  <br/>

  <TimeLineList :key="activeTab" :list-type="activeTab"/>

  <NewArticleButton/>

</template>

<script setup>
import {ref} from "vue";
import TimeLineList from "@/components/main_page/conmponents/single_card_list/TimeLineCardList";
import UserInfoForm from "@/components/main_page/student_page/UserInfoForm";
import NewArticleButton from "@/components/NewArticleButton";

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