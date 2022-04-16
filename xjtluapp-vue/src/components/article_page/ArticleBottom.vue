<template>
  <div>
    <el-divider class="divider" direction="horizontal"/>
    <el-row  >
      <el-button type="warning" plain>Marking</el-button>
      <el-rate
               allow-half
               v-model="value2"
               :colors="colors">
      </el-rate>
      <el-button class="text" plain>Complaints and Suggestion</el-button>
    </el-row>
  </div>

</template>

<script>
export default {
  name: "ArticleBottom",
  data() {
    return {
      value1: null,
      value2: null,
      colors: ['#99A9BF', '#F7BA2A', '#FF9900']  // 等同于 { 2: '#99A9BF', 4: { value: '#F7BA2A', excluded: true }, 5: '#FF9900' }
    }
  }
}
</script>

<style scoped>

.text{
  margin-left: auto;
}
</style>