<template>
  <div class="iconList">
    <el-icon
        class="icon"
        :size="30"
        @click.stop="clickEditIcon(item)"
        v-if="isShowEdit()"
    >
      <Edit/>
    </el-icon>

    <el-icon
        class="icon"
        :size="30"
        @click.stop="clickDeleteIcon(item)"
        v-if="isShowDelete()"
    >
      <Delete/>
    </el-icon>

    <el-icon
        class="icon"
        :class="{'iconFilled': item.isFavourite}"
        :size="30"
        @click.stop="clickStarIcon(item, item.id)"
    >
      <Star/>
    </el-icon>

    <el-icon
        class="icon"
        :size="30"
        @click.stop="clickLinkIcon(item.id)"
    >
      <Link/>
    </el-icon>
  </div>
</template>

<script setup>
import { computed, defineProps } from "vue";
import { useStore } from "vuex"
import { Star, Link, Delete, Edit } from "@element-plus/icons-vue";
import {
  getArticleLink,
  handleFavouriteArticle,
  linkToEditArticle,
  removeHistoryArticle
} from "@/scripts/api/handleArticleApi";
import { addMessage } from "@/scripts/utils/messageUtils";

const store = useStore()

const props = defineProps({
  item: Object,
  itemFunc: Function,
  listType: String,
  removeFunc: Function,
})

const userInfo = computed(()=>store.getters.getUserInfo)

const isShowDelete = () => {
  return ["mime", "history", "preview"].indexOf(props.listType) !== -1
}

const isShowEdit = () => {
  if(["preview"].indexOf(props.listType) !== -1){
    return false
  }
  return userInfo.value.userId.toString() === props.item.editorId.toString()
}

const clickEditIcon = (item) => {
  linkToEditArticle(item.id)
}

const clickDeleteIcon = async (item) => {
  if(props.listType === "preview") {
    return
  }
  await removeHistoryArticle(item.id)
  await props.removeFunc(item)
}

const clickLinkIcon = async (id) => {
  if(props.listType === "preview") {
    return
  }
  const link = getArticleLink(id)
  try {
    await navigator.clipboard.writeText(link)
    addMessage("Copy link to clipboard successfully", "success")
  } catch(e) {
    addMessage("Cannot copy the link to clipboard", "error")
  }
}

const clickStarIcon = async (item, id) => {
  if(props.listType !== "preview") {
    await handleFavouriteArticle(id)
  }
  props.itemFunc(item, "isFavourite", !item.isFavourite)
  if(props.listType === "favourite") {
    props.removeFunc(item)
  }
  if(props.listType === "preview") {
    return
  }
  if(item.isFavourite) {
    addMessage("Add favourite successfully", "success")
  } else {
    addMessage("Cancel favourite successfully", "success")
  }
}

</script>

<style scoped>
.iconList {
  display: inline-block;
  position:absolute;
  right: var(--el-card-padding);
  top: var(--el-card-padding);
  text-align: center
}

.icon {
  margin-left: 10px;
}

.icon:hover {
  transform: scale(1.2);
  color: var(--el-color-primary-light-3);
  transition: transform 0.5s;
}

.iconFilled {
  color: var(--el-color-primary-light-3);
}
</style>