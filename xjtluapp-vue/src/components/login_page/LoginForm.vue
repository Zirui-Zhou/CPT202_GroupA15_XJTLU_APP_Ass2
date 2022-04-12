<template>
  <el-container>

    <el-header class="deep-color center">
        <img src="../../assets/xjtlu_icon.png" alt="app">
        <span class="banner">Student App</span>
    </el-header>

    <el-main class="light-color center">
      <el-form style="width: 80%" :rules="rules" :model="ruleForm" ref="ruleFormDom">
        <el-form-item prop="username">
          <el-input
              :prefix-icon="Avatar"
              size="large"
              v-model="ruleForm.username"
              placeholder="Username"
              maxlength="16"
          />
        </el-form-item>

        <el-form-item prop="password">
          <el-input
              :prefix-icon="Key"
              size="large"
              v-model="ruleForm.password"
              placeholder="Password"
              show-password
          />
        </el-form-item>

        <el-form-item>
          <div style="margin-left: auto; margin-right: 0;">
            <el-switch  v-model="ruleForm.isRemember"/>
            <span style="margin-left: 10px">Remember Me?</span>
          </div>
        </el-form-item>

        <el-form-item>
          <el-button
              size="large"
              class="button"
              type="primary"
              @click="submitForm()"
          >
            Login
          </el-button>
        </el-form-item>

        <el-form-item>
          <el-button
              size="large"
              class="button"
              type="default"
              @click="router.push('/user/register')"
          >
            Have no account?
          </el-button>
        </el-form-item>

        <el-form-item>
          <el-button
              size="large"
              class="button"
              type="default"
              :icon="ArrowLeft"
              @click="handlePrevClick"
          >
            Previous
          </el-button>
        </el-form-item>

      </el-form>
    </el-main>

  </el-container>
</template>

<script setup>
  import {ref, unref, reactive} from 'vue'
  import {ElNotification} from 'element-plus'
  import {Avatar, Key, ArrowLeft} from "@element-plus/icons-vue"
  import {login} from "@/scripts/handleUserApi";
  import {useRouter} from "vue-router";
  import {delay} from "@/scripts/commonUtils";

  const router = useRouter()

  const ruleForm = reactive({
    userName: '',
    password: '',
    isRemember: false,
  })

  const ruleFormDom = ref(null)

  const rules = reactive({
    username: [
      { required: true, message: 'Please input your username', trigger: 'blur' },
    ],
    password: [
      { required: true, message: 'Please input your password', trigger: 'change' }
    ],
  })

  const submitForm = () => {
    const form = unref(ruleFormDom)
    form.validate(async (valid) => {
      if (!valid) {
        ElNotification({
          title: "Error",
          message: 'Please input the correct info.',
          type: 'error',
        })
        return false;
      }
      await login(ruleForm)
      await delay(500)
      await router.replace('/home')
    })
  }

  const handlePrevClick = () => {
    router.back()
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

</style>