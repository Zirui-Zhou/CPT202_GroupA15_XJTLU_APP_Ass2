<template>

  <div class="tagList" v-show="selectedList.length > 0">
    <span class="tagTitle">Classification:</span>
    <div class="tagBlock">
      <el-tag
          class="tagItem"
          v-for="tag in selectedList"
          :key="tag"
          closable
          @close="handleClose(tag)"
      >
        {{ tag }}
      </el-tag>
    </div>
  </div>

  <div
      class="tagList"
      v-for="(tags, index) in tagList"
      :key="index"
  >
    <span class="tagTitle">{{ tags.typeName + ":" }}</span>
    <div class="tagBlock">
      <el-link
          class="linkItem"
          v-for="(tag, index) in tags.tagName"
          :key="index"
          :underline="false"
          @click="handleLinkClick(tag)"
          :type="isSelected(tag) ? 'default' : 'primary'"
      >
        {{ tag }}
      </el-link>
    </div>
  </div>

</template>

<script setup>
import {onBeforeMount, reactive} from "vue";
import {getTagTypeList} from "@/scripts/handleArticleApi";

const selectedList = reactive([])
const tagList = reactive([])

const handleClose = (tag) => {
  selectedList.forEach((item, index, array) => {
    if (item === tag) {
      array.splice(index,1);
    }
  })
}

const handleLinkClick = (item) => {
  if(isSelected(item)) {
    selectedList.push(item)
  } else {
    handleClose(item)
  }
}

const isSelected = (item) => {
  return selectedList.indexOf(item) === -1
}

onBeforeMount(async ()=> tagList.push(...await getTagTypeList()))
</script>

<style scoped>
.tagList {
  text-align: left;
  display: flex;
  flex-flow: row wrap;

  border-bottom: 2px dashed var(--el-border-color);
}

.tagList:last-child {
  border: none;
}

.tagBlock {
  flex: 1;
  margin: 5px auto;
}

.tagTitle {
  flex: 0 0 15%;
  margin: auto 10px;
  font-size: 15px;
}

.tagItem {
  margin: 5px;
  vertical-align: middle;
}

.linkItem {
  margin: 5px 10px;
  font-size: 15px;
}
</style>