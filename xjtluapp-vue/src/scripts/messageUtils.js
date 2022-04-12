import {ElNotification} from "element-plus";

function addMessage(msg, type="warning", duration=2000) {
    ElNotification({
        title: type.charAt(0).toUpperCase() + type.slice(1),
        message: msg,
        type: type,
        duration: duration
    })
}

export {
    addMessage
}