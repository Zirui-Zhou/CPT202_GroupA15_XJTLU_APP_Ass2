<template>
  <el-upload
      class="avatar-uploader"
      action="http://localhost:8081/upload"
      :headers="{Authorization: store.getters.getToken}"
      list-type="picture-card"
      :file-list="fileList"
      :on-success="handleAvatarSuccess"
      :on-preview="handlePictureCardPreview"
      :on-remove="handleRemove"
      :before-upload="beforeAvatarUpload"
  >

    <el-icon class="avatar-uploader-icon"><Plus /></el-icon>

  </el-upload>

  <el-dialog v-model="dialogVisible">
    <img :src="dialogImageUrl" alt="Preview Image" style="width:100%; object-fit: contain"/>
  </el-dialog>

</template>

<script setup>
import {ref, reactive, onMounted, computed} from 'vue'
import { ElMessage } from 'element-plus'
import { Plus } from '@element-plus/icons-vue'
import {useStore} from "vuex";
import {handleResourceUrl} from "@/scripts/requestUtils";

const store = useStore()

const fileList = reactive([])
const isUploadShow = ref(true)

const userInfo = computed(()=>store.getters.getUserInfo)

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
  //   ElMessage.error('Avatar picture must be JPG format.')
  //   return false
  // } else
  if (rawFile.size / 1024 / 1024 > 10) {
    ElMessage.error('Avatar picture size cannot exceed 2MB.')
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

onMounted(async ()=>{
  if(userInfo.value) {
    if(userInfo.value.avatar) {
      fileList.push({url: userInfo.value.avatar})
      isUploadShow.value = false
    }
  }
})

</script>

<style scoped>
.avatar-uploader .avatar {
  width: 100px;
  height: 100px;
  display: block;
}
</style>

<style>
.avatar-uploader .el-upload {
  width: 100px;
  height: 100px;
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
}

.avatar-uploader .el-upload:hover {
  border-color: var(--el-color-primary);
}

.el-icon.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 100px;
  height: 100px;
  text-align: center;
}


.avatar-uploader .el-upload{
  transition: 0s;
  transition-delay: 0.5s;
}

.el-upload-list--picture-card  {
  margin: 0;
  display: block;
  --el-upload-list-picture-card-size: 100px;
}

.el-upload-list--picture-card .el-upload-list__item-thumbnail {
  object-fit: cover;
}

.avatar-uploader .el-upload {
  display: v-bind("isUploadShow === true ? 'block' : 'none'");
}

.el-upload-list__item.is-success .el-upload-list__item-status-label {
  display: none;
}

.el-upload-list--picture-card .el-upload-list__item {
  margin: 0;
}

</style>