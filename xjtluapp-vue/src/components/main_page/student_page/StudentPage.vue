<template>
  <el-image
      class="backgroundImage"
      :src="require('@/assets/student_background.jpg')"
  />

  <UserInfoForm/>

  <el-tabs v-model="activeTab">
    <el-tab-pane :label="$t('message.student_page.tab_item_mine')" name="mine"/>
    <el-tab-pane :label="$t('message.student_page.tab_item_history')" name="history"/>
    <el-tab-pane :label="$t('message.student_page.tab_item_favourite')" name="favourite"/>
  </el-tabs>

  <br/>

  <TimeLineList
      :key="activeTab"
      :list-type="activeTab"
  />

  <AddNewArticleButton/>

</template>

<script setup>
import { ref } from "vue";
import TimeLineList from "@/components/main_page/conmponents/single_card_list/TimeLineCardList";
import UserInfoForm from "@/components/main_page/student_page/UserInfoForm";
import AddNewArticleButton from "@/components/AddNewArticleButton";

const activeTab = ref("mine")

</script>

<style scoped>
.backgroundImage {
  width: 100%;
  height: 200px;
  text-align: center;
}
</style>