<template>
  <div style="width: 900px; margin: auto">
    <TopMenu/>
    <br/>
    <ArticleHeader/>
    <br/>
    <ArticleReader/>
    <br/>
    <ArticleComment/>
    <br/>
    <ArticleBottom/>
<!--    <ArticleEditor/>-->
  </div>
  <el-backtop :right="100" :bottom="100" />
</template>

<script setup>
import TopMenu from "@/components/main_page/conmponents/TopMenu";
import ArticleReader from "@/components/article_page/ArticleReader";
// import ArticleEditor from "@/components/article_page/ArticleEditor";
import ArticleComment from "@/components/article_page/ArticleComment";
import ArticleHeader from "@/components/article_page/ArticleHeader";
import ArticleBottom from "@/components/article_page/ArticleBottom";
</script>

<style scoped>

</style>