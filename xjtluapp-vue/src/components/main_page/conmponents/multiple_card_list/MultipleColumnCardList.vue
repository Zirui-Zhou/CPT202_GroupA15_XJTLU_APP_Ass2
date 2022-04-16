<template>
  <div v-loading="isLoading" class="space">

    <div
        class="spaceItem"
        v-for="item in moduleList"
        :key="item.resourceId"
    >
      <el-card shadow="hover" class="card" @click="clickCard(item.resourcePath)">
        <template #header>
          <div class="card-header">
            {{ item.resourceName }}
          </div>
        </template>
        <img :src="item.resourceImage">
      </el-card>
    </div>

  </div>
</template>

<script setup>
import {getResourceListOfTags} from "@/scripts/handleResourceApi";
import {computed, onMounted, reactive, ref, watch} from "vue";
import {delay} from "@/scripts/commonUtils";
import {useStore} from "vuex";

const store = useStore()

const currentPage = ref(0)
const sizePage = 9

const isLoading = ref(false)

const moduleList = reactive([])
const selectedTags = computed(()=>store.getters.getSelectedTags)
let selectedTagIds = []

const loadNewArticle = async () => {

  isLoading.value = true


  await delay(500)

  const result = await getResourceListOfTags(currentPage.value, sizePage, selectedTagIds)

  clearModuleList()
  moduleList.push(...result)

  isLoading.value = false

}

const clearModuleList = () => {
  moduleList.length = 0
}

const clickCard = (url) => {
  window.open(url)
}

const watchFunc = watch(selectedTags.value, async ()=>{
  selectedTagIds = []
  selectedTags.value.forEach((item)=>selectedTagIds.push(item.tagId))

  await loadNewArticle()

})

onMounted(async () => await loadNewArticle())

</script>

<style scoped>

img {
  width: 100%;
  height: 100px;
  min-height: 160px;
}

.space {
  display: flex;
  flex-flow: row wrap;

  /*Ensure the loading animation in the right position*/
  min-height: 300px;
}

.spaceItem {
  flex: 0 0 33.3%;
}

.card {
  display: block;
  margin: 10px
}

.card:hover {
  transform: scale(1.05);
  position: relative;
  z-index: 1;
  transition: 0.5s;

  cursor: pointer;
}

.card-header {
  text-align: center;
}

</style>
