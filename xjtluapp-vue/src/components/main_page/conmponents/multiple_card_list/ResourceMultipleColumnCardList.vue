<template>

  <MultipleColumnCardList
      :item-list="moduleList"
      :click-card="clickCard"
      :is-loading="isLoading"
      :item-key-list="guideItemKeyList"
  />

</template>

<script setup>
import { computed, onMounted, reactive, ref, watch } from "vue";
import { useStore } from "vuex";
import { getResourceListOfTags } from "@/scripts/api/handleResourceApi";
import { delay } from "@/scripts/utils/commonUtils";
import MultipleColumnCardList from "@/components/main_page/conmponents/multiple_card_list/MultipleColumnCardList"

const store = useStore()

const currentPage = ref(0)
const sizePage = 6

const isLoading = ref(false)
const isNothing = ref(false)

const moduleList = reactive([])
const selectedTags = computed(()=>store.getters.getSelectedTags)
const selectedTagIds = []
const guideItemKeyList = {
  id: "resourceId",
  path: "resourcePath",
  name: "resourceName",
  image: "resourceImage",
}

const loadResourceList = async () => {
  isLoading.value = true
  await delay(500)

  currentPage.value++

  const result = await getResourceListOfTags(currentPage.value, sizePage, selectedTagIds)

  moduleList.push(...result)

  isLoading.value = false
  if(result.length < sizePage) {
    isNothing.value = true
  }
}

const clickCard = (url) => {
  window.open(url)
}

watch(selectedTags.value, async ()=>{
  selectedTagIds.length = 0
  selectedTags.value.forEach((item)=>selectedTagIds.push(item.tagId))
  await initiateResourceList()
})

const initiateResourceList = async () => {
  moduleList.length = 0
  currentPage.value = 0
  isNothing.value = false
  do{
    await loadResourceList()
  }while(document.body.scrollHeight <= window.innerHeight && !isLoading.value && !isNothing.value)
}

window.onscroll = async () => {
  if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight && !isLoading.value && !isNothing.value) {
    await loadResourceList()
  }
}

onMounted(async () => await initiateResourceList())
</script>

<style scoped>

</style>
