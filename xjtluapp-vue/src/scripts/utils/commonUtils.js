import moment from "moment";

function delay(ms) {
    return new Promise(res => setTimeout(res, ms))
}

function getFormattedTime(time) {
    return moment(time).format('YYYY-MM-DD HH:mm:ss')
}

function getFormattedDate(time) {
    return moment(time).format('YYYY-MM-DD')
}

export {
    delay,
    getFormattedTime,
    getFormattedDate,
}