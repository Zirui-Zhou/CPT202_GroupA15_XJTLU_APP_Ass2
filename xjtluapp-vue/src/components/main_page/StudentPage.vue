<template>
  <div class="demo-image">
    Image
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
      <el-descriptions-item v-for="([key, value], index) in Object.entries(unref(userinfo))" :key="index">
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
import {reactive, unref, ref} from "vue";
import TimeLineList from "@/components/main_page/conmponents/TimeLineCardList";

const activeName = ref()

const userinfo = reactive({
  name: "Ruibao",
  major: "ICS",
  id: "1927924",
  grade: "Y3",
})

</script>

<style scoped>

.demo-image{
  background-color: #4a97fc;
  width: 100%;
  line-height: 200px;
  text-align: center;
}

.label{
  min-width: 50px;
}
.content{
  min-width: 240px;
}

</style>