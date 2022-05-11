<template>
  <el-timeline>
    <SingleColumnCardList
      rootType="el-timeline-item"
      :listType="listType"
      :cardScale="1.03"
      :attrs="{
        center: true,
        placement: 'top',
        style: 'margin-right: 68px'
      }"
    />
  </el-timeline>
</template>

<script setup>
import { defineProps } from "vue";
import SingleColumnCardList from "./SingleColumnCardList"

defineProps({
  listType: String,
})
</script>

<style scoped>

</style>