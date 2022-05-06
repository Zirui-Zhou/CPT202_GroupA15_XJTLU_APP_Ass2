<template>
  <el-backtop class="topButton" :bottom="100" :right="120">
    <div
        style="
        height: 100%;
        width: 100%;
        background-color: var(--el-bg-color-overlay);
        box-shadow: var(--el-box-shadow-lighter);
        border-radius: 10px;
        text-align: center;
        line-height: 50px;
        color: #1989fa;
      "
    >
      UP
    </div>
  </el-backtop>
</template>

<script setup>

</script>

<style>
.el-backtop {
  height: 50px;
  width: 50px;
}
</style>

<style scoped>
.topButton:hover{
  transform: scale(1.1);
  transition: transform 0.3s
}
</style>