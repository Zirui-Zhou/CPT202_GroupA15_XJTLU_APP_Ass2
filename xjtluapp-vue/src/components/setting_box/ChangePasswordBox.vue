<template>
  <el-dialog
      v-model="isShowDialog"
      :title="$t('message.change_password_box.box_title')"
      width="450px"
      ref="passBoxRef"
  >
    <el-form
        ref="ruleFormRef"
        :model="ruleForm"
        status-icon
        :rules="rules"
        label-width="auto"
    >
      <el-form-item
          :label="$t('message.change_password_box.label_old_pass')"
          prop="oldPass"
          class="passInput"
      >
        <el-input
            v-model="ruleForm.oldPass"
            type="password"
            autocomplete="off"
        />
      </el-form-item>

      <el-form-item
          :label="$t('message.change_password_box.label_new_pass')"
          prop="newPass"
          class="passInput"
      >
        <el-input
            v-model="ruleForm.newPass"
            type="password"
            autocomplete="off"
        />
      </el-form-item>

      <el-form-item
          :label="$t('message.change_password_box.label_confirm_pass')"
          prop="checkPass"
          class="passInput"
      >
        <el-input
            v-model="ruleForm.checkPass"
            type="password"
            autocomplete="off"
        />
      </el-form-item>

      <el-form-item>
        <el-button
            type="primary"
            @click="submitForm(ruleFormRef)"
        >
          {{ $t('message.change_password_box.button_submit') }}
        </el-button>
        <el-button
            type="default"
            @click="resetForm(ruleFormRef)"
        >
          {{ $t('message.change_password_box.button_reset') }}
        </el-button>
      </el-form-item>
    </el-form>

  </el-dialog>
</template>

<script setup>
import { reactive, defineExpose, ref } from "vue";
import { useI18n } from "vue-i18n"
import { changePassword } from "@/scripts/api/handleUserApi";

const {t} = useI18n()

const isShowDialog = ref(false)

const ruleFormRef = ref(null)
const passBoxRef = ref(null)

const openDialog = () => {
  isShowDialog.value = true
}

defineExpose({
  openDialog
})

const validateOldPass = (rule, value, callback) => {
  if (value === '') {
    callback(new Error(t('message.change_password_box.msg_missing_old_pass')))
  } else {
    callback()
  }
}

const validateNewPass = (rule, value, callback) => {
  if (value === '') {
    callback(new Error(t('message.change_password_box.msg_missing_new_pass')))
  } else if (value === ruleForm.oldPass) {
    callback(new Error(t('message.change_password_box.msg_same_new_pass')))
  } else {
    if (ruleForm.checkPass !== '') {
      if (!ruleFormRef.value) return
      ruleFormRef.value.validateField('checkPass', () => null)
    }
    callback()
  }
}

const validateCheckPass = (rule, value, callback) => {
  if (value === '') {
    callback(new Error(t('message.change_password_box.msg_missing_check_pass')))
  } else if (value !== ruleForm.newPass) {
    callback(new Error(t('message.change_password_box.msg_different_check_pass')))
  } else {
    callback()
  }
}

const ruleForm = reactive({
  oldPass: '',
  newPass: '',
  checkPass: '',
})

const rules = reactive({
  oldPass: [{ validator: validateOldPass, trigger: 'blur' }],
  newPass: [{ validator: validateNewPass, trigger: 'blur' }],
  checkPass: [{ validator: validateCheckPass, trigger: 'blur' }],
})

const submitForm = (formEl) => {
  if (!formEl)
    return
  formEl.validate((valid) => {
    if (valid) {
      changePassword({
        oldPassword: ruleForm.oldPass,
        newPassword: ruleForm.newPass
      })
      resetForm(formEl)
      passBoxRef.value.visible = false
    } else {
      return false
    }
  })
}

const resetForm = (formEl) => {
  if (!formEl) return
  formEl.resetFields()
}
</script>

<style scoped>
.passInput {
  margin-bottom: 30px
}
</style>