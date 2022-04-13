<template>
  <component
      :is="rootType"
      v-bind="attrs"
      v-for="item in articleList"
      :key="item.id"
      :timestamp="getFormattedTime(item.createTime)"
  >
    <br/>
    <el-card class="card" @click="linkToArticle(item.id)">

      <div class="iconList">
        <el-icon
            class="icon"
            :class="{'iconFilled': item.isFavourite}"
            :size="30"
            @click.stop="clickStarIcon(item, item.id)">
          <Star/>
        </el-icon>

        <el-icon class="icon" :size="30" @click.stop="clickLinkIcon(item.id)">
          <Link/>
        </el-icon>
      </div>

      <div style="display: inline-block;">
        <h3 style="margin-top: 0">{{item.title}}</h3>
        <el-image class="img" v-if="item.isLoading" v-loading="true">
          <template #error><div/></template>
        </el-image>
        <el-image
            class="img"
            style="object-fit: cover"
            v-show="!item.isLoading"
            :src="item.image"
            @load="item.isLoading=false"
        />
      </div>

      <div class="userinfo">
        <el-avatar :size="50" :src="item.avatar"/>
        <br/>
        <span style="font-weight: bold">{{item.editorName}}</span>
        <br/>
        <span style="font-size: 12px">{{getFormattedDate(item.createTime)}}</span>
      </div>

    </el-card>
  </component>

  <component
      :is="rootType"
      v-bind="attrs"
  >
    <br/>
    <el-card v-loading="true" v-show="isLoading" class="card"/>
    <el-card v-show="isNothing" class="card nothingCard">
      <h1>There is nothing below.</h1>
    </el-card>
  </component>
</template>

<script setup>
  import {onMounted, reactive, ref, defineProps} from "vue";
  import {getArticleLink, getArticleList, handleFavouriteArticle, linkToArticle} from "@/scripts/handleArticleApi";
  import moment from "moment"
  import {Star, Link} from "@element-plus/icons-vue";
  import {delay} from "@/scripts/commonUtils";
  import {addMessage} from "@/scripts/messageUtils";

  const articleList = reactive([])
  const currentPage = ref(0)
  const isLoading = ref(false)
  const isNothing = ref(false)

  const props = defineProps({
    rootType: {
      type: String,
      default: "div",
    },
    getListFunc: {
      type: Function,
      default: getArticleList,
    },
    funcParams: {
      type: Array,
      default: () => [],
    },
    sizePage: {
      type: Number,
      default: 4
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

  const cardScale = props.cardScale.valueOf()

  const loadNewArticle = async () => {
    isLoading.value = true
    if(currentPage.value !== 0) {
      await delay(1000)
    }
    const result = await props.getListFunc(currentPage.value + 1, props.sizePage, ...props.funcParams)
    if(result.length === 0) {
      isNothing.value = true
      isLoading.value = false
      return
    }
    currentPage.value++
    result.forEach((item) => Object.assign(item, {isLoading: true}))
    articleList.push(...result)
    isLoading.value = false
    if(result.length < props.sizePage) {
      isNothing.value = true
    }
  }

  const getFormattedTime = (time) => {
    return moment(time).format('YYYY-MM-DD HH:mm:ss')
  }

  const getFormattedDate = (time) => {
    return moment(time).format('YYYY-MM-DD')
  }

  const clickLinkIcon = async (id) => {
    const link = getArticleLink(id)
    try {
      await navigator.clipboard.writeText(link);
      addMessage("Copy link to clipboard successfully", "success")
    } catch(e) {
      addMessage("Cannot copy the link to clipboard", "error")
    }
  }

  const clickStarIcon = async (item, id) => {
    const result = await handleFavouriteArticle(id)
    if(result) {
      item.isFavourite = !item.isFavourite
      if(item.isFavourite) {
        addMessage("Add favourite successfully", "success")
      } else {
        addMessage("Cancel favourite successfully", "success")
      }
    } else {
      addMessage("Adding favourite fails", "error")
    }
  }

  window.onscroll = async () => {
    if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight && !isLoading.value && !isNothing.value) {
      await loadNewArticle()
    }
  }

  onMounted(async () => loadNewArticle())
</script>

<style scoped>
.img{
  height: 110px;
  width: 165px;
}

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

.nothingCard{
  display: flex;
  align-items: center;
  justify-content: center
}

.userinfo{
  display: inline-block;
  position:absolute;
  right: var(--el-card-padding);
  bottom: var(--el-card-padding);
  text-align: center
}

.iconList{
  display: inline-block;
  position:absolute;
  right: var(--el-card-padding);
  top: var(--el-card-padding);
  text-align: center
}

.icon{
  margin-right: 10px;
}

.iconFilled{
  color: var(--el-color-primary-light-1);
}

.icon:hover{
  transform: scale(1.2);
  color: var(--el-color-primary-light-1);
  transition: transform 0.5s;
}
</style>