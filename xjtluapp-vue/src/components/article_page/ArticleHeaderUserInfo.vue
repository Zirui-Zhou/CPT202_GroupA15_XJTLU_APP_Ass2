<template>
  <el-row>
    <AvatarWithCard
        :user-info="userInfo"
        :is-link-email="isLinkEmail"
    />
    <div style="margin-left: 20px">
        <span class="name">
          {{ userInfo.realName }}
        </span>
      <span
          class="email"
          v-bind:class="{'email-link': isLinkEmail}"
          @click="handleEmailClick"
      >
          {{ userInfo.email }}
        </span>
    </div>
  </el-row>
</template>

<script setup>
import { defineProps } from "vue";
import AvatarWithCard from "@/components/AvatarWithCard"

const props = defineProps({
  userInfo: Object,
  isLinkEmail: Boolean,
})

const handleEmailClick = () => {
  if(props.isLinkEmail) {
    window.open("mailto:" + props.userInfo.email)
  }
}
</script>

<style scoped>
.name {
  position: absolute;
  top: 0;
  font-weight: bold;
  font-size: 20px
}

.email {
  position: absolute;
  bottom: 0;
}

.email-link:hover {
  color: var(--el-color-primary-light-3);
  cursor: pointer;
}
</style>