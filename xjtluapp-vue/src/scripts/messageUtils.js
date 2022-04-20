import {ElNotification} from "element-plus";
import i18n from "@/i18n";

const t = i18n.global.t

const titleList = {
    error: ()=>t('message.message_utils.msg_title_error'),
    warning: ()=>t('message.message_utils.msg_title_warning'),
    info: ()=>t('message.message_utils.msg_title_info'),
    success: ()=>t('message.message_utils.msg_title_success'),
}

function addMessage(msg, type="warning", duration=2000) {
    ElNotification({
        title: titleList[type](),
        message: msg,
        type: type,
        duration: duration
    })
}

export {
    addMessage
}