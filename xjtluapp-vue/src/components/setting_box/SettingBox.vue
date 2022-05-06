<template>
  <div class="SettingBox">
    <el-drawer
        :model-value="isShowSetting"
        :title="$t('message.setting_box.box_title')"
        direction="ltr"
        @close="closeSetting()"
        :size="'18%'"
        ref="SettingBoxRef"
    >
      <ul style="padding: 0" :key="locale.value">
        <li
            class="el-menu el-menu-item"
            v-for="(item, index) in getSettingList()"
            :key="index"
            @click="item[1]"
        >
          <el-icon v-if="item[3]">
            <component :is="item[3]()"/>
          </el-icon>
          <span>
            {{item[0]()}}
          </span>
        </li>
      </ul>
    </el-drawer>
  </div>

  <ChangePasswordBox
      :is-show-pass-box="isShowPassBox"
      :close-pass-box="closePassBox"
  />

</template>

<script>
import {Moon, Sunny} from "@element-plus/icons-vue";
export default {
  components:{
    Moon,
    Sunny,
  }
}
</script>

<script setup>
import {defineProps, reactive, ref, computed} from "vue";
import ChangePasswordBox from "@/components/setting_box/ChangePasswordBox";
import {logout} from "@/scripts/api/handleUserApi";
import {useStore} from "vuex";
import {useI18n} from "vue-i18n"

const store = useStore()
const {t, locale, availableLocales} = useI18n()

const userInfo = computed(()=>store.getters.getUserInfo)

defineProps({
  isShowSetting: Boolean,
  closeSetting: Function
})

const isShowPassBox = ref(false)
const SettingBoxRef = ref(null)

const openPassBox = () => {
  isShowPassBox.value = true
}

const closePassBox = () => {
  isShowPassBox.value = false
}

const logoutUser = () => {
  SettingBoxRef.value.close()
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
  locale.value = availableLocales[nextIndex]
}

const settingList = reactive([
  [()=>t('message.setting_box.item_change_dark_mode'), changeDarkMode, false, defineDarkModeIcon],
  [()=>t('message.setting_box.item_language') + t('language'), changeLanguage, false],
  [()=>t('message.setting_box.item_change_password'), openPassBox, true],
  [()=>t('message.setting_box.item_logout'), logoutUser, true],
])

const getSettingList = () => {
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