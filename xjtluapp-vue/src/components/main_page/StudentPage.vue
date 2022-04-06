<template>
  <div class="demo-image">
    Image
  </div>
  <br/>

  <div class="common-layout">
    <el-container>
      <el-main>
        <el-row class="demo-avatar demo-basic">
          <UploadImage/>
          <el-descriptions
              class="margin-top"
              :column="2"
              :size="size"
              border
          >
            <el-descriptions-item>
              <template #label>
                <div class="label">Name</div>
              </template>
              <div class="content"><!--Name--></div>
            </el-descriptions-item>

            <el-descriptions-item>
              <template #label>
                <div class="label">Major</div>
              </template>
              <div class="content"><!--major--></div>
            </el-descriptions-item>

            <el-descriptions-item>
              <template #label>
                <div class="label">Id</div>
              </template>
              <div class="content"><!--id--></div>
            </el-descriptions-item>

            <el-descriptions-item>
              <template #label>
                <div class="label">Grade</div>
              </template>
              <div class="content"><!--Grade--></div>
            </el-descriptions-item>

          </el-descriptions>
        </el-row>
      </el-main>
    </el-container>
  </div>
  <br/>

  <div>
    <el-tabs type="border-card" v-model="activeName" class="demo-tabs" @tab-click="handleClick" >
      <el-tab-pane class="adf" label="History" name="first"></el-tab-pane>
      <el-tab-pane label="Favourite" name="second"></el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>


export default {
  name: "StudentPage",

}
</script>

<script setup>
import UploadImage from "@/components/main_page/UploadImage"
</script>

<style scoped>

.common-layout{
  margin: auto;
}

.demo-image{
  background-color: #4a97fc;
  width: 100%;
  line-height: 200px;
  margin: 0 auto;
  text-align: center;
}

.margin-top {
  margin-left: 20px;
  min-width: 200px;
}
.label{
  min-width: 50px;
}
.content{
  min-width: 240px;
}
.demo-tabs > .el-tabs__content {
  padding: 32px;
  color: #6b778c;
  font-size: 32px;
  font-weight: 600;
}
</style>