<template>
  <EditArticleButton
      :handle-click="addArticle"
  />
</template>

<script setup>
import { useRouter } from "vue-router";
import EditArticleButton from "@/components/EditArticleButton";

const router = useRouter()

const addArticle = () => {
  router.push("/article/add")
}
</script>

<style scoped>

</style>