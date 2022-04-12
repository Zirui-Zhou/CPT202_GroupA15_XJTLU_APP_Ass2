import router from "@/router"
import {commonGetData, commonPostData} from "@/scripts/requestUtils";
import {handleAvatar} from "@/scripts/handleUserApi";

async function getArticle(id) {
    return (await commonGetData("/article", true, {params: {id: id}})).data
}

async function getArticleListOfMine(current, size) {
    return await getArticleList(current, size, "/mine", {})
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

async function getTagTypeList() {
    return (await commonGetData("/article/tags", true)).data
}

function LinkToArticle(id){
    router.push({
        path: '/article',
        query:{id: id}
    })
}

export {
    getArticle,
    getArticleList,
    getArticleListOfMine,
    getTagTypeList,
    LinkToArticle
}