<template>
  <el-carousel height="330px" v-loading="isLoading" ref="carousel">
    <el-carousel-item
        v-for="(item, index) in articleList"
        :key="index"
        @click="clickCard(item.id)"
        onmouseover="" style="cursor: pointer;"
    >

      <h3>{{item.title}}</h3>
      <img :src="item.image" style="width: 100%; height: 100%; object-fit: contain" class="image">
    </el-carousel-item>
  </el-carousel>
</template>

<script>
export default {
  name: "CarouselList"
}
</script>

<script setup>
import {onMounted, reactive, ref} from "vue";
import {getArticleList, clickCard} from "@/components/handleArticle";

const articleList = reactive([])
const isLoading = ref(true)
const carousel = ref(null)

onMounted(async () => {
  // `push()` needs time
  await articleList.push(...await getArticleList(1, 4))
  carousel.value.setActiveItem(0)
  isLoading.value = false
})
</script>

<style scoped>
.el-carousel__item h3 {

  /*opacity: 1;*/
  line-height: 450px;
  position: absolute;
  left: 50%;
  transform: translateX(-50%);

  text-shadow: 3px 3px 0 black;
  color: white;
  font-size: 30px;
}

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