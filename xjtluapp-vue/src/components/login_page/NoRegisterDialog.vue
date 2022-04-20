<template>
  <el-dialog
      :title="$t('message.no_register_dialog.dialog_title')"
      width="35%"
      :model-value="isShow"
      @close="closeDialog()"
  >
    <div class="content">
      <div
          v-html="$t('html.no_register_dialog.information')"
      />
    </div>
    <template #footer>
      <span class="dialog-footer">
        <el-button
            size="large"
            @click="closeDialog">
          {{ $t('message.no_register_dialog.button_cancel') }}
        </el-button>
        <el-button
            size="large"
            type="primary"
            @click="()=>{closeDialog(); fillInputFunc()}">
          {{ $t('message.no_register_dialog.button_confirm') }}
        </el-button>
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