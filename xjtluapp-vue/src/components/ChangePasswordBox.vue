<template>
  <el-dialog
      :model-value="isShowPassBox"
      title="Change Password"
      @close="closePassBox()"
      width="30%"
      ref="passBoxRef"
  >
    <el-form
        ref="ruleFormRef"
        :model="ruleForm"
        status-icon
        :rules="rules"
        label-width="auto"
    >
      <el-form-item label="Old Password" prop="oldPass" class="passInput">
        <el-input
            v-model="ruleForm.oldPass"
            type="password"
            autocomplete="off"
        />
      </el-form-item>

      <el-form-item label="New Password" prop="newPass" class="passInput">
        <el-input
            v-model="ruleForm.newPass"
            type="password"
            autocomplete="off"
        />
      </el-form-item>

      <el-form-item label="Confirm Password" prop="checkPass" class="passInput">
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
          Submit
        </el-button>
        <el-button @click="resetForm(ruleFormRef)">Reset</el-button>
      </el-form-item>
    </el-form>

  </el-dialog>
</template>

<script setup>
import {reactive, defineProps, ref} from "vue";
import {changePassword} from "@/scripts/handleUserApi";

const props = defineProps({
  isShowPassBox: Boolean,
  closePassBox: Function
})

const ruleFormRef = ref(null)
const passBoxRef = ref(null)

const validateOldPass = (rule, value, callback) => {
  if (value === '') {
    callback(new Error('Please input the old password'))
  } else if (value === ruleForm.newPass) {
    callback(new Error('Please input a different password'))
  } else {
    callback()
  }
}

const validateNewPass = (rule, value, callback) => {
  if (value === '') {
    callback(new Error('Please input the new password'))
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
    callback(new Error('Please input the new password again'))
  } else if (value !== ruleForm.newPass) {
    callback(new Error("Two inputs don't match!"))
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
  if (!formEl) return
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
.passInput{
  margin-bottom: 30px
}
</style>