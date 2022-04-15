<template>
  <el-row style="margin: 20px auto">

    <div style="margin: auto 0 auto auto">
      <UploadImage/>
    </div>

    <el-descriptions
        :column="2"
        border
        style="margin: auto"
    >
      <el-descriptions-item
          v-for="([key, value], index) in Object.entries(unref(userInfoList))"
          :key="index"
      >
        <template #label>
          <div class="label" style="text-transform: capitalize">{{ key }}</div>
        </template>
        <div class="content" style="display: flex">
          <span>{{ value }}</span>
        </div>
      </el-descriptions-item>
    </el-descriptions>
  </el-row>

</template>

<script setup>
import UploadImage from "@/components/main_page/conmponents/UploadImage"
import {computed, reactive, unref} from "vue";
import {useStore} from "vuex";

const store = useStore()

const userInfo = computed(()=>store.getters.getUserInfo)

const userInfoList = reactive({
  Name: userInfo.value.realName,
  Major: userInfo.value.major,
  Id: userInfo.value.realId,
  Grade: userInfo.value.semester,
})

</script>

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