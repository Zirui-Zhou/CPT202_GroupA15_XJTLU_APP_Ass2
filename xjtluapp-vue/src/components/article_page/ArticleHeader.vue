<template>
  <div style="margin-left: 32px">

    <h1>{{ article.title }}</h1>
    <p>{{ getFormattedTime(article.createTime) }}</p>

    <ArticleHeaderUserInfo
      :user-info="editorInfo"
      :is-link-email="true"
    />

  </div>
</template>

<script setup>
import {defineProps} from "vue";
import {getFormattedTime} from "@/scripts/utils/commonUtils";
import ArticleHeaderUserInfo from "@/components/article_page/ArticleHeaderUserInfo";

const props = defineProps({
  article: Object,
  editorInfo: Object,
})

</script>

<style scoped>



</style>