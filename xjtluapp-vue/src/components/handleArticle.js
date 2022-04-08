import router from "@/router"
import {commonGet, commonPost} from "@/components/commonRequest";


async function handleArticle(id) {
    let result
    await commonGet("/article",
        (res) => {
            result = res.data.data
        },
        {params: {id: id}}
    )
    return result
}

async function getArticleList(current, size) {
    let result
    await commonPost("/article/list",
        {current: current, size: size},
        (res) => {
            result = res.data.data
        }
    )
    return result
}

async function getTagTypeList() {
    let result
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

export {handleArticle, getArticleList, getTagTypeList, clickCard}