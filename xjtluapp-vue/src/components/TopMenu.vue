<template>

  <img src="@/assets/xjtlu_name.svg" class="banner" @click="handleBannerClick()">

  <el-menu
      :default-active="router.currentRoute.value.path"
      class="topMenu"
      mode="horizontal"
      router
  >

    <el-menu-item index="/student">
      <template #title>{{ $t('message.top_menu.menu_item_student') }}</template>
    </el-menu-item>
    <el-menu-item index="/home">
      <template #title>{{ $t('message.top_menu.menu_item_home') }}</template>
    </el-menu-item>
    <el-menu-item index="/guide">
      <template #title>{{ $t('message.top_menu.menu_item_guide') }}</template>
    </el-menu-item>
    <el-menu-item index="/module">
      <template #title>{{ $t('message.top_menu.menu_item_module') }}</template>
    </el-menu-item>

    <el-row class="align-right">
      <el-input
          :placeholder="$t('message.top_menu.input_placeholder_input')"
          v-model="input"
          :disabled="!userInfo"
          style="width: 200px"
          class="align-right"
          :suffix-icon="Search"
          maxlength="32"
          @keydown.enter="searchArticle(input)"
      />
      <el-divider class="align-right" direction="vertical"/>

      <AvatarWithCard
          class="align-right"
          :user-info="userInfo"
          :handle-avatar-click="handleAvatarClick"
      >
        <template #main v-if="!userInfo">
          <div>
            <h2 style="margin: 120px 0; text-align: center">
              {{ $t('message.avatar_with_card.label_no_login') }}
            </h2>
          </div>
        </template>

        <template #extra>
          <el-button
              @click="logout"
              class="logoutButton"
          >
            {{ $t('message.avatar_with_card.button_logout') }}
          </el-button>
        </template>

      </AvatarWithCard>

      <el-icon
          class="align-right moreIcon"
          style="transform: rotate(90deg)"
          @click="handleIconClick()"
      >
        <MoreFilled/>
      </el-icon>
    </el-row>
  </el-menu>

  <SettingBox
      :key="isShowSetting"
      :is-show-setting="isShowSetting"
      :close-setting="closeSetting"
  />

</template>

<script setup>
import {ref, computed} from "vue"
import {MoreFilled, Search} from "@element-plus/icons-vue";
import {useRouter} from "vue-router";
import {useStore} from "vuex";
import AvatarWithCard from "@/components/AvatarWithCard";
import {addMessage} from "@/scripts/utils/messageUtils";
import SettingBox from "@/components/setting_box/SettingBox";
import {useI18n} from "vue-i18n"
import {logout, needLogin} from "@/scripts/api/handleUserApi";

const router = useRouter()
const store = useStore()
const {t} = useI18n()

const userInfo = computed(()=>store.getters.getUserInfo)

const isShowSetting = ref(false)

const input = ref("")

const searchArticle = (keyWord) => {
  if(keyWord.length === 0) {
    addMessage(t('message.top_menu.input_missing_word_msg'))
    return
  }
  router.push({path: "/search", query: {word: keyWord}})
}

const handleBannerClick = ()=>{
  router.push("/guide")
}

const handleIconClick = () => {
  isShowSetting.value = true
}

const handleAvatarClick = async () => {
  if(await needLogin(""))
    await router.push("/student")
}

const closeSetting = () => {
  isShowSetting.value = false
}

</script>

<style scoped>

.topMenu{
  border-right: none;
}

.banner{
  width: 15%;
  height: 15%;
  margin: 10px;
}

.banner:hover{
  cursor: pointer;
}

.align-right{
  margin: auto 10px auto auto;
}

.moreIcon{
  color: var(--el-color-info-dark-2)
}

.moreIcon:hover{
  color: var(--el-color-primary-light-3);
  cursor: pointer;
}

.logoutButton{
  width: calc(100% - 20px);
  margin: 10px;
  height: 40px;
}

</style>