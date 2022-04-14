<template>
  <div style="display: inline-block;">
    <h3 style="margin-top: 0">{{item.title}}</h3>
    <el-image
        class="img"
        v-if="item.isLoading"
        v-loading="true"
    >
      <template #error><div/></template>
    </el-image>
    <el-image
        class="img"
        style="object-fit: cover"
        v-show="!item.isLoading"
        :src="item.image"
        @load="itemFunc(item, 'isLoading', false)"
    />
  </div>
</template>

<script setup>
  import {defineProps} from "vue";

  const props = defineProps({
    item: Object,
    itemFunc: Function,
  })
</script>

<style scoped>
.img{
  height: 110px;
  width: 165px;
}
</style>