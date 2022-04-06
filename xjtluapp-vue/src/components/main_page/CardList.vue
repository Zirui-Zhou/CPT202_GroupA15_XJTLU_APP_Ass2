<template>
  <div v-for="item in articleList" :key="item.articleId">
    <br/>
    <el-card class="card" @click="clickCard(item.articleId, router)">
      <el-avatar :size="50" :src="item.userAvatar" /> <br/>
      <span>{{item.userName}}</span> <br/>
      <img :src="item.articleImage" alt="xjtlu"/>
      <span>{{item.articleTitle}}</span>
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
  height: 70px
}
.card:hover{
  transform: scale(1.05);
  position: relative;
  z-index: 1;
  transition: 0.5s;

  cursor: pointer;
}
</style>