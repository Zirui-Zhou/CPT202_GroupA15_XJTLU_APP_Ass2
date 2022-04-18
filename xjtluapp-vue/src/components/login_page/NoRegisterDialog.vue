<template>
  <el-dialog title="Information" width="35%" :model-value="isShow" @close="closeDialog()">
    <div class="content">
      <div>
        <p>Sorry, this inner app does not provide self registration.</p>
        <p>Please visit
          <a class="link" href="https://www.learningmall.cn/mod/resource/view.php?id=211163" target="_blank">this link</a>
           to acquire the account list.
        </p>
        <p>Here gives an example of the account format:</p>
        <table style="border-spacing: 10px">
          <tr>
            <td>Username:</td>
            <td>zirui.zhou</td>
          </tr>
          <tr>
            <td>Password:</td>
            <td>zirui.zhou</td>
          </tr>
        </table>
        <p>Click the "Confirm" button to fill in.</p>
      </div>
    </div>
    <template #footer>
      <span class="dialog-footer">
        <el-button size="large" @click="closeDialog">Cancel</el-button>
        <el-button size="large" type="primary" @click="()=>{closeDialog(); fillInputFunc()}">Confirm</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup>
import {defineProps} from "vue";

const props = defineProps({
  isShow: Boolean,
  closeDialog: Function,
  fillInputFunc: Function,
})

</script>

<style scoped>

.content{
  display: flex;
  justify-content: center;
  font-size: 18px;
}

.link{
  color: #0000FF
}

</style>