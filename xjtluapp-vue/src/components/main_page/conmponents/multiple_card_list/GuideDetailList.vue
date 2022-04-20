<template>
  <div class="content" v-loading="isLoading">
    <div v-show="!isLoading">
      <h1>{{guideType.typeName}}</h1>
      <el-table :data="guideList" table-layout="auto">
        <el-table-column
            :label="$t('message.guide_detail_list.table_label_date')"
            prop="guideDate"
        />
        <el-table-column
            :label="$t('message.guide_detail_list.table_label_title')"
            prop="guideTitle"
        />
        <el-table-column>
          <template #default="props">
            <el-button type="primary" @click="openUrl(props.row.guideLink)">
              {{ $t('message.guide_detail_list.button_link_to') }}
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script setup>
import {defineProps, reactive, onMounted, ref} from "vue";
import {getGuideListOfType, getGuideType} from "@/scripts/handleGuideApi";
import {delay, getFormattedDate} from "@/scripts/commonUtils";

const props = defineProps({
  type: Number
})

const guideList = reactive([])
const guideType = reactive([])

const isLoading = ref(true)

const loadGuideOfType = async (type) => {

  Object.assign(guideList, await getGuideListOfType(type))
  guideList.forEach((item, index, array)=>{
    item.guideDate = getFormattedDate(item.guideDate)
    array[index] = item
  })

}

const openUrl = (url) => {
  window.open(url)
}

const loadGuideType = async (type) => {
  Object.assign(guideType, await getGuideType(type))
}

onMounted(async () =>{
  isLoading.value = true
  await loadGuideOfType(props.type)
  await loadGuideType(props.type)
  await delay(300)
  isLoading.value = false
})

</script>

<style scoped>
.content{
  min-height: 400px;
}
</style>