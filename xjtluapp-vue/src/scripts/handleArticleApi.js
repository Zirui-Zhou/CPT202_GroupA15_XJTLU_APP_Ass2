import router from "@/router"
import {commonGetData, commonPostData} from "@/scripts/requestUtils";
import {handleAvatar} from "@/scripts/handleUserApi";
import store from "@/store";

async function getArticle(id) {
    const idn = BigInt(id)
    return (await commonGetData("/article", true, {params: {id: idn}})).data
}

async function getArticleListOfMine(current, size) {
    return await getArticleList(current, size, "/mine", {})
}

async function getArticleListOfFavourite(current, size) {
    return await getArticleList(current, size, "/favourite", {})
}

async function getArticleListOfHistory(current, size) {
    return await getArticleList(current, size, "/history", {})
}

async function getArticleListOfType(current, size, id) {
    return await getArticleList(current, size, "/type", {params:{id: id}})
}

async function getArticleList(current, size, extraUrl="", config={}) {
    const result = (await commonPostData(
        "/article/list" + extraUrl,
        {current: current, size: size},
        true,
        config
    )).data

    if(result) {
        result.forEach((item, index, array) => {array[index] = handleAvatar(item)})
    }

    return result
}

async function handleFavouriteArticle(id) {
    const idn = BigInt(id)
    return (await commonGetData("/article/favourite", true, {params: {id: idn}})).data
}

async function addHistoryArticle(id) {
    const idn = BigInt(id)
    return (await commonGetData("/article/history/add", true, {params: {id: idn}})).data
}

async function removeHistoryArticle(id) {
    const idn = BigInt(id)
    return (await commonGetData("/article/history/remove", true, {params: {id: idn}})).data
}

async function getTagTypeList() {
    return (await commonGetData("/article/tags", true)).data
}

async function getAllArticleTypes() {
    const result = (await commonGetData("/article/types", true)).data
    store.commit("SET_ARTICLE_TYPE_LIST", result)
}

function getArticleLink(id) {
    const route = router.resolve({
        path: '/article',
        query:{id: id}
    })
    return new URL(route.href, window.location.href).href;
}

function linkToArticle(id){
    router.push({
        path: '/article',
        query:{id: id}
    })
}

export {
    getArticle,
    getArticleList,
    getArticleListOfMine,
    getArticleListOfFavourite,
    getArticleListOfHistory,
    getArticleListOfType,
    handleFavouriteArticle,
    addHistoryArticle,
    removeHistoryArticle,
    getTagTypeList,
    getAllArticleTypes,
    linkToArticle,
    getArticleLink
}