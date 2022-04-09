import router from "@/router"
import {commonGet, commonPost} from "@/components/commonRequest";
import {handleAvatar} from "@/components/handleUser";

async function getArticle(id) {
    let result = null
    await commonGet("/article",
        (res) => {
            result = res.data.data
        },
        {params: {id: id}}
    )
    return result
}

async function getArticleListOfMine(current, size) {
    return await getArticleList(current, size, "/mine", {}, true)
}

async function getArticleList(current, size, extraUrl="", config={}, isAuth=false) {
    let result = []
    await commonPost("/article/list" + extraUrl,
        {current: current, size: size},
        (res) => {
            result = res.data.data
            result.forEach((item) => {item.avatar = handleAvatar(item.avatar)})
        },
        config,
        isAuth
    )
    return result
}

async function getTagTypeList() {
    let result = []
    await commonGet("/article/tags",
        (res) => {
            result = res.data.data
        }
    )
    return result
}

function clickCard(id){
    router.push({
        path: '/article',
        query:{id: id}
    })
}

export {getArticle, getArticleList, getArticleListOfMine, getTagTypeList, clickCard}