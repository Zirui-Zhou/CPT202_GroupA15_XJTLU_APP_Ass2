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
import {getResourceListOfTags} from "@/scripts/api/handleResourceApi";
import {computed, onMounted, reactive, ref, watch} from "vue";
import {delay} from "@/scripts/utils/commonUtils";
import {useStore} from "vuex";

const store = useStore()

const currentPage = ref(0)
const sizePage = 6

const isLoading = ref(false)
const isNothing = ref(false)

const moduleList = reactive([])
const selectedTags = computed(()=>store.getters.getSelectedTags)
let selectedTagIds = []

const loadResource = async (isReload=false) => {

  isLoading.value = true
  await delay(500)

  if(isReload) {
    currentPage.value = 0
  }
  currentPage.value++

  const result = await getResourceListOfTags(currentPage.value, sizePage, selectedTagIds)

  if(isReload){
    isNothing.value = false
    clearModuleList()
  }

  moduleList.push(...result)

  isLoading.value = false
  if(result.length < sizePage) {
    isNothing.value = true
  }

}

const clearModuleList = () => {
  moduleList.length = 0
}

const clickCard = (url) => {
  window.open(url)
}

watch(selectedTags.value, async ()=>{
  selectedTagIds = []
  selectedTags.value.forEach((item)=>selectedTagIds.push(item.tagId))
  await loadResource(true)
})

window.onscroll = async () => {
  if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight && !isLoading.value && !isNothing.value) {
    await loadResource()
  }
}

onMounted(async () => await loadResource())

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
