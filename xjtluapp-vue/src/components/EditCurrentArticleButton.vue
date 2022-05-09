<template>
  <EditArticleButton
      :handle-click="editArticle"
  />
</template>

<script setup>
import { defineProps } from "vue";
import EditArticleButton from "@/components/EditArticleButton";
import {linkToEditArticle} from "@/scripts/api/handleArticleApi";

const props = defineProps({
  id: Object
})

const editArticle = () => {
  linkToEditArticle(props.id)
}
</script>

<style scoped>

</style>