<template>
  <div class="commentBox">
    <el-row >
    <h1>Comment</h1>
      <div class="title">numberofcomment</div>
    </el-row>
    <el-row>
      <div class="userAvatar" >
        <el-row >
          <el-row class="align-right">
            <AvatarWithCard />
            <div class="name">name</div>
          </el-row>
            <el-dropdown trigger="click" class="more">
              <span class="el-dropdown-link"><el-icon><more-filled /></el-icon></span>
              <template #dropdown>
                <el-dropdown-menu>
                  <el-dropdown-item :icon="WarningFilled">Report</el-dropdown-item>
                  <el-dropdown-item :icon="CirclePlusFilled">Join Blacklist</el-dropdown-item>
                </el-dropdown-menu>
              </template>
            </el-dropdown>
        </el-row>
      </div>
    </el-row>
    <div class="comment">
      comment
      <div class="reply">reply</div >
    </div>
    <br/>


  </div>
  <div class="addComment">
    <el-row>
      <el-input
          v-model="textarea"
          :rows="3"
          type="textarea"
          placeholder="Please input"
          class="input"
      />
      <el-button type="primary" class="clickButton">Confirm</el-button>

    </el-row>
  </div>


</template>

<script>
export default {
  data() {
    return {
      input: ''
    }
  }
}
</script>
<script setup>
import AvatarWithCard from "@/components/main_page/conmponents/AvatarWithCard";
import {
  MoreFilled,
  CirclePlusFilled,
  WarningFilled,
} from '@element-plus/icons-vue'
import { ref } from 'vue'
const textarea = ref('')
</script>



<style scoped>
.title{
  margin-top: 4%;
  margin-left: 2%;
  font-size: 14px;
}
.name{
  margin-top: 12%;
  margin-left: 20px;
}
.more{
  margin-top: 3%;
  margin-left: 650px;
}
.clickButton{
  width: 15%;
  margin: auto;
  min-height: 70px;
}
.input{
  width: 80%;
}
.addComment{
  margin: auto;
}


</style>