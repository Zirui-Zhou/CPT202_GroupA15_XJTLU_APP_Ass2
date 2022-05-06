<template>
  <div style="display: block;">

    <div style="display: flex">
      <el-icon style="display: inline-block" :size="30">
        <component :is="getArticleTypeIcon(item.typeId)"/>
      </el-icon>

      <h3 style="margin: auto 10px">{{item.title}}</h3>
    </div>

    <br/>

    <el-image
        class="img"
        style="object-fit: cover"
        v-loading="item.isLoading"
        :src="item.image"
        @load="itemFunc(item, 'isLoading', false)"
    >
      <template #error><div/></template>
    </el-image>

  </div>
</template>

<script>
import {DataAnalysis, Document, Medal, OfficeBuilding} from "@element-plus/icons-vue";

export default {
  components: {
    Document: Document,
    Medal: Medal,
    OfficeBuilding: OfficeBuilding,
    DataAnalysis: DataAnalysis
  }
}
</script>

<script setup>
  import {defineProps, computed, toRaw} from "vue";
  import {useStore} from "vuex";

  const store = useStore()

  const articleTypeList = store.getters.getArticleTypeList

  const getArticleTypeIcon = (typeId) => {
    return articleTypeList.filter((item)=>item.typeId === typeId)[0].typeIcon
  }

  const props = defineProps({
    item: Object,
    itemFunc: Function,
  })
</script>

<style scoped>
.img{
  height: 110px;
  width: 165px;
}
</style>