<template>
  <div class="SettingBox">
    <el-drawer
        :model-value="isShowSetting"
        title="Setting"
        direction="ltr"
        @close="closeSetting()"
        :size="'18%'"
        ref="SettingBoxRef"
    >
      <ul style="padding: 0">
        <li
            class="el-menu el-menu-item"
            v-for="(item, index) in userInfoList"
            :key="index"
            @click="item[1]"
        >
          <span style="font-weight: bold">{{item[0]}}</span>
        </li>
      </ul>
    </el-drawer>
  </div>

  <ChangePasswordBox
      :is-show-pass-box="isShowPassBox"
      :close-pass-box="closePassBox"
  />

</template>

<script setup>
import {defineProps, reactive, ref} from "vue";
import ChangePasswordBox from "@/components/ChangePasswordBox";
import {logout} from "@/scripts/handleUserApi";

const props = defineProps({
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

const userInfoList = reactive([
  ["Change Password", openPassBox],
  ["Logout", logoutUser]
])

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