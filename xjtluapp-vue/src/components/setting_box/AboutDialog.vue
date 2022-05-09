<template>
  <el-dialog
      v-model="isShowDialog"
      :title="$t('message.about_dialog.dialog_title')"
      width="35%"
  >
    <h4 style="text-align: center;">
      {{ $t('localization_acknowledgement') }}
    </h4>

    <figure>
      <blockquote>
        <p style="white-space: pre-line">
          {{ $t('extra.internationale.lyric') }}
        </p>
      </blockquote>
      <figcaption>
        {{ $t('extra.internationale.author') }}
        <cite>{{ $t('extra.internationale.title') }}</cite>
      </figcaption>
    </figure>

    <template #footer>
      <span class="dialog-footer" style="text-align: center">
        <el-button
            type="primary"
            @click="isShowDialog = false"
        >
          {{ $t('message.about_dialog.button_submit') }}
        </el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup>
import { ref } from 'vue'
import { defineExpose } from "vue";

const isShowDialog =ref(false)

const openDialog = () => {
  isShowDialog.value = true
}

defineExpose({
  openDialog,
})

</script>
<style scoped>
.dialog-footer button:first-child {
  margin-right: 10px;
}
blockquote {
  margin: 0;
}

blockquote p {
  padding: 15px;
  background: #eee;
  border-radius: 5px;
}

blockquote p::before {
  content: '\201C';
}

blockquote p::after {
  content: '\201D';
}
</style>