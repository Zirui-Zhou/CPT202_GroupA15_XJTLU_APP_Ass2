<template>

    <h1>Comments</h1>
    <el-row style="display:flex; justify-content:space-between;margin: auto 32px; min-height: 400px">
      <AvatarWithCard :user-info="userInfo"/>
      <el-input
          class="commentInput"
          v-model="textarea"
          type="textarea"
          placeholder="Please input"
          resize="none"
          :autosize="{minRows:3}"
          :maxlength="256"
          show-word-limit
      />
      <el-button
          type="primary"
          class="commentButton"
          plain
      >
        Confirm
      </el-button>
    </el-row>

<!--            <el-dropdown trigger="click" class="more">-->
<!--              <span class="el-dropdown-link"><el-icon><more-filled /></el-icon></span>-->
<!--              <template #dropdown>-->
<!--                <el-dropdown-menu>-->
<!--                  <el-dropdown-item :icon="WarningFilled">Report</el-dropdown-item>-->
<!--                  <el-dropdown-item :icon="CirclePlusFilled">Join Blacklist</el-dropdown-item>-->
<!--                </el-dropdown-menu>-->
<!--              </template>-->
<!--            </el-dropdown>-->

</template>

<script setup>
import AvatarWithCard from "@/components/AvatarWithCard";
import {
  MoreFilled,
  CirclePlusFilled,
  WarningFilled,
} from '@element-plus/icons-vue'
import { ref, computed } from 'vue'
import {useStore} from "vuex";

const store = useStore()

const textarea = ref('')

const userInfo = computed(()=>store.getters.getUserInfo)

</script>

<style scoped>

.commentButton{
  font-size: 18px;
  padding:18px;
}

.commentInput{
  width: 75%;
  margin-top: 0;
  margin-bottom: auto;
  font-size: 16px;
}

</style>