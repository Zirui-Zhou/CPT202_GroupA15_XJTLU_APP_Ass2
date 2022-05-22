<template>
  <div class="SettingBox">
    <el-drawer
        v-model="isShowSetting"
        :title="$t('message.setting_box.box_title')"
        direction="ltr"
        :size="'280px'"
        ref="SettingDrawerRef"
    >

      <ul
          :class="item.class"
          v-for="item in listTypeList"
          :key="[locale.value, item['class']]"
      >
        <li
            class="el-menu el-menu-item"
            v-for="(item, index) in getSettingList(item.items)"
            :key="index"
            @click="item[1]"
        >
          <el-icon v-if="item[3]">
            <component
                :is="item[3]()"
                style="width: 1em; height: 1em; margin-right: 8px"
            />
          </el-icon>
          <span>
            {{ item[0]() }}
          </span>
        </li>
      </ul>

    </el-drawer>
  </div>

  <ChangePasswordBox ref="ChangePasswordDialogRef"/>

  <AboutDialog ref="AboutDialogRef"/>

</template>

<script>

</script>

<script setup>
import { defineExpose, reactive, ref, computed } from "vue";
import { useI18n } from "vue-i18n"
import { useStore } from "vuex";
import { logout } from "@/scripts/api/handleUserApi";
import AboutDialog from "@/components/setting_box/AboutDialog"
import ChangePasswordBox from "@/components/setting_box/ChangePasswordBox";
import TranslationIcon from "@/components/icon/TranslationIcon"
import GitHubIcon from "@/components/icon/GitHubIcon"

const {t, locale, availableLocales} = useI18n()
const store = useStore()

const userInfo = computed(()=>store.getters.getUserInfo)
const isShowSetting = ref(false)

const SettingDrawerRef = ref(null)
const ChangePasswordDialogRef = ref(null)
const AboutDialogRef = ref(null)

const openSetting = () => {
  isShowSetting.value = true
}

defineExpose({
  openSetting
})

const logoutUser = () => {
  SettingDrawerRef.value.close()
  logout()
}

const changeDarkMode = () => {
  store.commit("SET_DARK_MODE", !store.getters.getIsDarkMode)
}

const defineDarkModeIcon = () => {
  return store.getters.getIsDarkMode ? "Moon" : "Sunny"
}

const changeLanguage = () => {
  const nextIndex = (availableLocales.indexOf(locale.value) + 1) % availableLocales.length
  store.commit("SET_LANG", availableLocales[nextIndex])
}

const linkToGitHub = () => {
  window.open(store.getters.getGitHubUrl)
}

const settingTopList = reactive([
  [()=>t('message.setting_box.item_change_dark_mode'), changeDarkMode, false, defineDarkModeIcon],
  [()=>t('message.setting_box.item_language') + t('language'), changeLanguage, false, ()=>TranslationIcon],
  [()=>t('message.setting_box.item_change_password'), ()=>ChangePasswordDialogRef.value.openDialog(), true],
  [()=>t('message.setting_box.item_logout'), logoutUser, true],
])

const settingBottomList = reactive([
  [()=>t('message.setting_box.item_github'), ()=>linkToGitHub(), false, ()=>GitHubIcon],
  [()=>t('message.setting_box.item_about'), ()=>AboutDialogRef.value.openDialog(), false, ()=>"InfoFilled"]
])

const getSettingList = (settingList) => {
  if(userInfo.value){
    return settingList
  } else {
    return settingList.filter((item)=>item[2]===false)
  }
}

const listTypeList = reactive([
  {class: "settingTopList", items: settingTopList},
  {class: "settingBottomList", items: settingBottomList},
])
</script>

<style>
.SettingBox .el-drawer__header {
  margin-bottom: 0;
}
</style>

<style lang="scss" scoped>
.SettingBox {
  .el-menu-item {
    border: none;
  }
  .settingTopList {
    padding: 0
  }
  .settingBottomList {
    padding: 0;
    position: absolute;
    bottom: 0;
    // 40px is the padding of the drawer.
    width: calc(100% - 40px);
  }
}

</style>