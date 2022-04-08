<template>
  <div v-for="item in articleList" :key="item.id">
    <br/>
    <el-card class="card" @click="clickCard(item.id)">
      <div style="display: inline-block;">
        <h3 style="margin-top: 0">{{item.title}}</h3>
        <img :src="item.image" alt="xjtlu"/>
      </div>
      <div style="display: inline-block; position:absolute; right: 20px; bottom: 20px">
        <el-avatar :size="50" :src="item.avatar" style="margin: auto;  display: block;"/>
        <span>{{item.userName}}</span>
        <span>&nbsp;2022.4.7</span>
      </div>
    </el-card>
  </div>

  <br/>
  <el-card v-loading="true" v-show="isLoading" class="card"/>
  <el-card v-show="isNothing" class="card" style="text-align: center">
    <h2>There is nothing below.</h2>
  </el-card>

</template>

<script>
export default {
  name: "CardList"
}
</script>



<script setup>
import {onBeforeMount, reactive, ref} from "vue";
  import {getArticleList, clickCard} from "@/components/getArticle";

  const articleList = reactive([])
  const currentPage = ref(1)
  const sizePage = ref(4)
  const isLoading = ref(false)
  const isNothing = ref(false)

  const delay = ms => new Promise(res => setTimeout(res, ms))

  const loadNewArticle = async () => {
    if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight && !isLoading.value && !isNothing.value) {
      isLoading.value = true
      await delay(2000)
      const result = await getArticleList(currentPage.value + 1, sizePage.value)
      if(result.length === 0) {
        isNothing.value = true
      }
      currentPage.value++
      articleList.push(...result)
      isLoading.value = false
    }
  }

  window.onscroll = async (event) => {
    await loadNewArticle()
  }


  onBeforeMount(async () => articleList.push(...await getArticleList(currentPage.value, sizePage.value)))

</script>

<style scoped>
img{
  height: 110px
}

.card{
  position: relative;
  height: 200px
}

.card:hover{
  transform: scale(1.05);
  position: relative;
  z-index: 1;
  transition: 0.5s;

  cursor: pointer;
}
</style>