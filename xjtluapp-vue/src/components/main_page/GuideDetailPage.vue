<template>

  <GuideDetailList :type="type"/>

</template>

<script setup>
import GuideDetailList from "@/components/main_page/conmponents/multiple_card_list/GuideDetailList";
import {useRoute} from "vue-router"

const route = useRoute()

const type = parseInt(route.query.type.toString())

</script>

<style scoped>

</style>