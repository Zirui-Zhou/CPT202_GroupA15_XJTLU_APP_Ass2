<template>
  <div style="display: block;">

    <div style="display: flex">
      <el-icon style="display: inline-block" :size="30">
        <component v-if="!isLoadingType" :is="articleTypeIcon"/>
      </el-icon>

      <h3 style="margin: auto 10px">{{item.title}}</h3>
    </div>

    <br/>

    <slot name="image">
      <el-image
          class="img"
          v-loading="item.isLoading"
          :src="item.image"
          @load="itemFunc(item, 'isLoading', false)"
      >
        <template #error><div/></template>
      </el-image>
    </slot>
  </div>
</template>

<script setup>
import {computed, defineProps, onBeforeMount, ref} from "vue";
import {useStore} from "vuex";
import {getAllArticleTypes} from "@/scripts/api/handleArticleApi";
import {delay} from "@/scripts/utils/commonUtils";

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
.img{
  height: 110px;
  width: 165px;
  object-fit: cover
}
</style>