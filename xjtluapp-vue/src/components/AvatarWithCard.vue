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
      <div v-if="userInfo">
        <h2 class="nameLabel">
          {{ userInfo.realName }}
        </h2>

        <span
            class="emailLabel"
            :class="{email: !isSelf}"
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
              {{ key() + $t('message.avatar_with_card.userinfo_label_colon') }}
            </span>
            <span>{{ value }}</span>
          </li>
        </ul>

        <el-button
            @click="logoutUser"
            class="button"
            v-if="isSelf"
        >
          {{ $t('message.avatar_with_card.button_logout') }}
        </el-button>

      </div>

      <div v-if="!userInfo">
        <h2 style="margin: 120px 0; text-align: center">
          {{ $t('message.avatar_with_card.label_no_login') }}
        </h2>
      </div>

    </el-card>
  </div>
</template>

<script setup>
import {logout, needLogin} from "@/scripts/handleUserApi";
import {ref, defineProps, reactive, onUpdated, onBeforeMount} from "vue";
import {useRouter} from "vue-router";
import {UserFilled} from "@element-plus/icons-vue"
import {useI18n} from "vue-i18n"

const router = useRouter()
const {t} = useI18n()

const props = defineProps({
  userInfo: Object,
  isSelf: {
    type: Boolean,
    default: false,
  }
})

const avatarSize = 50

const showAvatarCard = ref(false)
let hideTimer = null

const userInfoList = reactive({})

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

const handleAvatarClick = async () => {
  if(!props.isSelf) {
    return
  }
  if(await needLogin(""))
    await router.push("/student")
}

const handleEmailClick = () => {
  if(!props.isSelf) {
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

const logoutUser = () => {
  showAvatarCard.value = false
  logout()
}
</script>

<style scoped>
  .avatar{
    position: relative;
    z-index: 12;
    cursor: pointer;

    transform: scale(v-bind("showAvatarCard ? 1.5 : 1"));
    transition: transform 0.2s;
  }

  .el-avatar--icon {
    --el-avatar-icon-size: 25px;
  }

  .card{
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

  .nameLabel{
    margin: 30px 10px 5px 10px;
    text-align: center;
  }

  .emailLabel{
    display:block;
    margin-bottom:10px;
    font-size: 5px;
    text-align: center;
    color: var(--el-color-info-light-3);
  }

  .email:hover{
    color: var(--el-color-primary-light-3);
    cursor: pointer;
  }

  .button{
    width: calc(100% - 20px);
    margin: 10px;
    height: 40px;
  }
</style>