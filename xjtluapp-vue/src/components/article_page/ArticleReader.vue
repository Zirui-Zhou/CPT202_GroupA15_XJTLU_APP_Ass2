<template>
  <v-md-preview :text="article.articleContent" style="background-color: white"></v-md-preview>
</template>

<script>
export default {
  name: "ArticleReader"
}
</script>

<script setup>
  import {useRoute} from "vue-router";
  import {onBeforeMount, reactive} from "vue";
  import {getArticle} from "@/components/getArticle";

  const route = useRoute()

  const id = route.query.id
  const article = reactive({articleContent: "Sorry, the context cannot be rendered correctly"})

  onBeforeMount(async () => Object.assign(article, await getArticle(id)))

</script>

<style scoped>

</style>