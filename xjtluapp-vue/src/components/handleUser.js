import store from "@/store";
import router from "@/router"
import {commonGet, commonPost} from "@/components/commonRequest";
import {ElNotification} from "element-plus";
import {computed, watch} from "vue";

const delay = ms => new Promise(res => setTimeout(res, ms))

async function getUserInfo() {
    await commonGet("/user/info",
        (res) => {
            const result = res.data.data
            if(result.avatar) {
                result.avatar = handleAvatar(result.avatar)
            }
            store.commit("SET_USERINFO", res.data.data)
        },
        {},
        true
    )
}

async function login(ruleForm) {
    await commonPost("/login",
        ruleForm,
        async res => {
            if(ruleForm.isRemember) {
                store.commit("SET_PERM_TOKEN", res.headers["authorization"])
            } else {
                store.commit("SET_TEMP_TOKEN", res.headers["authorization"])
            }
            const result = res.data.data
            if(result.avatar) {
                result.avatar = handleAvatar(result.avatar)
            }
            store.commit("SET_USERINFO", result)
            ElNotification({
                title: 'Success',
                message: res.data.msg,
                type: 'success',
                duration: 2000,
            })
            await delay(500)
            await router.replace('/home')
        },
    )
}

async function needLogin(message="Please login first", url="/user/login") {
    if(! await getIsAuth()) {
        if(message.length > 0) {
            ElNotification({
                title: 'Warning',
                message: message,
                type: 'warning',
                duration: 2000,
            })
        }
        await router.push(url)
        return false
    }
    return true
}

async function watchLogin() {
    const token = computed(() => store.getters.getToken)
    watch(token, async () => {
        await needLogin("/")
    })
}

async function getIsAuth() {
    let result = false
    await commonGet("/auth",
        () => {
            result = true
        },
        {},
        true
    )
    return result
}

function handleAvatar(avatar) {
    if(!avatar){
        return null
    }
    return store.getters.getStaticUrl + avatar
}

export {getUserInfo, getIsAuth, login, handleAvatar, needLogin, watchLogin}