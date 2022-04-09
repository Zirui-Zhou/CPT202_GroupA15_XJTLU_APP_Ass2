<template>
  <el-timeline>

    <SingleColumnCardList
      root-type="el-timeline-item"
      :get-list-func="getArticleListOfMine"
      :card-scale="1.03"
      :attrs="{
        center: true,
        placement: 'top',
        style: 'margin-right: 68px'
      }"
    />

  </el-timeline>
</template>

<script>
export default {
  name: "TimeLineList"
}
</script>

<script setup>
import SingleColumnCardList from "./SingleColumnCardList"
import {getArticleListOfMine} from "@/components/handleArticle"

</script>

<style scoped>
</style>