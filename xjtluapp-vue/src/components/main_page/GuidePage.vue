<template>

  <el-carousel height="330px">
    <el-carousel-item v-for="item in articleList" :key="item.articleId" @click="clickCard(item.articleId)">
      <img :src="item.articleImage" style="width: 100%; height: 100%;" class="image">
    </el-carousel-item>
  </el-carousel>

  <br/>

  <el-tabs v-model="activeName" class="demo-tabs" @tab-click="handleClick">
    <el-tab-pane label="News" name="first"></el-tab-pane>
    <el-tab-pane label="University" name="second"></el-tab-pane>
    <el-tab-pane label="Clubs" name="third"></el-tab-pane>
    <el-tab-pane label="Academic" name="fourth"></el-tab-pane>
  </el-tabs>

  <CardGroup/>

</template>

<script>
export default {
  name: "MainPage"
}
</script>

<script setup>
import {reactive, ref, onMounted} from 'vue'
import {useRouter} from "vue-router";
import CardGroup from "@/components/main_page/CardList";
import axios from "axios";
import {ElMessage} from "element-plus";

const router = useRouter()

const activeName = ref('first')
const articleList = reactive([])

const clickCard = (id) => {
  router.push({path: '/article',
    query:{id: id}
  })
}

const getArticleList = (from, to) => {
  axios.post("http://localhost:8081/articlelist", {fromIndex: from, articleNum: to}).then(res => {
    const article = res.data.data
    articleList.push(...article)
    ElMessage({
      message: 'Get the articles',
      type: 'success',
    })
  }).catch(error => {
    ElMessage({
      message: error.response.data.msg,
      type: 'error',
    })
  })
}

onMounted(() => getArticleList(1, 4))

// const imgList = [
//   {id:1, idView:require('@/assets/carousel/carousel1.png')},
//   {id:2, idView:require('@/assets/carousel/carousel2.png')},
//   {id:3, idView:require('@/assets/carousel/carousel3.png')},
//   {id:4, idView:require('@/assets/carousel/carousel4.png')}
// ]

</script>

<style scoped>
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 500px;
    margin: 10px;
    text-align: center;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n + 1) {
    background-color: #d3dce6;
  }

  .demo-tabs > .el-tabs__content {
    padding: 32px;
    color: #6b778c;
    font-size: 32px;
    font-weight: 600;
  }

  .demo-tabs{
    background-color: white;
  }

</style>