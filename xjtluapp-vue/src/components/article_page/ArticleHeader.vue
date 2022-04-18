<template>
  <div style="margin-left: 32px">
    <h1>
      {{ article.title }}
    </h1>
    <span>
      {{ getFormattedTime(article.createTime) }}
    </span>
    <br/><br/>
  <!--  <div class="text" style="inline-size: auto">-->
  <!--    <el-row >-->
  <!--      <el-col :span="3">Tag</el-col>-->
  <!--      <el-col :span="3">Date</el-col>-->
  <!--      <el-col :span="3">Read</el-col>-->
  <!--      <el-col :span="3">Like</el-col>-->
  <!--      <el-col :span="3">Comment</el-col>-->
  <!--    </el-row>-->
  <!--  </div>-->
    <el-row>

      <AvatarWithCard
          :user-info="editorInfo"
      />

      <div style="margin-left: 20px">
        <span class="name">
          {{ editorInfo.realName }}
        </span>
        <span class="email" @click="handleEmailClick">
          {{ editorInfo.email }}
        </span>
      </div>

    </el-row>

  <!--    <el-descriptions  direction="vertical" :column="1" class="align-right">-->
  <!--      <el-descriptions-item label="Name"></el-descriptions-item>-->
  <!--      <el-descriptions-item label="ArticleNumber"></el-descriptions-item>-->
  <!--    </el-descriptions>-->
  </div>
</template>

<script setup>
import {defineProps} from "vue";
import AvatarWithCard from "@/components/AvatarWithCard";
import {getFormattedTime} from "@/scripts/commonUtils";

const props = defineProps({
  article: Object,
  editorInfo: Object,
})

const handleEmailClick = () => {
  window.open("mailto:" + props.editorInfo.email)
}

</script>

<style scoped>

.name{
  position: absolute;
  top: 0;
  font-weight: bold;
  font-size: 20px
}

.email{
  position: absolute;
  bottom: 0;
}

.email:hover{
  color: var(--el-color-primary-light-3);
  cursor: pointer;
}

</style>