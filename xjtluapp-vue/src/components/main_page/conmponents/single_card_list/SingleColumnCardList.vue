<template>
  <component
      :is="rootType"
      v-bind="attrs"
      v-for="item in articleList"
      :key="item.id"
      :timestamp="getFormattedTime(item.createTime)"
  >
    <br/>
    <el-card
        class="card"
        :class="{cardRemove: item.isRemoving}"
        @click="linkToArticle(item.id)"
    >

      <CardIconList
          :item="item"
          :listType="listType"
          :removeFunc="removeArticle"
          :itemFunc="itemFunc"
      />

      <CardArticleInfo
          :item="item"
          :itemFunc="itemFunc"
      />

      <CardUserInfo
          :item="item"
      />

    </el-card>
  </component>

  <component
      :is="rootType"
      v-bind="attrs"
  >
    <br/>
    <el-card
        v-loading="true"
        v-show="isLoading"
        class="card"
    />
    <el-card
        v-show="isNothing"
        class="card nothingCard"
    >
      <h1>There is nothing below.</h1>
    </el-card>
  </component>
</template>

<script setup>
  import {onMounted, reactive, ref, defineProps} from "vue";
  import {
    getArticleList,
    getArticleListOfFavourite,
    getArticleListOfHistory,
    getArticleListOfMine, getArticleListOfSearch,
    getArticleListOfType,
    linkToArticle
  } from "@/scripts/handleArticleApi";
  import moment from "moment"
  import {delay} from "@/scripts/commonUtils";
  import CardIconList from "@/components/main_page/conmponents/single_card_list/CardIconList";
  import CardArticleInfo from "@/components/main_page/conmponents/single_card_list/CardArticleInfo";
  import CardUserInfo from "@/components/main_page/conmponents/single_card_list/CardUserInfo";

  const articleList = reactive([])
  const currentPage = ref(0)
  const sizePage = 4
  const isLoading = ref(false)
  const isNothing = ref(false)

  const props = defineProps({
    rootType: {
      type: String,
      default: "div",
    },
    listType: {
      type: String,
      default: "common",
    },
    listFuncParam: {
      type: Object,
      default: () => {return []}
    },
    cardScale: {
      type: Number,
      default: 1.05
    },
    attrs: {
      type: Object,
      default: () => {}
    }
  })

  const listTypeList = {
    common: {
      func: getArticleList
    },
    mine: {
      func: getArticleListOfMine
    },
    favourite: {
      func: getArticleListOfFavourite
    },
    history: {
      func: getArticleListOfHistory
    },
    type: {
      func: getArticleListOfType
    },
    search: {
      func: getArticleListOfSearch
    }
  }

  const loadNewArticle = async () => {
    isLoading.value = true

    await delay(800)

    const result = await listTypeList[props.listType].func(currentPage.value + 1, sizePage, ...props.listFuncParam)
    if(result.length === 0) {
      isNothing.value = true
      isLoading.value = false
      return
    }
    currentPage.value++
    result.forEach((item) => Object.assign(item, {isLoading: true, isRemoving: false}))
    articleList.push(...result)
    isLoading.value = false
    if(result.length < sizePage) {
      isNothing.value = true
    }
  }

  const removeArticle = async (item) => {
    item.isRemoving = true
    await delay(500)
    articleList.splice(articleList.indexOf(item), 1)
  }

  const itemFunc = async (item, key, value) => {
    item[key] = value
  }

  const getFormattedTime = (time) => {
    return moment(time).format('YYYY-MM-DD HH:mm:ss')
  }

  window.onscroll = async () => {
    if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight && !isLoading.value && !isNothing.value) {
      await loadNewArticle()
    }
  }

  onMounted(async () => loadNewArticle())
</script>

<style scoped>
.card{
  position: relative;
  height: 200px;
}

.card:hover{
  transform: scale(v-bind(cardScale));
  position: relative;
  z-index: 1;
  transition: 0.5s;

  cursor: pointer;
}

.cardRemove{
  opacity: 0;
  transition: opacity 0.5s;
}

.nothingCard{
  display: flex;
  align-items: center;
  justify-content: center
}

</style>