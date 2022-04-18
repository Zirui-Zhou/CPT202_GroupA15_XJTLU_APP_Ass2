<template>
  <el-container>

    <el-header class="deep-color center">
      <img src="../../assets/xjtlu_badge.png" alt="app" class="xjtlu_badge">
      <span class="banner">Student App</span>
    </el-header>

    <el-main class="light-color center">
      <el-form style="width: 80%" :rules="rules" :model="ruleForm" ref="ruleFormDom">
        <el-form-item prop="username">
          <el-input :prefix-icon="Avatar" size="large" v-model="ruleForm.username" placeholder="Username"/>
        </el-form-item>

        <el-form-item prop="password">
          <el-input :prefix-icon="Key" size="large" v-model="ruleForm.password" placeholder="Password" show-password/>
        </el-form-item>

        <el-form-item>
          <el-button size="large" class="button" type="primary" @click="submitForm()">Register</el-button>
        </el-form-item>

        <el-form-item>
          <el-button size="large" class="button" type="default" @click="$router.push('/user/login')">Have an account?</el-button>
        </el-form-item>
      </el-form>
    </el-main>

  </el-container>
</template>

<script setup>
import {ref, unref, reactive} from 'vue'
import {ElMessage} from 'element-plus'
import {Avatar, Key} from "@element-plus/icons-vue"
import axios from "axios"
import {useStore} from "vuex"

const store = useStore()

const ruleForm = reactive({
  username: '',
  password: '',
})

const rules = reactive({
  username: [
    { required: true, message: 'Please input your username', trigger: 'blur' },
  ],
  password: [
    { required: true, message: 'Please input your password', trigger: 'change' }
  ],
})

const ruleFormDom = ref(null)

const submitForm = () => {
  const form = unref(ruleFormDom)
  form.validate((valid) => {
    if (!valid) {
      ElMessage({
        message: 'Please input the correct info.',
        type: 'error',
      })
      return false;
    }

    axios.post('http://localhost:8081/login', ruleForm).then(res => {
      const jwt = res.headers['Authorization']
      const userInfo = res.data.data
      store.commit("SET_TOKEN", jwt)
      store.commit("SET_USERINFO", userInfo)
      ElMessage({
        message: '啊对对对',
        type: 'success',
      })
    }).catch(error => {
      ElMessage({
        message: error.response.data.msg,
        type: 'error',
      })
    })
  });
}
</script>

<style scoped>

.deep-color{
  background-color: rgba(255,255,255,0.8);
}

.light-color{
  background-color: rgba(255,255,255,0.5);
}

.center{
  display: flex;
  justify-content: center;
  align-items: center;
}

.banner{
  font-size: 200%;
  font-weight: bold;
  margin: 10px;
}

.button{
  width: 100%;
}

.xjtlu_badge{
  width: 40px
}

</style>