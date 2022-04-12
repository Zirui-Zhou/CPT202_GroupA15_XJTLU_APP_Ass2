import store from "@/store";
import router from "@/router"
import {commonGetData, commonPost} from "@/scripts/requestUtils";
import {computed, watch} from "vue";
import {addMessage} from "@/scripts/messageUtils";

async function getUserInfo() {
    let result = (await commonGetData("/user/info", true)).data
    result = handleAvatar(result)
    store.commit("SET_USERINFO", result)
}

async function login(loginForm) {
    await commonPost("/login",
        loginForm,
        res => {
            if(loginForm.isRemember) {
                store.commit("SET_PERM_TOKEN", res.headers["authorization"])
            } else {
                store.commit("SET_TEMP_TOKEN", res.headers["authorization"])
            }
            const userInfo = handleAvatar(res.data.data)
            store.commit("SET_USERINFO", userInfo)
            addMessage(res.data.msg, "success")
        },
    )
}

async function logout() {
    store.commit("REMOVE_USER")
    addMessage("Logout successfully", "success")
    await router.replace("/")
}

async function needLogin(message="Please login first", url="/user/login") {
    if(! await getIsAuth()) {
        if(message.length > 0) {
            addMessage(message, "warning")
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
    return (await commonGetData("/auth", true)).data
}

function handleAvatarUrl(avatar) {
    if(!avatar){
        return null
    }
    return store.getters.getStaticUrl + avatar
}

function handleAvatar(object) {
    if(object) {
        if(object.avatar) {
            object.avatar = handleAvatarUrl(object.avatar)
        }
    }
    return object
}

export {
    getUserInfo,
    getIsAuth,
    login,
    logout,
    handleAvatarUrl,
    handleAvatar,
    needLogin,
    watchLogin
}