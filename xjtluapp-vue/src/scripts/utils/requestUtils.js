import store from "@/store";
import axios from "axios";
import JSONbig from "json-bigint";
import {addMessage} from "@/scripts/utils/messageUtils";

function getToken() {
    return store.getters.getToken
}

function getServerUrl() {
    return store.getters.getServerUrl
}

function handleResourceUrl(image) {
    if(!image){
        return null
    }
    return store.getters.getStaticUrl + image
}

function handleResource(object, key) {
    if(object) {
        if(object[key]) {
            object[key] = handleResourceUrl(object[key])
        }
    }
    return object
}

function getDefaultConfig(isAuth, extraConfig= {}) {
    let axiosConfig = {transformResponse: transformBigint}
    Object.assign(axiosConfig, {headers: {}})
    if(isAuth) {
        Object.assign(axiosConfig["headers"], {"Authorization": getToken()})
    }
    Object.assign(axiosConfig["headers"], {"Accept-Language": store.getters.getLang})
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
    let result = {code: null, msg: null, data: null}
    if(isAuth && !getToken()) {
        return result
    }
    await axios.get(getServerUrl() + url,
        getDefaultConfig(isAuth, extraConfig)
    ).then(
        (res)=>{
            func(res)
            result = res.data
        }
    ).catch(
        handleError
    )
    return result
}

async function commonPost(url, data, func, isAuth=false, extraConfig={}) {
    let result = {code: null, msg: null, data: null}
    if(isAuth && !getToken()) {
        return result
    }
    await axios.post(getServerUrl() + url,
        data,
        getDefaultConfig(isAuth, extraConfig)
    ).then(
        (res)=>{
            func(res)
            result = res.data
        }
    ).catch(
        handleError
    )
    return result
}

async function commonGetData(url, isAuth=false, extraConfig={}) {

    return await commonGet(url, function(){}, isAuth, extraConfig)

}

async function commonPostData(url, data, isAuth=false, extraConfig={}) {

    return await commonPost(url, data, function(){}, isAuth, extraConfig)

}

export {
    commonGet,
    commonPost,
    commonGetData,
    commonPostData,
    handleResourceUrl,
    handleResource
}