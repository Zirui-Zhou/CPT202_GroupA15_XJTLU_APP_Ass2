<template>
  <el-carousel height="330px" v-if="articleList.length > 0">
    <el-carousel-item
        v-for="(item, index) in articleList"
        :key="index"
        @click="clickCard(item.articleId)"
        onmouseover="" style="cursor: pointer;"
    >
      <img :src="item.articleImage" style="width: 100%; height: 100%;" class="image">
    </el-carousel-item>
  </el-carousel>
</template>

<script>
export default {
  name: "CarouselList"
}
</script>

<script setup>
import {onMounted, reactive} from "vue";
import {getArticleList, clickCard} from "@/components/getArticle";

let articleList = reactive([])

onMounted(async () => {
  articleList.push(...await getArticleList(1, 4))
})
</script>

<style scoped>
/*.el-carousel__item h3 {*/
/*  color: #475669;*/
/*  font-size: 14px;*/
/*  opacity: 0.75;*/
/*  line-height: 500px;*/
/*  margin: 10px;*/
/*  text-align: center;*/
/*}*/

/*.el-carousel__item:nth-child(2n) {*/
/*  background-color: #99a9bf;*/
/*}*/

/*.el-carousel__item:nth-child(2n + 1) {*/
/*  background-color: #d3dce6;*/
/*}*/

el-carousel:hover{
  cursor: pointer;
}

</style>