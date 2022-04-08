import axios from "axios";
import {ElMessage} from "element-plus";
import router from "@/router"

const serverUrl = "http://localhost:8081"

async function getArticle(id) {
    let article
    await axios.get(serverUrl + "/article",
        {params: {id: id}})
        .then((res) => {
        article = res.data.data
    }).catch(error => {
        ElMessage({
            message: error.response.data.msg,
            type: 'error',
        })
    })
    return article
}

async function getArticleList(current, size) {
    let articleList
    await axios.post(serverUrl + "/article/list",
        {current: current, size: size})
        .then(res => {
            articleList = res.data.data
        }).catch(error => {
            ElMessage({
                message: error.response.data.msg,
                type: 'error',
            })
        })
    return articleList
}

function clickCard(id){
    router.push({
        path: '/article',
        query:{id: id}
    })
}

export {getArticle, getArticleList, clickCard}