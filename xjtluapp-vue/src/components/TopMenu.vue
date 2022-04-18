<template>

  <img src="@/assets/xjtlu_banner.svg" class="banner" @click="handleBannerClick()">

  <el-menu
      :default-active="router.currentRoute.value.path"
      class="el-menu-demo"
      mode="horizontal"
      router
  >
    <el-menu-item index="/student">
      <template #title>Student</template>
    </el-menu-item>
    <el-menu-item index="/home">
      <template #title>Home</template>
    </el-menu-item>
    <el-menu-item index="/guide">
      <template #title>Guide</template>
    </el-menu-item>
    <el-menu-item index="/module">
      <template #title>Module</template>
    </el-menu-item>

    <el-row class="align-right">
      <el-input
          placeholder="Please input"
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
          :is-self="true"
      />

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
import {addMessage} from "@/scripts/messageUtils";
import SettingBox from "@/components/SettingBox";

const router = useRouter()
const store = useStore()

const userInfo = computed(()=>store.getters.getUserInfo)

const isShowSetting = ref(false)

const input = ref("")

const searchArticle = (keyWord) => {
  if(keyWord.length === 0) {
    addMessage("Please input search keyword.")
    return
  }
  router.push({path: "/search", query: {word: keyWord}})
}

const handleBannerClick = ()=>{
  router.push("/guide")
}

const handleIconClick = () => {
  if(userInfo.value) {
    isShowSetting.value = true
  }
}

const closeSetting = () => {
  isShowSetting.value = false
}

</script>

<style scoped>
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
  cursor: v-bind("userInfo ? 'pointer' : 'not-allowed'");
}

</style>