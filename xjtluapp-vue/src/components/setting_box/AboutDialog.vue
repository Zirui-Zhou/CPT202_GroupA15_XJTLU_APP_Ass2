<template>
  <el-dialog
      v-model="isShowDialog"
      :title="$t('message.about_dialog.dialog_title')"
      width="500px"
  >
    <h4 style="text-align: center;">
      {{ $t('localization_acknowledgement') }}
    </h4>

    <figure>
      <blockquote>
        <p style="white-space: pre-line;">
          {{ $t('extra.internationale.lyric') }}
        </p>
      </blockquote>
      <figcaption>
        {{ $t('extra.internationale.author') }}
        <cite>{{ $t('extra.internationale.title') }}</cite>
      </figcaption>
    </figure>

    <template #footer>
      <span class="dialog-footer">
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
import { ref, defineExpose } from 'vue'

const isShowDialog = ref(false)

const openDialog = () => {
  isShowDialog.value = true
}

defineExpose({
  openDialog,
})

</script>
<style lang="scss" scoped>
.dialog-footer {
  text-align: center;
}

blockquote {
  margin: 0;
  p {
    padding: 15px;
    background: #eee;
    border-radius: 5px;
  }
  p::before {
     content: '\201C';
  }
  p::after {
    content: '\201D';
  }
}
</style>