<template>

  <CarouselList/>

  <br/>

  <ArticleTypeTabs ref="TypeTabsRef"/>

  <SingleColumnCardList
      v-if="!isTabsLoading"
      :key="activeTab"
      list-type="type"
      :list-func-param="[activeTab]"
  />

  <AddNewArticleButton/>

</template>

<script setup>
import {computed, onMounted, ref} from "vue"
import SingleColumnCardList from "@/components/main_page/conmponents/single_card_list/SingleColumnCardList";
import CarouselList from "@/components/main_page/home_page/CarouselList";
import AddNewArticleButton from "@/components/AddNewArticleButton";
import ArticleTypeTabs from "@/components/main_page/home_page/ArticleTypeTabs";

const TypeTabsRef = ref(null)
const isTabsLoading = ref(true)
const activeTab = computed(()=>TypeTabsRef.value.getCurrentTypeId())

onMounted(()=>{
  isTabsLoading.value = false
})
</script>

<style scoped>


</style>