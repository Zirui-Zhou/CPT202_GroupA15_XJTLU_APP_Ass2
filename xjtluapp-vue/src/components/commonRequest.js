import store from "@/store";
import axios from "axios";
import {transformBigint} from "@/components/transformBigint";
import {ElMessage} from "element-plus";

const serverUrl = "http://localhost:8081"

function getToken() {
    return store.getters.getToken
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
    await axios.get(serverUrl + url,
        Object.assign(getConfig(isAuth), extraConfig)
    ).then(
        func
    ).catch(
        handleError
    )
}

async function commonPost(url, data, func, extraConfig={}, isAuth=false) {
    if(isAuth && !getToken())
        return
    await axios.post(serverUrl + url,
        data,
        Object.assign(getConfig(isAuth), extraConfig)
    ).then(
        func
    ).catch(
        handleError
    )
}

export {commonGet, commonPost}