import store from "@/store";
import router from "@/router"
import {commonGetData, commonPost, handleResource} from "@/scripts/requestUtils";
import {computed, watch} from "vue";
import {addMessage} from "@/scripts/messageUtils";

async function getUserInfo() {
    let result = (await commonGetData("/user/info", true)).data
    result = handleResource(result, "avatar")
    store.commit("SET_USERINFO", result)
}

async function getEditorInfo(userId) {
    const idn = BigInt(userId)
    let result = (await commonGetData("/user/info", true, {params: {id: idn}})).data
    result = handleResource(result, "avatar")
    return result
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
            const userInfo = handleResource(res.data.data, "avatar")
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

export {
    getUserInfo,
    getEditorInfo,
    getIsAuth,
    login,
    logout,
    needLogin,
    watchLogin,
}