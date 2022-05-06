<template>
  <el-result
      icon="error"
      title="404 Not Found"
      sub-title="Please click the button to go back"
      class="errorResult"
  >
    <template #extra>
      <el-button type="primary" @click="handleBackClick">
        Back
      </el-button>
    </template>
  </el-result>
</template>

<script setup>
import {useRouter} from "vue-router";

const router = useRouter()

const handleBackClick = () => {
  router.back()
}

</script>

<style scoped>
.errorResult {
  position: absolute;
  top: 50%; left: 50%;
  transform: translateX(-50%) translateY(-50%) scale(120%);
}
</style>