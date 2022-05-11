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
import { useI18n } from "vue-i18n";
import { useStore } from "vuex"
import { ElMessageBox } from "element-plus";
import { addMessage } from "@/scripts/utils/messageUtils";
import ArticleEditor from "@/components/article_page/ArticleEditor";

const {t} = useI18n()
const store = useStore()

const editor = ref(null)
const articleDraft = store.getters.getArticleDraft

const handleDeleteButtonClick = () => {
  ElMessageBox
      .confirm(
          t('message.article_editor.new.label_reset_confirm'),
          t('message.message_utils.msg_title_warning'),
          {
            confirmButtonText: t('message.article_editor.new.button_confirm'),
            cancelButtonText: t('message.article_editor.new.button_cancel'),
            type: 'warning',
          }
      )
      .then(() => {
        editor.value.resetCurrentArticle()
        addMessage(t('message.article_editor.new.msg_reset_success'), "success")
      })
      .catch(() => {

      })
}

const handleDraftButtonClick = () => {
  editor.value.draftCurrentArticle()
  addMessage(t('message.article_editor.new.msg_draft_success'), "success")
}

const handleSubmitButtonClick = () => {
  editor.value.addCurrentArticle()
}
</script>

<style scoped>

</style>