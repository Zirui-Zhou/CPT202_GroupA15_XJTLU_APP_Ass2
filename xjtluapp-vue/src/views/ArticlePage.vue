<template>
  <div style="width: 900px; margin: auto">
    <img src="@/assets/xjtlu_banner.svg" style="width: 15%; height: 15%">
    <TopMenu/>
    <br/>
    <ArticleReader/>
    <ArticleEditor/>
  </div>
</template>

<script>
export default {
  name: "ActiclePage"
}
</script>

<script setup>
import TopMenu from "@/components/main_page/TopMenu";
import ArticleReader from "@/components/article_page/ArticleReader";
import ArticleEditor from "@/components/article_page/ArticleEditor";
</script>

<style scoped>

</style>