<template>
  <div>
    <el-avatar
        class="avatar"
        :size="avatarSize"
        @click="handleAvatarClick"
        @mouseenter="handleAvatarEnter"
        @mouseleave="handleLeave"
        :icon="UserFilled"
        :src="userInfo ? userInfo.avatar : ''"
    />

    <el-card
        class="card"
        @mouseenter="handleCardEnter"
        @mouseleave="handleLeave"
    >

      <slot name="main">
        <h2 class="nameLabel">
          {{ userInfo.realName }}
        </h2>

        <span
            class="emailLabel"
            :class="{email: isLinkEmail}"
            @click="handleEmailClick()"
        >
          {{ userInfo.email }}
        </span>

        <ul style="padding: 0">
          <li
              class="el-menu el-menu-item"
              v-for="([key, value], index) in userInfoList"
              :key="index"
          >
            <span style="font-weight: bold">
              {{ key() + $t('message.avatar_with_card.userinfo_label_colon') + "&ensp;" }}
            </span>
            <span>{{ value }}</span>
          </li>
        </ul>

        <slot name="extra"/>
      </slot>

    </el-card>
  </div>
</template>

<script setup>
import { ref, defineProps, reactive, onUpdated, onBeforeMount } from "vue";
import { useI18n } from "vue-i18n"
import { UserFilled } from "@element-plus/icons-vue"

const {t} = useI18n()

const props = defineProps({
  userInfo: Object,
  handleAvatarClick: Function,
  isLinkEmail: {
    type: Boolean,
    default: false,
  }
})

const avatarSize = 50

const userInfoList = reactive({})

const showAvatarCard = ref(false)
let hideTimer = null

onBeforeMount(()=>{
  handleInfoList()
})

onUpdated(()=>{
  handleInfoList()
})

const handleInfoList = ()=>{
  if(props.userInfo) {
    Object.assign(
        userInfoList,
        [
          [()=>t('message.avatar_with_card.userinfo_label_id'), props.userInfo.realId],
          [()=>t('message.avatar_with_card.userinfo_label_major'), props.userInfo.major],
          [()=>t('message.avatar_with_card.userinfo_label_grade'), props.userInfo.semester],
        ]
    )
  }
}

const handleEmailClick = () => {
  if(props.isLinkEmail) {
    window.open("mailto:" + props.userInfo.email)
  }
}

const handleAvatarEnter = () => {
  if(hideTimer) {
    clearTimeout(hideTimer)
  }
  showAvatarCard.value = true
}

const handleCardEnter = () => {
  if(hideTimer) {
    clearTimeout(hideTimer)
  }
}

const handleLeave = () => {
  hideTimer = setTimeout(()=>showAvatarCard.value = false, 100)
}

</script>

<style scoped>
  .avatar {
    position: relative;
    z-index: 12;
    cursor: pointer;

    transform: scale(v-bind("showAvatarCard ? 1.5 : 1"));
    transition: transform 0.2s;
  }

  .el-avatar--icon {
    --el-avatar-icon-size: 25px;
  }

  .card {
    --el-card-padding: 0;

    width: 250px;
    position: absolute;
    transform: translateX(calc(-50% + v-bind(avatarSize + 'px') / 2)) translateY(-10px);
    z-index: 11;

    display: v-bind("showAvatarCard ? 'block' : 'none'");
    opacity: v-bind("showAvatarCard ? 1 : 0");
    transition: opacity, display 0.3s;
    transition-delay: 0.1s;
  }

  .nameLabel {
    margin: 30px auto 5px auto;
    text-align: center;
  }

  .emailLabel {
    display:block;
    margin-bottom:10px;
    font-size: 5px;
    text-align: center;
    color: var(--el-color-info-light-3);
  }

  .email:hover {
    color: var(--el-color-primary-light-3);
    cursor: pointer;
  }

</style>