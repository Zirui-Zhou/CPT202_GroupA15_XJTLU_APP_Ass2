<template>
  <el-container>

    <el-header class="deep-color center">
        <el-image
            :src="require('@/assets/xjtlu_badge.png')"
            class="xjtlu_badge"
        />
        <span class="banner">
          {{ $t('message.login_form.form_title') }}
        </span>
    </el-header>

    <el-main class="light-color center">
      <el-form
          style="width: 80%"
          :rules="rules"
          :model="ruleForm"
          ref="ruleFormRef"
      >
        <el-form-item prop="username">
          <el-input
              :prefix-icon="Avatar"
              size="large"
              v-model="ruleForm.username"
              :placeholder="$t('message.login_form.input_placeholder_username')"
              maxlength="16"
          />
        </el-form-item>

        <el-form-item prop="password">
          <el-input
              :prefix-icon="Key"
              size="large"
              v-model="ruleForm.password"
              :placeholder="$t('message.login_form.input_placeholder_password')"
              show-password
          />
        </el-form-item>

        <el-form-item>
          <div style="margin-left: auto; margin-right: 0;">
            <el-switch v-model="ruleForm.isRemember"/>
            <span style="margin-left: 10px">
              {{ $t('message.login_form.switch_remember_me') }}
            </span>
          </div>
        </el-form-item>

        <el-form-item>
          <el-button
              size="large"
              class="button"
              type="primary"
              @click="submitForm()"
          >
            {{ $t('message.login_form.button_login') }}
          </el-button>
        </el-form-item>

        <el-form-item>
          <el-button
              size="large"
              class="button"
              type="default"
              @click="handleNoAccountClick"
          >
            {{ $t('message.login_form.button_no_account') }}
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
            {{ $t('message.login_form.button_previous') }}
          </el-button>
        </el-form-item>

      </el-form>
    </el-main>

  </el-container>

  <NoRegisterDialog
      ref="NoRegDialogRef"
      :fill-input-func="fillInputFunc"
  />

</template>

<script setup>
import {ref, unref, reactive} from 'vue'
import {useRouter} from "vue-router";
import {useI18n} from "vue-i18n"
import {Avatar, Key, ArrowLeft} from "@element-plus/icons-vue"
import {login} from "@/scripts/api/handleUserApi";
import {delay} from "@/scripts/utils/commonUtils";
import {addMessage} from "@/scripts/utils/messageUtils";
import NoRegisterDialog from "@/components/login_page/NoRegisterDialog"

const {t} = useI18n()
const router = useRouter()

const ruleForm = reactive({
  username: '',
  password: '',
  isRemember: false,
})

const ruleFormRef = ref(null)
const NoRegDialogRef = ref(null)

const rules = reactive({
  username: [
    { required: true,
      message: t('message.login_form.error_missing_username'),
      trigger: 'blur'
    },
  ],
  password: [
    { required: true,
      message: t('message.login_form.error_missing_password'),
      trigger: 'change'
    }
  ],
})

const submitForm = () => {
  const form = unref(ruleFormRef)
  form.validate(async (valid) => {
    if (!valid) {
      addMessage(
          t('message.login_form.error_wrong_info'),
          "error"
      )
      return false;
    }
    await login(ruleForm)
    await delay(500)
    await router.replace('/home')
  })
}

const handleNoAccountClick = () => {
  NoRegDialogRef.value.openDialog()
}

const fillInputFunc = () => {
  ruleForm.username = "zirui.zhou"
  ruleForm.password = "zirui.zhou"
}

const handlePrevClick = () => {
  router.back()
}

</script>

<style scoped>

.deep-color {
  background-color: rgba(255,255,255,0.8);
}

.light-color {
  background-color: rgba(255,255,255,0.5);
}

.center {
  display: flex;
  justify-content: center;
  align-items: center;
}

.banner {
  font-size: 200%;
  font-weight: bold;
  margin: 10px;
}

.button {
  width: 100%;
}

.xjtlu_badge {
  width: 40px
}
</style>