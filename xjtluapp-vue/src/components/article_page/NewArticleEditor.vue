<template>
  <ArticleEditor
      ref="editor"
      :raw-article="articleDraft"
      :handle-delete-button-click="handleDeleteButtonClick"
      :handle-draft-button-click="handleDraftButtonClick"
      :handle-submit-button-click="handleSubmitButtonClick"
  />
</template>

<script setup>
import { ref } from "vue";
import { useStore } from "vuex"
import { ElMessageBox } from "element-plus";
import { addMessage } from "@/scripts/utils/messageUtils";
import ArticleEditor from "@/components/article_page/ArticleEditor";

const store = useStore()

const editor = ref(null)
const articleDraft = store.getters.getArticleDraft

const handleDeleteButtonClick = () => {
  ElMessageBox
      .confirm(
          'Confirm to reset the article?',
          'Warning',
          {
            confirmButtonText: 'OK',
            cancelButtonText: 'Cancel',
            type: 'warning',
          }
      )
      .then(() => {
        editor.value.resetCurrentArticle()
        addMessage("Reset the article successfully", "success")
      })
      .catch(() => {

      })
}

const handleDraftButtonClick = () => {
  editor.value.draftCurrentArticle()
  addMessage("Save the draft successfully", "success")
}

const handleSubmitButtonClick = () => {
  editor.value.addCurrentArticle()
}

</script>

<style scoped>

</style>