<template>

  <div class="tagList" v-show="selectedTags.length > 0">
    <span class="tagTitle">Classification:</span>
    <div class="tagBlock">
      <el-tag
          class="tagItem"
          v-for="tag in selectedTags"
          :key="tag.tagId"
          closable
          @close="handleClose(tag)"
      >
        {{ tag.tagName }}
      </el-tag>
    </div>
  </div>

  <div
      class="tagList"
      v-for="(tags, index) in allTagList"
      :key="index"
  >
    <span class="tagTitle">{{ tags.typeName + ":" }}</span>
    <div class="tagBlock">
      <el-link
          class="linkItem"
          v-for="(tag, index) in tags.tagList"
          :key="index"
          :underline="false"
          @click="handleLinkClick(tag)"
          :type="isSelected(tag) ? 'default' : 'primary'"
      >
        {{ tag.tagName }}
      </el-link>
    </div>
  </div>

</template>

<script setup>
import {computed, onBeforeMount, reactive} from "vue";
import {getAllResourceTags} from "@/scripts/handleResourceApi";
import {useStore} from "vuex";

const store = useStore()

const selectedTags = computed(()=>store.getters.getSelectedTags)
const allTagList = reactive([])

const handleClose = (tag) => {
  store.commit("POP_SELECTED_TAG", tag)
}

const handleLinkClick = (item) => {
  if(isSelected(item)) {
    store.commit("PUSH_SELECTED_TAG", item)
  } else {
    handleClose(item)
  }
}

const isSelected = (item) => {
  return selectedTags.value.indexOf(item) === -1
}

onBeforeMount(async ()=> allTagList.push(...await getAllResourceTags()))
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