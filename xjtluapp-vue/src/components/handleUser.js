import store from "@/store";
import router from "@/router"
import {commonGet, commonPost} from "@/components/commonRequest";
import {ElMessage} from "element-plus";

const delay = ms => new Promise(res => setTimeout(res, ms))

async function getUserInfo() {
    await commonGet("/userinfo",
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
            store.commit("SET_USERINFO", res.data.data)
            ElMessage({
                message: res.data.msg,
                type: 'success',
            })
            await delay(1000)
            await router.push('/home')
        },
    )
}

async function getIsAuth() {
    let result = false
    await commonGet("/isauth",
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

export {getUserInfo, getIsAuth, login, handleAvatar}