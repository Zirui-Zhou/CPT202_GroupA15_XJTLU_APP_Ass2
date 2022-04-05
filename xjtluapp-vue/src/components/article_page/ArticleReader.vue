<template>
  <v-md-preview :text="article.articleContent" style="background-color: white"></v-md-preview>
</template>

<script>
export default {
  name: "ArticleReader"
}
</script>

<script setup>
  import {useRoute} from "vue-router";
  import {onBeforeMount, ref} from "vue";
  import axios from "axios";
  import {ElMessage} from "element-plus";

  const route = useRoute()

  const id = route.query.id
  const article = ref({articleContent: "Sorry, the context cannot be rendered correctly"})

  onBeforeMount(() => {
    axios.get("http://localhost:8081/article", {params: {id: id}}).then((res) => {
      article.value = res.data.data
      ElMessage({
        message: 'Get the articles',
        type: 'success',
      })
    }).catch(error => {
      ElMessage({
        message: error.response.data.msg,
        type: 'error',
      })
    })
  })

</script>

<style scoped>

</style>