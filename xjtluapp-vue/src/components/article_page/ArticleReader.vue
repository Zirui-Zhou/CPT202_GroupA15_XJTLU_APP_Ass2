<template>
  <div class="articleContent" v-loading="isLoading">
    <div v-show="!isLoading">
      <ArticleHeader :article="article" :editor-info="editorInfo"/>
      <el-divider class="divider" direction="horizontal"/>
      <v-md-preview :text="article.content" style="background-color: white"></v-md-preview>
    <!--  <ArticleBottom/>-->
      <el-divider class="divider" direction="horizontal"/>
      <ArticleComment/>
    </div>
  </div>
</template>

<script setup>
  import {useRoute} from "vue-router";
  import {onBeforeMount, reactive, ref} from "vue";
  import {getEditorInfo} from "@/scripts/api/handleUserApi";
  import {getArticle, addHistoryArticle} from "@/scripts/api/handleArticleApi";
  import ArticleHeader from "@/components/article_page/ArticleHeader";
  import ArticleComment from "@/components/article_page/ArticleComment";
  import {delay} from "@/scripts/utils/commonUtils";

  const route = useRoute()

  const id = route.query.id
  const isLoading = ref(true)
  const article = reactive({content: "Sorry, the context cannot be rendered correctly"})
  const editorInfo = reactive({})

  onBeforeMount(async () => {
    isLoading.value = true
    Object.assign(article, await getArticle(id))
    Object.assign(editorInfo, await getEditorInfo(article.editorId))
    await delay(500)
    isLoading.value = false
    await addHistoryArticle(id)
  })

</script>

<style>

/* Attention: the style here is not scoped to overwrite the spinner style */

.articleContent .el-loading-spinner{
  top: 60%;
  left: 0;
  position: fixed;
}

</style>

<style scoped>

</style>