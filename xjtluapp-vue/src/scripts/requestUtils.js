import store from "@/store";
import axios from "axios";
import JSONbig from "json-bigint";
import {addMessage} from "@/scripts/messageUtils";

function getToken() {
    return store.getters.getToken
}

function getServerUrl() {
    return store.getters.getServerUrl
}

function getDefaultConfig(isAuth, extraConfig="") {
    let axiosConfig = {transformResponse: transformBigint}
    if(isAuth) {
        Object.assign(axiosConfig, {headers: {"Authorization": getToken()}})
    }
    Object.assign(axiosConfig, extraConfig)
    return axiosConfig
}

const handleError = (error) => {
    addMessage(error.response.data.msg, "error")
}

function transformBigint(data) {
    try {
        return JSONbig.parse(data)
    } catch (e) {
        return data
    }
}

async function commonGet(url, func, isAuth=false, extraConfig={}) {
    if(isAuth && !getToken()) {
        return
    }
    await axios.get(getServerUrl() + url,
        getDefaultConfig(isAuth, extraConfig)
    ).then(
        func
    ).catch(
        handleError
    )
}

async function commonPost(url, data, func, isAuth=false, extraConfig={}) {
    if(isAuth && !getToken()) {
        return
    }
    await axios.post(getServerUrl() + url,
        data,
        getDefaultConfig(isAuth, extraConfig)
    ).then(
        func
    ).catch(
        handleError
    )
}

async function commonGetData(url, isAuth=false, extraConfig={}) {
    let result = {data: null, msg: null}
    await commonGet(url, (res)=>result={data: res.data.data, msg: res.data.msg}, isAuth, extraConfig)
    return result
}

async function commonPostData(url, data, isAuth=false, extraConfig={}) {
    let result = {data: null, msg: null}
    await commonPost(url, data, (res)=>result={data: res.data.data, msg: res.data.msg}, isAuth, extraConfig)
    return result
}

export {
    commonGet,
    commonPost,
    commonGetData,
    commonPostData
}