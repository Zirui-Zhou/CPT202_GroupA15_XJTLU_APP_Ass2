<template>
  <el-dialog
      :title="$t('message.no_register_dialog.dialog_title')"
      width="550px"
      v-model="isShowDialog"
  >
    <div class="content">
      <div style="margin: auto" v-html="$t('html.no_register_dialog.information')"/>
    </div>

    <template #footer>
      <span class="dialog-footer">
        <el-button
            size="large"
            type="default"
            @click="isShowDialog=false">
          {{ $t('message.no_register_dialog.button_cancel') }}
        </el-button>
        <el-button
            size="large"
            type="primary"
            @click="fillInputFunc(); isShowDialog=false">
          {{ $t('message.no_register_dialog.button_confirm') }}
        </el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup>
import { defineProps, ref, defineExpose } from "vue";

const isShowDialog = ref(false)

const openDialog = () => {
  isShowDialog.value = true
}

defineProps({
  fillInputFunc: Function,
})

defineExpose({
  openDialog,
})

</script>

<style scoped>
.content {
  display: flex;
  justify-content: center;
  font-size: 18px;
}

.link{
  color: #0000FF
}
</style>