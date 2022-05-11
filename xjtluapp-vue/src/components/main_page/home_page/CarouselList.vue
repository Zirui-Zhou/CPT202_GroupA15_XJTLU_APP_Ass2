<template>
  <el-carousel
      height="330px"
      v-loading="isLoading"
      ref="CarouselRef"
      arrow="always"
  >
    <el-carousel-item
        v-for="(item, index) in articleList"
        :key="index"
        @click="linkToArticle(item.id)"
    >
      <el-image
          class="carouselImage"
          :src="item.image"
          fit="contain"
      />
    </el-carousel-item>
  </el-carousel>
</template>

<script setup>
import { onMounted, reactive, ref } from "vue";
import { getArticleList, linkToArticle } from "@/scripts/api/handleArticleApi";

const articleList = reactive([])
const isLoading = ref(true)
const CarouselRef = ref(null)

onMounted(async () => {
  // `push()` needs time
  await articleList.push(...await getArticleList(1, 4))
  CarouselRef.value.setActiveItem(0)
  isLoading.value = false
})
</script>

<style scoped>
.el-carousel__item .carouselImage {
  width: 100%;
  height: 100%;
  cursor: pointer;
}
</style>