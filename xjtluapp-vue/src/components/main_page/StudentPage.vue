<template>
  <div>
    <img class="demo-image" src="https://www.xjtlu.edu.cn/zh/assets/image-cache/images/campus/campus005.1f5be76d.jpg">
  </div>

  <el-row style="margin: 20px auto">
    <div style="margin: auto 0 auto auto">
    <UploadImage/>
    </div>
    <el-descriptions
        :column="2"
        border
        style="margin: auto"
    >
      <el-descriptions-item v-for="([key, value], index) in Object.entries(unref(userInfoList))" :key="index">
        <template #label>
          <div class="label" style="text-transform: capitalize">{{ key }}</div>
        </template>
        <div class="content">{{ value }}</div>
      </el-descriptions-item>
    </el-descriptions>
  </el-row>

  <div>
    <el-tabs v-model="activeName" class="demo-tabs" >
      <el-tab-pane label="Mine" name="first"></el-tab-pane>
      <el-tab-pane label="History" name="second"></el-tab-pane>
      <el-tab-pane label="Favourite" name="third"></el-tab-pane>
    </el-tabs>
  </div>

  <br/>

  <TimeLineList/>

</template>

<script>


export default {
  name: "StudentPage",

}
</script>

<script setup>
import UploadImage from "@/components/main_page/conmponents/UploadImage"
import {reactive, unref, ref, computed} from "vue";
import TimeLineList from "@/components/main_page/conmponents/TimeLineCardList";
import {useStore} from "vuex";

const activeName = ref()

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

.demo-image{
  background-color: #4a97fc;
  width: 100%;
  height: 200px;
  text-align: center;
}

.label{
  min-width: 50px;
}
.content{
  min-width: 240px;
}

</style>