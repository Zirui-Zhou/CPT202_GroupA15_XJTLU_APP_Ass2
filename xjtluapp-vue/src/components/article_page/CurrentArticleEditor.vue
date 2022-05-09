<template>

  <div class="articleCurrentEditorContent" v-loading="isLoading">
    <div v-if="!isLoading">
      <ArticleEditor
          ref="articleEditor"
          :raw-article="rawArticle"
          :handle-delete-button-click="handleDeleteButtonClick"
          :handle-draft-button-click="handleDraftButtonClick"
          :handle-submit-button-click="handleSubmitButtonClick"
      />
    </div>
  </div>

</template>

<script setup>
import ArticleEditor from "@/components/article_page/ArticleEditor"
import { ElMessageBox } from "element-plus";
import { addMessage } from "@/scripts/utils/messageUtils";
import { getArticle } from "@/scripts/api/handleArticleApi";
import { useRoute } from "vue-router"
import { ref, onBeforeMount, reactive } from "vue";
import { delay } from "@/scripts/utils/commonUtils";
import { useI18n } from "vue-i18n";

const route = useRoute()
const {t} = useI18n()

const id = route.query.id
const articleEditor = ref(null)
const rawArticle = reactive({})
const isLoading = ref(true)

const handleDeleteButtonClick = () => {
  ElMessageBox
      .confirm(
          t('message.article_editor.current.label_delete_confirm'),
          t('message.message_utils.msg_title_warning'),
          {
            confirmButtonText: t('message.article_editor.current.button_confirm'),
            cancelButtonText: t('message.article_editor.current.button_cancel'),
            type: 'warning',
          }
      )
      .then(() => {
        articleEditor.value.removeCurrentArticle()
      })
      .catch(() => {

      })
}

const handleDraftButtonClick = () => {
  addMessage(t('message.article_editor.current.msg_draft_warn'), "warning")
}

const handleSubmitButtonClick = () => {
  articleEditor.value.editCurrentArticle()
}

onBeforeMount(async ()=>{
  isLoading.value = true
  Object.assign(rawArticle, await getArticle(id))
  await delay(500)
  isLoading.value = false
})

</script>

<style>
.articleCurrentEditorContent .el-loading-spinner{
  top: 60%;
  left: 0;
  position: fixed;
}
</style>

<style scoped>

</style>