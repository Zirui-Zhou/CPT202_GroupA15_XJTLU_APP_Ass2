<template>
  <el-upload
      class="avatar-uploader"
      action="http://localhost:8081/upload"
      :show-file-list="false"
      :on-success="handleAvatarSuccess"
      :before-upload="beforeAvatarUpload"
  >
    <img v-if="imageUrl" :src="imageUrl" class="avatar" />
    <el-icon v-else class="avatar-uploader-icon"><Plus /></el-icon>
  </el-upload>
</template>

<script>
export default {
  name: "UploadImage"
}
</script>

<script setup>
import { ref } from 'vue'
import { ElMessage } from 'element-plus'
import { Plus } from '@element-plus/icons-vue'

const imageUrl = ref('')

const handleAvatarSuccess = (
    response,
    uploadFile
) => {
  // imageUrl.value = URL.createObjectURL(uploadFile.raw)
  imageUrl.value = response.msg
}

const beforeAvatarUpload = async (rawFile) => {
  if (rawFile.type !== 'image/jpeg') {
    ElMessage.error('Avatar picture must be JPG format.')
    return false
  } else if (rawFile.size / 1024 / 1024 > 2) {
    ElMessage.error('Avatar picture size cannot exceed 2MB.')
    return false
  }

  // let param = new FormData(); //创建form对象
  // param.append('file', rawFile);//通过append向form对象添加数据
  // console.log(param.get('file')); //FormData私有类对象，访问不到，可以通过get判断值是否传进去
  // // let config = {
  // //   headers:{'Content-Type':'multipart/form-data'} //这里是重点，需要和后台沟通好请求头，Content-Type不一定是这个值
  // // }; //添加请求头
  // // await axios.post('http://localhost:8081/upload',param,config)
  // await axios.post('http://localhost:8081/upload',param)
  //     .then(response=>{
  //       console.log(response.data);
  //     })

  return true
}
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
  width: 178px;
  height: 178px;
  text-align: center;
}
</style>