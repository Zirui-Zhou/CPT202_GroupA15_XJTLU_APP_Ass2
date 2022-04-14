<template>
  <div class="iconList">
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
import {getArticleLink, handleFavouriteArticle, removeHistoryArticle} from "@/scripts/handleArticleApi";
import {addMessage} from "@/scripts/messageUtils";
import {Star, Link, Delete} from "@element-plus/icons-vue";
import {defineProps} from "vue";

const props = defineProps({
  removeFunc: Function,
  itemFunc: Function,
  item: Object,
  listType: String,
})

const clickDeleteIcon = async (item) => {
  await removeHistoryArticle(item.id)
  await props.removeFunc(item)
}

const isShowDelete = () => {
  return ["mime", "history"].indexOf(props.listType) !== -1
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
  await handleFavouriteArticle(id)
  props.itemFunc(item, "isFavourite", !item.isFavourite)
  if(props.listType === "favourite") {
    props.removeFunc(item)
  }
  if(!item.isFavourite) {
    addMessage("Add favourite successfully", "success")
  } else {
    addMessage("Cancel favourite successfully", "success")
  }
}

</script>

<style scoped>
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