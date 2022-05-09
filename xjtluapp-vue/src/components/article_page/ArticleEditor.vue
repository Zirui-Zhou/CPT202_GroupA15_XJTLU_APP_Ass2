<template>
  <br/>
  <div class="title">
    <div class="v-md-editor" style="border-bottom: 1px solid #ddd; flex-flow: row wrap;">
      <textarea
          id="textarea"
          v-model="article.title.value"
          spellcheck="false"
          class="titleInput"
          :placeholder="$t('message.article_editor.input_placeholder_title')"
          maxlength="64"
          rows="1"
      />

      <div style="width: 100%; margin: 0 32px 24px 32px;">

        <p>{{ getFormattedTime(editTime) }}</p>

        <ArticleHeaderUserInfo
          :user-info="userInfo"
          :is-link-email="false"
        />

      </div>
    </div>
  </div>

  <div class="content">
    <v-md-editor v-model="article.content.value" height="600px"/>
  </div>

  <br/>
  <h2>
    {{ $t('message.article_editor.label_select_type') }}
  </h2>

  <el-button
      size="large"
      :icon="item.typeIcon"
      :type="item.typeId === article.typeId.value ? 'primary' : 'default'"
      round
      v-for="item in articleTypeList"
      :key="item.typeName"
      @click="article.typeId.value = item.typeId"
  >
    {{ item.typeName }}
  </el-button>

  <br/>
  <h2>
    {{ $t('message.article_editor.label_preview') }}
  </h2>

  <el-card class="card">

    <CardIconList
        :item="item"
        listType="preview"
        :itemFunc="itemFunc"
    />

    <CardArticleInfo
        :item="item"
        :itemFunc="itemFunc"
    >
      <template #image>
        <UploadArticleImage
            :item="item"
            :handle-image="handleImage"
        />
      </template>
    </CardArticleInfo>

    <CardUserInfo
        :item="item"
    />

  </el-card>

  <div style="display: flex; justify-content: flex-end">
    <el-button
        type="danger"
        class="submitButton"
        @click="handleDeleteButtonClick"
        plain
    >
      {{ $t('message.article_editor.button_delete') }}
    </el-button>
    <el-button
        type="default"
        class="submitButton"
        @click="handleDraftButtonClick"
    >
      {{ $t('message.article_editor.button_draft') }}
    </el-button>
    <el-button
        type="primary"
        class="submitButton"
        @click="handleSubmitButtonClick"
    >
      {{ $t('message.article_editor.button_submit') }}
    </el-button>
  </div>

</template>

<script setup>
import {onMounted, ref, computed, reactive, onBeforeMount, defineProps, defineExpose} from "vue";
import {useStore} from "vuex"
import {getFormattedTime} from "@/scripts/utils/commonUtils";
import CardIconList from "@/components/main_page/conmponents/single_card_list/CardIconList";
import CardArticleInfo from "@/components/main_page/conmponents/single_card_list/CardArticleInfo";
import CardUserInfo from "@/components/main_page/conmponents/single_card_list/CardUserInfo";
import {
  addArticle,
  editArticle,
  getAllArticleTypes,
  linkToArticle,
  removeArticle
} from "@/scripts/api/handleArticleApi";
import UploadArticleImage from "@/components/article_page/UploadArticleImage";
import { useRouter } from "vue-router";
import ArticleHeaderUserInfo from "@/components/article_page/ArticleHeaderUserInfo";

const store = useStore()
const router = useRouter()

const userInfo = computed(()=>store.getters.getUserInfo)
const editTime = ref(new Date().getTime())

const article = {
  id: ref(null),
  title: ref(""),
  content: ref(""),
  typeId: ref(1),
  image: ref(null),
}

const articleTypeList = computed(()=>store.getters.getArticleTypeList)

const props = defineProps({
  rawArticle: Object,
  handleDeleteButtonClick: Function,
  handleDraftButtonClick: Function,
  handleSubmitButtonClick: Function,
})

setInterval(() => {
  editTime.value = new Date().getTime()
}, 1000)

const item = reactive({
  id: article.id,
  title: article.title,
  image: article.image,
  typeId: article.typeId,
  createTime: editTime,
  editorName: userInfo.value.realName,
  avatar: userInfo.value.avatar,
  isFavourite: false,
})

const itemFunc = async (item, key, value) => {
  item[key] = value
}

const handleImage = (image) => {
  article.image.value = image
}

const addCurrentArticle = async () => {
  const data = await addArticle(
      article.title.value,
      article.image.value,
      article.content.value,
      article.typeId.value
  )
  linkToArticle(data.id)
}

const editCurrentArticle = async () => {
  await editArticle(
      article.id.value,
      article.title.value,
      article.image.value,
      article.content.value,
      article.typeId.value
  )
  linkToArticle(article.id.value)
}

const draftCurrentArticle = async () => {
  store.commit("SET_ARTICLE_DRAFT", article)
}

const resetCurrentArticle = () => {
  article.title.value = ""
  article.image.value = null
  article.content.value = ""
  article.typeId.value = 1
}

const removeCurrentArticle = async () => {
  await removeArticle(article.id.value)
  router.back()
}

defineExpose({
  addCurrentArticle,
  editCurrentArticle,
  draftCurrentArticle,
  resetCurrentArticle,
  removeCurrentArticle,
})

function preHandleArticle() {
  if(props.rawArticle) {
    if(props.rawArticle.id) {
      article.id.value =props.rawArticle.id
    }
    article.title.value = props.rawArticle.title
    article.content.value = props.rawArticle.content
    article.typeId.value = props.rawArticle.typeId
    article.image.value = props.rawArticle.image
  }
}

onMounted(()=>{
  document.getElementById("textarea").addEventListener("input", function() {
    this.style.height = "inherit";
    this.style.height = `${this.scrollHeight}px`;
  });

  document
      .getElementsByClassName("v-md-textarea-editor")
      .item(0)
      .getElementsByTagName("textarea")
      .item(0)
      .setAttribute("style", "background-color: white")

  window.scrollTo(0,0);

})

onBeforeMount(async ()=>{
  preHandleArticle()
  await getAllArticleTypes()
})

</script>

<style lang="scss">

.title {
  .v-md-editor{
    border-radius: 4px 4px 0 0;
  }
}

.content {
  .v-md-editor{
    box-shadow: 0 8px 10px 0 rgba(0, 0, 0, 0.1);
    border-radius: 0 0 4px 4px;
  }
  .v-md-textarea-editor{
    background-color: white;
  }
}

</style>

<style scoped>
.titleInput{
  width: 100%;
  border: none;
  outline: none;
  resize: none;
  font-size: 2em;
  font-weight: bold;
  font-family: inherit;
  margin: 24px 32px 0 32px;
  overflow-y: hidden;
  background-color: white;
}

.submitButton{
  width: 130px;
  font-size: 20px;
  padding: 20px;
  margin: 32px 32px 32px 0;
}

.card{
  position: relative;
  height: 200px;
}

.card:hover{
  transform: scale(1.03);
  position: relative;
  z-index: 1;
  transition: 0.5s;

  cursor: pointer;
}

</style>