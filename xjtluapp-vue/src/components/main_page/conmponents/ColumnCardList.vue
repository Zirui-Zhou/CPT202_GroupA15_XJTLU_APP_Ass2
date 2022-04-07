<template>
  <div v-for="item in articleList" :key="item.articleId">
    <br/>
    <el-card class="card" style="position:relative" @click="clickCard(item.articleId, router)">
      <div style="display: inline-block;">
        <h3 style="margin-top: 0">{{item.articleTitle}}</h3>
        <img :src="item.articleImage" alt="xjtlu"/>
      </div>
      <div style="display: inline-block; position:absolute; right: 20px; bottom: 20px">
        <el-avatar :size="50" :src="item.userAvatar" style="margin: auto;  display: block;"/>
        <span>{{item.userName}}</span>
        <span>&nbsp;2022.4.7</span>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "CardList"
}
</script>

<script setup>
  import {onBeforeMount, reactive} from "vue";
  import {getArticleList, clickCard} from "@/components/getArticle";

  const articleList = reactive([])

  onBeforeMount(async () => articleList.push(...await getArticleList(1, 5)))
</script>

<style scoped>
img{
  height: 100px
}
.card:hover{
  transform: scale(1.05);
  position: relative;
  z-index: 1;
  transition: 0.5s;

  cursor: pointer;
}
</style>