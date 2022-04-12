<template>
  <div style="width: 900px; margin: auto">
    <TopMenu/>
    <br/>
    <ArticleReader/>
<!--    <ArticleEditor/>-->
  </div>
  <el-backtop :right="100" :bottom="100" />
</template>

<script setup>
import TopMenu from "@/components/main_page/conmponents/TopMenu";
import ArticleReader from "@/components/article_page/ArticleReader";
// import ArticleEditor from "@/components/article_page/ArticleEditor";
</script>

<style scoped>

</style>