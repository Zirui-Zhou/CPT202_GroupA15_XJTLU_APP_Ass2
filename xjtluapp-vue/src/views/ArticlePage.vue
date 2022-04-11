<template>
  <div style="width: 900px; margin: auto">
    <img src="@/assets/xjtlu_banner.svg" style="width: 15%; height: 15%; margin: 10px">
    <TopMenu/>
    <br/>
    <ArticleReader/>
<!--    <ArticleEditor/>-->
  </div>
  <el-backtop :right="100" :bottom="100" />
</template>

<script>
export default {
  name: "ArticlePage"
}
</script>

<script setup>
import TopMenu from "@/components/main_page/conmponents/TopMenu";
import ArticleReader from "@/components/article_page/ArticleReader";
import ArticleEditor from "@/components/article_page/ArticleEditor";
</script>

<style scoped>

</style>