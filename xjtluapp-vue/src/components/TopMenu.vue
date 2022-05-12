<template>

  <el-image
      class="banner"
      :src="require('@/assets/xjtlu_name.svg')"
      @click="handleBannerClick"
  />

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
          class="align-right input"
          :suffix-icon="Search"
          maxlength="32"
          @keydown.enter="searchArticle(input)"
      />

      <el-divider
          class="align-right"
          direction="vertical"
      />

      <AvatarWithCard
          class="align-right"
          :user-info="userInfo"
          :handle-avatar-click="handleAvatarClick"
      >
        <template #main v-if="!userInfo">
          <div>
            <h2 class="noLoginBanner">
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
          @click="handleMoreIconClick"
      >
        <MoreFilled/>
      </el-icon>
    </el-row>
  </el-menu>

  <SettingDrawer
      ref="SettingDrawerRef"
  />

</template>

<script setup>
import { ref, computed } from "vue"
import { useI18n } from "vue-i18n"
import { useRouter } from "vue-router";
import { useStore } from "vuex";
import { MoreFilled, Search } from "@element-plus/icons-vue";
import { addMessage } from "@/scripts/utils/messageUtils";
import { logout, needLogin } from "@/scripts/api/handleUserApi";
import AvatarWithCard from "@/components/AvatarWithCard";
import SettingDrawer from "@/components/setting_box/SettingDrawer";

const {t} = useI18n()
const router = useRouter()
const store = useStore()

const userInfo = computed(()=>store.getters.getUserInfo)
const input = ref("")

const SettingDrawerRef = ref(null)

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

const handleMoreIconClick = () => {
  SettingDrawerRef.value.openSetting()
}

const handleAvatarClick = async () => {
  if(await needLogin(""))
    await router.push("/student")
}
</script>

<style scoped>
.align-right {
  margin: auto 10px auto auto;
}

.topMenu {
  border-right: none;
}

.banner {
  width: 15%;
  height: 15%;
  margin: 10px;
}

.banner:hover {
  cursor: pointer;
}

.input {
  width: 200px
}

.moreIcon {
  color: var(--el-color-info-dark-2);
  transform: rotate(90deg);
}

.moreIcon:hover {
  color: var(--el-color-primary-light-3);
  cursor: pointer;
}

.logoutButton {
  width: calc(100% - 20px);
  margin: 10px;
  height: 40px;
}

.noLoginBanner {
  margin: 120px 0;
  text-align: center;
}
</style>