<template>
  <el-menu
      :default-active="$route.path"
      class="el-menu-demo"
      mode="horizontal"
      @select="handleSelect"
      router
  >
    <el-menu-item index="/student">
      <template #title>Student</template>
    </el-menu-item>
    <el-menu-item index="/home">
      <template #title>Home</template>
    </el-menu-item>
    <el-menu-item index="/guide">
      <template #title>Guide</template>
    </el-menu-item>
    <el-menu-item index="/module">
      <template #title>Module</template>
    </el-menu-item>

    <el-row class="align-right">
      <el-input
          placeholder="Please input"
          style="width: 200px"
          class="align-right"
          :suffix-icon="Search"
      />
      <el-divider class="align-right" direction="vertical"/>
      <el-avatar
          class="align-right"
          :size="50"
          @click="$router.push('/user/login')"
          src="https://pic1.zhimg.com/v2-bf0480b6b8fbcada9095412e3de0a7c3_is.jpg?source=32738c0c"
      />
    </el-row>

  </el-menu>

</template>

<script>
  export default {
    name: "TopMenu"
  }
</script>

<script setup>
import {Search} from "@element-plus/icons-vue";

const handleSelect = (key, keyPath) => {
  console.log(key, keyPath)
}
</script>

<style scoped>
  .align-right{
    margin: auto 10px auto auto;
  }
</style>