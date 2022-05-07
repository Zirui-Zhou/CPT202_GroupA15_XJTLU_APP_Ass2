<template>
  <el-upload
      class="article-uploader"
      :action="store.getters.getServerUrl + '/upload'"
      :headers="{Authorization: store.getters.getToken}"
      list-type="picture-card"
      :file-list="fileList"
      :on-success="handleAvatarSuccess"
      :on-preview="handlePictureCardPreview"
      :on-remove="handleRemove"
      :before-upload="beforeAvatarUpload"
      drag
  >
    <el-icon class="el-icon--upload"><UploadFilled/></el-icon>
    <div class="el-upload__text">
      Drop file here or <em>click to upload</em>
    </div>
  </el-upload>

  <el-dialog v-model="dialogVisible">
    <img :src="dialogImageUrl" alt="Preview Image" style="width:100%; object-fit: contain"/>
  </el-dialog>

</template>

<script setup>
import { ref, reactive } from 'vue'
import { ElMessage } from 'element-plus'
import { useStore } from "vuex";
import { useI18n } from "vue-i18n"
import { UploadFilled } from "@element-plus/icons-vue"

const store = useStore()
const {t} = useI18n()

const fileList = reactive([])
const isUploadShow = ref(true)

const handleAvatarSuccess = (
    response,
    uploadFile
) => {
}

const beforeAvatarUpload = async (rawFile) => {
  // if (rawFile.type !== 'image/jpeg') {
  //   ElMessage.error(t('message.upload_image.error_image_wrong_format', {format: "JPG"}))
  //   return false
  // } else
  if (rawFile.size / 1024 / 1024 > 10) {
    ElMessage.error(t('message.upload_image.error_image_oversize', {size: 2}))
    return false
  }
  isUploadShow.value = false
  return true
}

const dialogImageUrl = ref('')
const dialogVisible = ref(false)

const handlePictureCardPreview = (file) => {
  dialogImageUrl.value = file.url
  dialogVisible.value = true
}

const handleRemove = () => {
  fileList.pop()
  isUploadShow.value = true
}

</script>

<style scoped>
.avatar-uploader .avatar {
  height: 110px;
  width: 165px;
  display: block;
}
</style>

<style lang="scss">
.article-uploader {
  .el-upload:hover {
    border-color: var(--el-color-primary);
  }
  .el-upload{
    height: 110px;
    width: 165px;
    border: none;
    display: v-bind("isUploadShow === true ? 'block' : 'none'");
  }
  .el-upload-dragger{
    height: 110px;
    width: 165px;
  }
  .el-icon--upload{
    margin: 0;
    font-size: 60px;
    z-index: 100;
  }
  .el-upload__text{
    font-size: 10px;
  }
  .el-upload-list--picture-card  {
    margin: 0;
    border: none;
    .el-upload-list__item {
      height: 110px;
      width: 165px;
      margin: 0;
    }
    .el-upload-list__item-thumbnail {
      object-fit: cover;
    }
  }
}

.el-upload-list__item.is-success .el-upload-list__item-status-label {
  display: none;
}

</style>