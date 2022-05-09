import router from "@/router"
import store from "@/store";
import { commonGetData, commonPostData, handleResource } from "@/scripts/utils/requestUtils";
import {addMessage} from "@/scripts/utils/messageUtils";

async function getArticle(id) {
    const idn = BigInt(id)
    return (await commonGetData("/article", true, {params: {id: idn}})).data
}

async function addArticle(title, image, content, typeId) {
    const result = await commonPostData(
        "/article/add",
        {
            title: title,
            image: image,
            content: content,
            typeId: typeId
        },
        true
    )
    addMessage(result.msg, "success")
    return result.data
}

async function editArticle(id, title, image, content, typeId) {
    const result = await commonPostData(
        "/article/edit",
        {
            id: id,
            title: title,
            image: image,
            content: content,
            typeId: typeId
        },
        true
    )
    addMessage(result.msg, "success")
    return result.data
}

async function removeArticle(id) {
    const idn = BigInt(id)
    const result = await commonGetData("/article/remove", true, {params: {id: idn}})
    addMessage(result.msg, "success")
    return result.data
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

async function getArticleListOfSearch(current, size, keyword) {
    return await getArticleList(current, size, "/search", {params:{word: keyword}})
}

async function getArticleList(current, size, extraUrl="", config={}) {
    const result = (await commonPostData(
        "/article/list" + extraUrl,
        {current: current, size: size},
        true,
        config
    )).data

    if(result) {
        result.forEach(
            (item, index, array) => {
                array[index] = handleResource(item, "avatar")
                if(item.image && !item.image.startsWith("http")) {
                    array[index] = handleResource(item, "image")
                }
            }
        )
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
        query: {id: id}
    })
}

function linkToEditArticle(id) {
    router.push({
        path: '/article/edit',
        query: {id: id}
    })
}

export {
    getArticle,
    addArticle,
    editArticle,
    removeArticle,
    getArticleList,
    getArticleListOfMine,
    getArticleListOfFavourite,
    getArticleListOfHistory,
    getArticleListOfType,
    getArticleListOfSearch,
    handleFavouriteArticle,
    addHistoryArticle,
    removeHistoryArticle,
    getAllArticleTypes,
    linkToArticle,
    linkToEditArticle,
    getArticleLink
}