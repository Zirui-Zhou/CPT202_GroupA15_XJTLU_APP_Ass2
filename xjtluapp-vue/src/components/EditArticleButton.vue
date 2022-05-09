<template>
  <el-backtop
      class="topButton"
      :bottom="160"
      :right="120"
      :visibility-height="100"
  >
    <div class="newButton" @click.stop="handleClick">
      <el-icon :size="30" class="editIcon">
        <Edit/>
      </el-icon>
    </div>
  </el-backtop>
</template>

<script setup>
import { defineProps } from "vue";
import {Edit} from "@element-plus/icons-vue";

defineProps({
  handleClick: Function,
})

</script>

<style>
.el-backtop {
  height: 50px;
  width: 50px;
}
</style>

<style scoped>
.newButton{
  display: flex;
  position: fixed;
  height: 50px;
  width: 50px;
  z-index: 3000;
  background-color: var(--el-color-primary);
  box-shadow: var(--el-box-shadow-lighter);
  border-radius: 10px;
  text-align: center;
  line-height: 50px;
  color: var(--el-bg-color-overlay);
}

.newButton:hover{
  transform: scale(1.1);
  transition: transform 0.3s;
  cursor: pointer;
}

.editIcon{
  margin: auto;
}
</style>