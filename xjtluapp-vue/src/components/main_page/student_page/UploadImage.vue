<template>
  <el-upload
      class="avatar-uploader"
      :action="store.getters.getServerUrl + '/user/avatar/upload'"
      :headers="{Authorization: store.getters.getToken}"
      list-type="picture-card"
      :file-list="fileList"
      :on-success="handleAvatarSuccess"
      :on-preview="handlePictureCardPreview"
      :on-remove="handleRemove"
      :before-upload="beforeAvatarUpload"
  >

    <el-icon class="avatar-uploader-icon">
      <Plus/>
    </el-icon>

  </el-upload>

  <el-dialog v-model="dialogVisible">
    <img
        class="imagePreview"
        :src="dialogImageUrl"
        alt="Preview Image"
    />
  </el-dialog>

</template>

<script setup>
import { ref, reactive, onMounted, computed } from 'vue'
import { useI18n } from "vue-i18n"
import { useStore } from "vuex";
import { Plus } from '@element-plus/icons-vue'
import { handleResourceUrl } from "@/scripts/utils/requestUtils";
import  {addMessage } from "@/scripts/utils/messageUtils";

const {t} = useI18n()
const store = useStore()

const userInfo = computed(()=>store.getters.getUserInfo)
const fileList = reactive([])
const isUploadShow = ref(true)
const dialogImageUrl = ref('')
const dialogVisible = ref(false)

const handleAvatarSuccess = (
    response,
    uploadFile
) => {
  const newUserInfo = userInfo.value
  newUserInfo["avatar"] = handleResourceUrl(response.msg)
  uploadFile.url = newUserInfo["avatar"]
  store.commit("SET_USERINFO", newUserInfo)
}

const beforeAvatarUpload = async (rawFile) => {
  // if (rawFile.type !== 'image/jpeg') {
  //   addMessage(t('message.upload_image.error_image_wrong_format', {format: "JPG"}), 'warning')
  //   return false
  // } else
  if (rawFile.size / 1024 / 1024 > 10) {
    addMessage(t('message.upload_image.error_image_oversize', {size: 2}), 'warning')
    return false
  }
  isUploadShow.value = false
  return true
}

const handlePictureCardPreview = (file) => {
  dialogImageUrl.value = file.url
  dialogVisible.value = true
}

const handleRemove = () => {
  fileList.pop()
  isUploadShow.value = true
}

onMounted(async ()=>{
  if(userInfo.value) {
    if(userInfo.value.avatar) {
      fileList.push({url: userInfo.value.avatar})
      isUploadShow.value = false
    }
  }
})
</script>

<style lang="scss">
.avatar-uploader {
  .el-upload {
    width: 100px;
    height: 100px;
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
    transition: var(--el-transition-duration-fast);
    transition-delay: 0.5s;
    display: v-bind("isUploadShow === true ? 'block' : 'none'");
  }
  .el-upload:hover {
     border-color: var(--el-color-primary);
  }
}

.el-icon.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 100px;
  height: 100px;
  text-align: center;
}

.el-upload-list--picture-card {
  margin: 0;
  display: block;
  --el-upload-list-picture-card-size: 100px;
  .el-upload-list__item-thumbnail {
    object-fit: cover;
  }
  .el-upload-list__item {
     margin: 0;
  }
}

.el-upload-list__item.is-success .el-upload-list__item-status-label {
  display: none;
}
</style>

<style scoped>
.avatar-uploader .avatar {
  width: 100px;
  height: 100px;
  display: block;
}

.imagePreview {
  width:100%;
  object-fit: contain;
}
</style>