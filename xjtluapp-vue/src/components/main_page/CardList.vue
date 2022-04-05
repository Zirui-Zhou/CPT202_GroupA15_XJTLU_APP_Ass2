<template>
  <div v-for="item in articleList" :key="item.articleId">
    <br/>
    <el-card class="card" @click="clickCard(item.articleId)">
      <el-avatar :size="50" :src="item.userAvatar" />
      <br/>
      <span>{{item.userName}}</span>
      <br/>
      <img :src="item.articleImage" alt="xjtlu"/>
      <span>{{item.articleTitle}}</span>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "CardList"
}
</script>

<script setup>
  import {useRouter} from "vue-router"
  import {onBeforeMount, reactive} from "vue";
  import axios from "axios";
  import {ElMessage} from "element-plus";

  const router = useRouter()

  const articleList = reactive([])

  const clickCard = (id) => {
    router.push({path: '/article',
      query:{id: id}
    })
  }

  const getArticleList = (from, to) => {
    axios.post("http://localhost:8081/articlelist", {fromIndex: from, articleNum: to}).then(res => {
      const article = res.data.data
      articleList.push(...article)
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
  }

  onBeforeMount(() => getArticleList(1, 5))

</script>

<style scoped>
img{
  height: 70px
}
.card:hover{
  /* 设置倾斜角度和缩放比例 */
  transform: scale(1.05);
  /* 设置相对位置 */
  position: relative;
  /* 设置显示优先级别(相当于设置z轴的高度，正数离用户更近，负数更远) */
  z-index: 1;
  /* 设置显示加载时间 */
  transition: 0.5s;
}
</style>