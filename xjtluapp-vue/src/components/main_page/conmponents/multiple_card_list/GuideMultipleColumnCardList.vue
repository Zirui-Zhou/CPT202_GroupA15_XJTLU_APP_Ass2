<template>

  <MultipleColumnCardList
      :item-list="guideTypeList"
      :click-card="clickCard"
      :is-loading="isLoading"
      :item-key-list="guideItemKeyList"
  />

</template>

<script setup>
import { computed, onMounted, ref, watch } from "vue";
import { getGuideTypeList } from "@/scripts/api/handleGuideApi";
import { useRouter } from "vue-router";
import { useStore } from "vuex";
import MultipleColumnCardList from "@/components/main_page/conmponents/multiple_card_list/MultipleColumnCardList";

const router = useRouter()
const store = useStore()

const isLoading = ref(false)
const guideTypeList = computed(()=>store.getters.getGuideTypeList)
const guideItemKeyList = {
  id: "typeId",
  path: "typeId",
  name: "typeName",
  image: "typeImage",
}

const loadGuideType = async () => {
  await store.commit("SET_GUIDE_TYPE_LIST", await getGuideTypeList())
}

const clickCard = (type) => {
  router.push({path: "/guide/detail", query: {type: type}})
}

watch(()=>store.getters.getLang, ()=>loadGuideType())

onMounted(async () => await loadGuideType())
</script>

<style scoped>

</style>
