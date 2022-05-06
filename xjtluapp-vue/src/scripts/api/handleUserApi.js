import store from "@/store";
import router from "@/router"
import {commonGetData, commonPost, commonPostData, handleResource} from "@/scripts/utils/requestUtils";
import {computed, watch} from "vue";
import {addMessage} from "@/scripts/utils/messageUtils";
import i18n from "@/i18n";

const t = i18n.global.t

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
    addMessage(t('message.handle_user_api.msg_logout_success'), "success")
    await router.replace("/")
}

async function needLogin(message=t('message.handle_user_api.msg_no_login'), url="/user/login") {
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

async function changePassword(form) {
    const result = await commonPostData("/user/change_password", form, true)
    if(result.msg) {
        addMessage(result.msg, "success")
    }

}

export {
    getUserInfo,
    getEditorInfo,
    getIsAuth,
    login,
    logout,
    needLogin,
    watchLogin,
    changePassword,
}