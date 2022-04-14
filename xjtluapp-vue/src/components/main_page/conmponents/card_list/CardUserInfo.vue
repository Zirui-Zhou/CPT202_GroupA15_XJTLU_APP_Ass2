<template>
  <div class="userinfo">
    <el-avatar
        :size="50"
        :src="item.avatar"
        :icon="UserFilled"
    />
    <br/>
    <span style="font-weight: bold">{{item.editorName}}</span>
    <br/>
    <span style="font-size: 12px">{{getFormattedDate(item.createTime)}}</span>
  </div>
</template>

<script setup>
import moment from "moment";
import {defineProps} from "vue";
import {UserFilled} from "@element-plus/icons-vue"

const props = defineProps({
  item: Object,
})

const getFormattedDate = (time) => {
  return moment(time).format('YYYY-MM-DD')
}
</script>

<style scoped>
.userinfo{
  display: inline-block;
  position:absolute;
  right: var(--el-card-padding);
  bottom: var(--el-card-padding);
  text-align: center
}

.el-avatar--icon {
  --el-avatar-icon-size: 25px;
}
</style>