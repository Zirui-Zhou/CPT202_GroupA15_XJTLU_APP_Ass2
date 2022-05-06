import {commonGetData, commonPostData, handleResource} from "@/scripts/utils/requestUtils";

async function getResourceList(current, size, tagList=[],  extraUrl="", config={}) {
    const result = (await commonPostData(
        "/resource/list" + extraUrl,
        {current: current, size: size, tagList: tagList},
        true,
        config
    )).data

    if(result) {
        result.forEach((item, index, array) => {array[index] = handleResource(item, "resourceImage")})
        result.forEach((item, index, array) => {array[index] = handleResource(item, "resourcePath")})
    }

    return result
}

async function getAllResourceTags() {
    return (await commonGetData("/resource/tags", true)).data
}

async function getResourceListOfTags(current, size, tagList) {
    return await getResourceList(current, size, tagList, "/tags")
}

export {
    getResourceList,
    getAllResourceTags,
    getResourceListOfTags,
}