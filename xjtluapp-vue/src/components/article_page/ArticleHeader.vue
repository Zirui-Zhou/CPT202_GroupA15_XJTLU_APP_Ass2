<template>
  <v-md-title :text="title" style="background-color: white"></v-md-title>
  Title
  <div class="text" style="inline-size: auto">
    <el-row >
      <el-col :span="3">Tag</el-col>
      <el-col :span="3">Date</el-col>
      <el-col :span="3">Read</el-col>
      <el-col :span="3">Like</el-col>
      <el-col :span="3">Comment</el-col>
    </el-row>
  </div>
  <el-row class="align-right">
    <AvatarWithCard class="align-right"/>
    <el-descriptions  direction="vertical" :column="1" class="align-right">
      <el-descriptions-item label="Name"></el-descriptions-item>
      <el-descriptions-item label="ArticleNumber"></el-descriptions-item>
    </el-descriptions>
  </el-row>
  <el-divider class="divider" direction="horizontal"/>

</template>

<script setup>
import AvatarWithCard from "@/components/main_page/conmponents/AvatarWithCard";

</script>

<style scoped>

.align-right{
  margin-top: 3%;
  margin-right: auto;
  width: 15%;
  height: 15%;
}

</style>