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
        <h2 style="margin: 30px 10px 15px 10px; text-align: center">
          {{ userInfo.realName }}
        </h2>

        <ul style="padding: 0">
          <li class="el-menu-item" v-for="([key, value], index) in userInfoList" :key="index">
            <span style="font-weight: bold">{{ key + ":" }}</span>
            <span>&emsp;{{ value }}</span>
          </li>
        </ul>

        <el-button @click="logoutUser" class="button">
          Logout
        </el-button>

      </div>

      <div v-if="!userInfo">
        <h2 style="margin: 120px 0; text-align: center">Please&nbsp;login&nbsp;first</h2>
      </div>

    </el-card>
  </div>
</template>

<script setup>
import {logout, needLogin} from "@/scripts/handleUserApi";
import {computed, ref, reactive} from "vue";
import {useStore} from "vuex";
import {useRouter} from "vue-router";
import {UserFilled} from "@element-plus/icons-vue"

const store = useStore()
const router = useRouter()

const userInfo = computed(()=>store.getters.getUserInfo)

const avatarSize = 50

const showAvatarCard = ref(false)
let hideTimer = null

const userInfoList = reactive([
  ["ID", userInfo.value ? userInfo.value.realId : null],
  ["Major", userInfo.value ? userInfo.value.major : null],
  ["Grade", userInfo.value ? userInfo.value.semester : null],
])

const handleAvatarClick = async () => {
  if(await needLogin(""))
    await router.push("/student")
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

    width: 90%;
    position: absolute;
    transform: translateX(calc(-50% + v-bind(avatarSize + 'px') / 2)) translateY(-10px);
    z-index: 11;

    display: v-bind("showAvatarCard ? 'block' : 'none'");
    opacity: v-bind("showAvatarCard ? 1 : 0");
    transition: opacity, display 0.3s;
    transition-delay: 0.1s;
  }

  .button{
    width: calc(100% - 20px);
    margin: 10px;
    height: 40px;
  }
</style>