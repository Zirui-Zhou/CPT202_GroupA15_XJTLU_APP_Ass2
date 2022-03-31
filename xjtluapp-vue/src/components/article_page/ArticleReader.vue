<template>
  <v-md-preview :text="MdTest" style="background-color: white"></v-md-preview>
</template>

<script>
export default {
  name: "ArticleReader"
}
</script>

<script setup>
import MdTest from '@/assets/test/md_test.md'

</script>

<style scoped>

</style>