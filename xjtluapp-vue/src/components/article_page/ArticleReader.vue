<template>
  <div class="articleReaderContent" v-loading="isLoading">
    <div v-show="!isLoading">
      <ArticleHeader :article="article" :editor-info="editorInfo"/>
      <el-divider class="divider" direction="horizontal"/>
      <v-md-preview :text="article.content" style="background-color: white"></v-md-preview>
    <!--  <ArticleBottom/>-->
      <el-divider class="divider" direction="horizontal"/>
      <ArticleComment/>
      <EditCurrentArticleButton
          v-if="isShowEditButton()"
          :id="article.id"
      />
    </div>
  </div>
</template>

<script setup>
import {useRoute} from "vue-router";
import {computed, onBeforeMount, reactive, ref} from "vue";
import {getEditorInfo} from "@/scripts/api/handleUserApi";
import {getArticle, addHistoryArticle} from "@/scripts/api/handleArticleApi";
import ArticleHeader from "@/components/article_page/ArticleHeader";
import ArticleComment from "@/components/article_page/ArticleComment";
import {delay} from "@/scripts/utils/commonUtils";
import EditCurrentArticleButton from "@/components/EditCurrentArticleButton";
import {useStore} from "vuex";

const route = useRoute()
const store = useStore()

const id = route.query.id
const isLoading = ref(true)
const article = reactive({content: "Sorry, the context cannot be rendered correctly"})
const editorInfo = reactive({})
const userInfo = computed(()=>store.getters.getUserInfo)

const isShowEditButton = () => {
  if(!editorInfo.userId || !userInfo.value.userId)
    return false
  return editorInfo.userId.toString() === userInfo.value.userId.toString()
}

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

.articleReaderContent .el-loading-spinner{
  top: 60%;
  left: 0;
  position: fixed;
}

</style>

<style scoped>

</style>