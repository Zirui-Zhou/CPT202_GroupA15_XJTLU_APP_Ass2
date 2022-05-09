<template>
  <div class="SettingBox">
    <el-drawer
        v-model="isShowSetting"
        :title="$t('message.setting_box.box_title')"
        direction="ltr"
        :size="'18%'"
        ref="SettingDrawerRef"
    >
      <ul style="padding: 0" :key="locale.value">
        <li
            class="el-menu el-menu-item"
            v-for="(item, index) in getSettingList(settingList)"
            :key="index"
            @click="item[1]"
        >
          <el-icon v-if="item[3]">
            <component :is="item[3]()"/>
          </el-icon>
          <span>
            {{ item[0]() }}
          </span>
        </li>
      </ul>

      <ul style="padding: 0; position: absolute; bottom: 0; width: calc(100% - 40px);" :key="locale.value">
        <li
            class="el-menu el-menu-item"
            v-for="(item, index) in getSettingList(settingBottomList)"
            :key="index"
            @click="item[1]"
        >
          <el-icon v-if="item[3]">
            <component :is="item[3]()"/>
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

<script setup>
import {defineExpose, reactive, ref, computed} from "vue";
import ChangePasswordBox from "@/components/setting_box/ChangePasswordBox";
import AboutDialog from "@/components/setting_box/AboutDialog"
import {logout} from "@/scripts/api/handleUserApi";
import {useStore} from "vuex";
import {useI18n} from "vue-i18n"

const store = useStore()
const {t, locale, availableLocales} = useI18n()

const userInfo = computed(()=>store.getters.getUserInfo)

const isShowSetting = ref(false)

const openSetting = () => {
  isShowSetting.value = true
}

defineExpose({
  openSetting
})

const SettingDrawerRef = ref(null)
const ChangePasswordDialogRef = ref(null)
const AboutDialogRef = ref(null)

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
  let nextIndex = availableLocales.indexOf(locale.value) + 1
  nextIndex = nextIndex >= availableLocales.length ? 0 : nextIndex
  store.commit("SET_LANG", availableLocales[nextIndex])
}

const settingList = reactive([
  [()=>t('message.setting_box.item_change_dark_mode'), changeDarkMode, false, defineDarkModeIcon],
  [()=>t('message.setting_box.item_language') + t('language'), changeLanguage, false],
  [()=>t('message.setting_box.item_change_password'), ()=>ChangePasswordDialogRef.value.openDialog(), true],
  [()=>t('message.setting_box.item_logout'), logoutUser, true],
])

const settingBottomList = reactive([
    [()=>t('message.setting_box.item_about'), ()=>AboutDialogRef.value.openDialog(), false, ()=>"InfoFilled"]
])

const getSettingList = (settingList) => {
  if(!userInfo.value){
    return settingList.filter((item)=>item[2]===false)
  } else {
    return settingList
  }
}

</script>

<style>
.SettingBox .el-drawer__header{
  margin-bottom: 0;
}
</style>

<style scoped>
.SettingBox .el-menu-item{
  border: none;
}
</style>