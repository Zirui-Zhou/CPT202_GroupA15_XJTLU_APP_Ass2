<template>
  <div id="background">
  </div>

  <div class="homeBox">
    <el-container style="height: 70%;width:30%;" direction="vertical">
      <el-header>
        <router-link to="/blogs">
          <img src="https://t14.baidu.com/it/u=374513427,3565404500&fm=179&app=42&size=w54&n=0&f=JPEG&fmt=auto?s=503121700CB025B50F6613920200E0AA&sec=1648054800&t=f3379f95660504f7ef5611712ae1ff73"
               style="height: 60%; margin-top: 10px;">
        </router-link>
        .                                                  XJTLU
        <el-row >
          <el-col :span="24">
            <div class="grid-content bg-purple-dark">
              Student App
            </div></el-col>
        </el-row>
      </el-header>

      <el-main>
        <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm"
                 style=" margin-top: 120px;">
          <el-form-item label="Username" prop="username">
            <el-input prefix-icon="avatar" type="text" maxlength="12" v-model="ruleForm.username"></el-input>
          </el-form-item>

          <el-form-item label="Password" prop="password">
            <el-input prefix-icon="key" type="password" v-model="ruleForm.password" autocomplete="off"></el-input>

            <el-switch
                class="remember"
                v-model="value1"
                active-text="Remember">
            </el-switch>
            <div class="register">
              <router-link to="/Register">
              Register
            </router-link>
            </div>
          </el-form-item>

          <el-form-item >
            <div class="log button">
              <el-button class="login" type="primary" @click="submitForm('ruleForm')" round>Log in</el-button>
            </div>
          </el-form-item>

          <el-form-item>
            <div class="reset">
              <el-button class="reset" @click="resetForm('ruleForm')" round>Reset</el-button>
            </div>
          </el-form-item>

        </el-form>
      </el-main>
      <el-footer>


      </el-footer>
    </el-container>
  </div>
</template>

<script>


export default {

  name: 'Login',
  data() {
    return {
      loginBg: 'url(' + require('../assets/xjtlu.png') + ')',
      value1: true,
      value2: true,
      ruleForm: {
        username: '',
        password: '',
      },
      rules: {
        username: [
          { required: true, message: 'Please enter username', trigger: 'blur' },
          { min: 3, max: 5, message: 'The length is 3 to 5 characters', trigger: 'blur' }
        ],
        password: [
          { required: true, message: 'Input your password', trigger: 'change' }
        ],
      }
    };
  },
  mounted () {
    // 添加背景图片
    document.body.style.backgroundSize = '100%'
    document.body.style.backgroundImage = this.loginBg
  },
  // 离开VUE时调用的钩子函数
  beforeUnmount () {
    // 清除背景图片
    document.body.style.backgroundImage = ''
  },
  methods: {

    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$message({
            message: 'Success',
            type: 'success'
          });
          this.$axios.post('http://localhost:8081/login',this.ruleForm).then(res =>{
            const jwt = res.headers['authorzation']
            const useInfo=res.data.data()
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },

    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>


<style>

.el-row {
  margin-bottom: 20px;
&:last-child {
   margin-bottom: 0;
 }
}
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #E9EEF3;
  /*subtitle*/
}
.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}


html,body,#app,.homeBox,.el-container{
  /*设置内部填充为0，几个布局元素之间没有间距*/
  padding: 0px;
  /*外部间距也是如此设置*/
  margin: 0px;
  /*统一设置高度为100%*/
  height: 100%;
  margin:0 auto;
}

#login{
  background: url("../assets/xjtlu.png");
  background-position:center;
  width:100%;
  height:100%;  /**宽高100%是为了图片铺满屏幕 */
  z-index:-1;
  position: fixed;
}
.el-header, .el-footer {
  background-color: #409EFF;
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-aside {
  background-color: #D3DCE6;
  color: #333;
  text-align: center;
  line-height: 200px;
}

.el-main {
  background-color: #E9EEF3;
  color: #333;
  text-align: center;
  line-height: 160px;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}
.demo-ruleForm{
  margin:0 auto;
  margin-left: 30px;
  max-width: 400px;

}
.log button {
  min-height: 30px;
  min-width: 280px;
  margin-top: 30px;
}
/* 删除按钮 */
.reset {
  min-height: 30px;
  min-width: 280px;

}
.register{
  margin-left: 120px;
}
</style>