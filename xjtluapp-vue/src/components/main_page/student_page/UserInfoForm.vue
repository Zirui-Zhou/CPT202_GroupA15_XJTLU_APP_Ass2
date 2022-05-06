<template>
  <el-row style="margin: 20px auto">

    <div style="margin: auto 0 auto auto">
      <UploadImage/>
    </div>

    <el-descriptions
        :column="2"
        border
        style="margin: auto"
        class="userInfoForm"
    >
      <el-descriptions-item
          v-for="([key, value], index) in unref(userInfoList)"
          :key="index"
      >
        <template #label>
          <div class="label" style="text-transform: capitalize">
            {{ key() }}
          </div>
        </template>
        <div class="content" style="display: flex">
          <span>{{ value }}</span>
        </div>
      </el-descriptions-item>
    </el-descriptions>
  </el-row>

</template>

<script setup>
import UploadImage from "@/components/main_page/student_page/UploadImage"
import {computed, reactive, unref} from "vue";
import {useStore} from "vuex";
import {useI18n} from "vue-i18n"

const store = useStore()
const {t} = useI18n()

const userInfo = computed(()=>store.getters.getUserInfo)

const userInfoList = reactive([
  [()=>t('message.userinfo_form.userinfo_label_name'), userInfo.value.realName],
  [()=>t('message.userinfo_form.userinfo_label_major'), userInfo.value.major],
  [()=>t('message.userinfo_form.userinfo_label_id'), userInfo.value.realId],
  [()=>t('message.userinfo_form.userinfo_label_grade'), userInfo.value.semester],
])

</script>

<style>

/* For the dark mode */
.userInfoForm .el-descriptions__label.el-descriptions__cell.is-bordered-label{
  background-color: var(--el-color-info-light-9);;
}

</style>

<style scoped>
.label{
  min-width: 50px;
}

.content{
  min-width: 240px;
}

.editIcon{
  margin: auto 0 auto auto;
  color: var(--el-color-info-light-3)
}

.editIcon:hover{
  margin: auto 0 auto auto;
  color: var(--el-color-primary-light-3);
  cursor: pointer;
}
</style>