import store from "@/store";
import axios from "axios";
import {transformBigint} from "@/components/transformBigint";
import {ElMessage} from "element-plus";

function getToken() {
    return store.getters.getToken
}

function getUrl() {
    return store.getters.getServerUrl
}

function getConfig(isAuth) {
    let axiosConfig = {transformResponse: transformBigint}
    if(isAuth) {
        Object.assign(axiosConfig, {headers: {"Authorization": getToken()}})
    }
    return axiosConfig
}

const handleError = (error) => {
    ElMessage({
        message: error.response.data.msg,
        type: 'error',
    })
}

async function commonGet(url, func, extraConfig={}, isAuth=false) {
    if(isAuth && !getToken()) {
        return
    }
    await axios.get(getUrl() + url,
        Object.assign(getConfig(isAuth), extraConfig)
    ).then(
        func
    ).catch(
        handleError
    )
}

async function commonPost(url, data, func, extraConfig={}, isAuth=false) {
    console.log(getToken())
    if(isAuth && !getToken()) {
        return
    }
    await axios.post(getUrl() + url,
        data,
        Object.assign(getConfig(isAuth), extraConfig)
    ).then(
        func
    ).catch(
        handleError
    )
}

export {commonGet, commonPost}