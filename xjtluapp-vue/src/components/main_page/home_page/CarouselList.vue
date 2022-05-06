<template>
  <el-carousel
      height="330px"
      v-loading="isLoading"
      ref="carousel"
      arrow="always"
  >
    <el-carousel-item
        v-for="(item, index) in articleList"
        :key="index"
        @click="linkToArticle(item.id)"
    >
<!--      <h3>{{item.title}}</h3>-->
      <img :src="item.image">
    </el-carousel-item>
  </el-carousel>
</template>

<script setup>
import {onMounted, reactive, ref} from "vue";
import {getArticleList, linkToArticle} from "@/scripts/api/handleArticleApi";

const articleList = reactive([])
const isLoading = ref(true)
const carousel = ref(null)

onMounted(async () => {
  // `push()` needs time
  await articleList.push(...await getArticleList(1, 4))
  if(articleList.length > 0) {
    carousel.value.setActiveItem(0)
  }
  isLoading.value = false
})
</script>

<style scoped>
.el-carousel__item img {
  width: 100%;
  height: 100%;
  object-fit: contain;
  cursor: pointer;
}

.el-carousel__item h3 {
  line-height: 450px;
  position: absolute;
  left: 50%;
  transform: translateX(-50%);

  text-shadow: 3px 3px 0 black;
  color: white;
  font-size: 30px;
}

</style>