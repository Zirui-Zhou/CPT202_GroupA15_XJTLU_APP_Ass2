<template>

  <div style="display: flex">
    <el-icon :size="30">
      <component
          v-if="!isLoadingType"
          :is="articleTypeIcon"
      />
    </el-icon>

    <h3 style="margin: auto 10px">
      {{item.title}}
    </h3>
  </div>

  <br/>

  <slot name="image">
    <el-image
        class="articleImage"
        v-loading="item.isLoading"
        :src="item.image"
        @load="itemFunc(item, 'isLoading', false)"
        fit="cover"
    >
    </el-image>
  </slot>

</template>

<script setup>
import { computed, defineProps, onBeforeMount, ref } from "vue";
import { useStore } from "vuex";
import { getAllArticleTypes } from "@/scripts/api/handleArticleApi";

const store = useStore()

const props = defineProps({
  item: Object,
  itemFunc: Function,
})

const articleTypeList = computed(()=>store.getters.getArticleTypeList)
const articleTypeIcon = computed(()=>getArticleTypeIcon())
const isLoadingType = ref(true)

const getArticleTypeIcon = () => {
  return articleTypeList.value.filter((item)=>item.typeId === props.item.typeId)[0].typeIcon
}

onBeforeMount(async ()=>{
  if(!articleTypeList.value || Object.keys(articleTypeList.value).length === 0) {
    await getAllArticleTypes()
  }
  isLoadingType.value = false
})
</script>

<style scoped>
.articleImage {
  height: 110px;
  width: 165px;
}
</style>