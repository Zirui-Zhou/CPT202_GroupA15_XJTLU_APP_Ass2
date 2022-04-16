import {commonPostData, handleResource} from "@/scripts/requestUtils";

async function getResourceList(current, size, extraUrl="", config={}) {
    const result = (await commonPostData(
        "/resource/list" + extraUrl,
        {current: current, size: size},
        true,
        config
    )).data

    if(result) {
        result.forEach((item, index, array) => {array[index] = handleResource(item, "resourceImage")})
        result.forEach((item, index, array) => {array[index] = handleResource(item, "resourcePath")})
    }

    return result
}

export {
    getResourceList,
}