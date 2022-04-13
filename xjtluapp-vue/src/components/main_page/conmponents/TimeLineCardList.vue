<template>
  <el-timeline>

    <SingleColumnCardList
      root-type="el-timeline-item"
      :get-list-func="getArticleListOfFavourite"
      :card-scale="1.03"
      :attrs="{
        center: true,
        placement: 'top',
        style: 'margin-right: 68px'
      }"
    />

  </el-timeline>
</template>

<script setup>
import SingleColumnCardList from "./SingleColumnCardList"
import {getArticleListOfMine, getArticleListOfFavourite} from "@/scripts/handleArticleApi"

</script>

<style scoped>
</style>