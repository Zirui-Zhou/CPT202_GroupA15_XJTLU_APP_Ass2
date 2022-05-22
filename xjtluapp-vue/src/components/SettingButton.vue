<template>
  <el-backtop
      class="topButton"
      :bottom="100"
      :right="120"
      :visibility-height="100"
  >
    <div class="newButton" @click.stop="handleClick">
      <el-icon :size="30" class="editIcon">
        <Setting/>
      </el-icon>
    </div>
  </el-backtop>
</template>

<script setup>
import { defineProps } from "vue";
import { Setting } from "@element-plus/icons-vue";

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
.newButton {
  display: flex;
  position: fixed;
  height: 50px;
  width: 50px;
  z-index: 3000;
  background-color: var(--el-bg-color-overlay);
  box-shadow: var(--el-box-shadow-lighter);
  border-radius: 10px;
  text-align: center;
  line-height: 50px;
  color: var(--el-color-primary);
}

.newButton:hover {
  transform: scale(1.1);
  transition: transform 0.3s;
  cursor: pointer;
}

.editIcon {
  margin: auto;
}
</style>