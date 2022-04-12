<template>

  <img src="@/assets/xjtlu_banner.svg" class="banner">

  <el-menu
      :default-active="router.currentRoute.value.path"
      class="el-menu-demo"
      mode="horizontal"
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

      <AvatarWithCard class="align-right"/>

    </el-row>
  </el-menu>

</template>

<script setup>
import {ref} from "vue"
import {Search} from "@element-plus/icons-vue";
import {useRouter} from "vue-router";
import AvatarWithCard from "@/components/main_page/conmponents/AvatarWithCard";

const router = useRouter()

const input = ref("")
</script>

<style scoped>
.banner{
  width: 15%;
  height: 15%;
  margin: 10px;
}

.align-right{
  margin: auto 10px auto auto;
}
</style>