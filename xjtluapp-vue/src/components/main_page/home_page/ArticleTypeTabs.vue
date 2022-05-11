<template>
  <el-tabs
      v-model="activeTab"
      class="articleTypeTabs"
  >

    <el-tab-pane
        :name="item.typeId"
        v-for="item in articleTypeList"
        :key="item.typeName"
    >
      <template #label>
        <el-icon style="margin-right: 5px">
          <component :is="item.typeIcon"/>
        </el-icon>
        <span>{{ item.typeName }}</span>
      </template>
    </el-tab-pane>

  </el-tabs>
</template>

<script setup>
import { computed, ref, defineExpose } from "vue";
import { useStore } from "vuex";

const store = useStore()

const activeTab = ref(1)
const articleTypeList = computed(()=>store.getters.getArticleTypeList)

const getCurrentTypeId = () => {
  return activeTab.value
}

defineExpose({
  getCurrentTypeId,
})
</script>

<style scoped>
.articleTypeTabs > .el-tabs__content {
  padding: 32px;
  color: #6b778c;
  font-size: 32px;
  font-weight: 600;
}

.articleTypeTabs {
  background-color: white;
}
</style>