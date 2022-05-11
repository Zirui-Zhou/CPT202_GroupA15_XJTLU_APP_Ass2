<template>

  <GuideDetailList :type="type"/>

</template>

<script setup>
import { useRoute } from "vue-router"
import GuideDetailList from "@/components/main_page/guide_page/GuideDetailList";

const route = useRoute()

const type = parseInt(route.query.type.toString())
</script>

<style scoped>

</style>