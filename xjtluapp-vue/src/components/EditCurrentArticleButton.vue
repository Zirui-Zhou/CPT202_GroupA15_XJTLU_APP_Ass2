<template>
  <EditArticleButton
      :handle-click="editArticle"
  />
</template>

<script setup>
import { defineProps } from "vue";
import { linkToEditArticle } from "@/scripts/api/handleArticleApi";
import EditArticleButton from "@/components/EditArticleButton";

const props = defineProps({
  id: Object
})

const editArticle = () => {
  linkToEditArticle(props.id)
}
</script>

<style scoped>

</style>