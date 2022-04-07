<template>
  <el-menu
      :default-active="router.path"
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
          v-model="input"
          style="width: 200px"
          class="align-right"
          :suffix-icon="Search"
      />
      <el-divider class="align-right" direction="vertical"/>
      <div>
        <el-avatar
            class="align-right avatar"
            :size="50"
            @click="handleAvatarClick"
            src="https://pic1.zhimg.com/v2-bf0480b6b8fbcada9095412e3de0a7c3_is.jpg?source=32738c0c"
        />
        <el-card class="card">
          <h2>Rui&nbsp;Bao&nbsp;Cry&nbsp;Cry</h2>
          <h2>Rui&nbsp;Bao&nbsp;Cry&nbsp;Cry</h2>
          <h2>Rui&nbsp;Bao&nbsp;Cry&nbsp;Cry</h2>
          <h2>Rui&nbsp;Bao&nbsp;Cry&nbsp;Cry</h2>
        </el-card>
      </div>

    </el-row>
  </el-menu>


</template>

<script>
  export default {
    name: "TopMenu"
  }
</script>

<script setup>
import {ref} from "vue"
import {Search} from "@element-plus/icons-vue";
import {useRouter} from "vue-router";

const router = useRouter()
const input = ref("")

const handleSelect = (key, keyPath) => {
  console.log(key, keyPath)
}

const handleAvatarClick = () => {
  router.push('/user/login')
}
</script>

<style scoped>
  .align-right{
    margin: auto 10px auto auto;
  }

  .avatar{
    transition: 0.2s;
    z-index: 2;
    cursor: pointer;
  }

  .avatar:hover{
    transform: scale(1.5);
    position: relative;
    transition: transform 0.2s;

  }

  .card{
    position: absolute;
    transform: translate(calc(-50% + 25px));
    z-index: 1;

    opacity: 0;
    transition: opacity 0.3s;
    transition-delay: 0.1s;
  }

  div > .avatar:hover + .card{
    opacity: 1;
    transition: opacity 0.3s;
    transition-delay: 0.1s;
  }

</style>