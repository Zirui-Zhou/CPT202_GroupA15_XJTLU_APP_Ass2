<template>

  <el-carousel height="330px">
    <el-carousel-item v-for="item in imgList" :key="item.id">
      <img :src="item.idView" style="width: 100%; height: 100%;" class="image">
    </el-carousel-item>
  </el-carousel>

  <br/>

  <el-tabs v-model="activeName" class="demo-tabs" @tab-click="handleClick">
    <el-tab-pane label="News" name="first"></el-tab-pane>
    <el-tab-pane label="University" name="second"></el-tab-pane>
    <el-tab-pane label="Clubs" name="third"></el-tab-pane>
    <el-tab-pane label="Academic" name="fourth"></el-tab-pane>
  </el-tabs>

  <div v-for="item in 4" :key="item">
    <br/>
    <el-card>
      <el-avatar :size="50" src="https://pic1.zhimg.com/v2-bf0480b6b8fbcada9095412e3de0a7c3_is.jpg?source=32738c0c" />
      <img src="../../assets/xjtlu_icon.png" alt="xjtlu"/>
      <h4>index {{item}}</h4>
      <p>Tom committed 2018/4/12 20:46</p>
    </el-card>
  </div>

</template>

<script>
export default {
  name: "MainPage"
}
</script>

<script setup>
import { ref } from 'vue'

const activeName = ref('first')

const imgList = [
  {id:1, idView:require('@/assets/carousel/carousel1.png')},
  {id:2, idView:require('@/assets/carousel/carousel2.png')},
  {id:3, idView:require('@/assets/carousel/carousel3.png')},
  {id:4, idView:require('@/assets/carousel/carousel4.png')}
]

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