<template>

  <h1>
    {{ $t('message.search_page.label_search_result', {word: keyWord}) }}
  </h1>

  <SingleColumnCardList
    :key="keyWord"
    list-type="search"
    :list-func-param="[keyWord]"
  />

</template>

<script setup>
import {computed} from "vue";
import {useRoute} from "vue-router";
import SingleColumnCardList from "@/components/main_page/conmponents/single_card_list/SingleColumnCardList";

const route = useRoute()

const keyWord = computed(()=>route.query.word)
</script>

<style scoped>

</style>