const userInfo = {
    state: {
        token: localStorage.getItem("token") || sessionStorage.getItem("token"),
        userInfo: JSON.parse(sessionStorage.getItem("userInfo")),
    },
    mutations: {
        SET_TEMP_TOKEN: (state, token) => {
            state.token = token
            sessionStorage.setItem("token", token)
        },
        SET_PERM_TOKEN: (state, token) => {
            state.token = token
            localStorage.setItem("token", token)
        },
        SET_USERINFO: (state, userInfo) => {
            state.userInfo = userInfo
            sessionStorage.setItem("userInfo", JSON.stringify(userInfo))
        },
        REMOVE_USER: (state) => {
            state.token = ""
            state.userInfo = null
            sessionStorage.removeItem("token")
            sessionStorage.removeItem("userInfo")
        },
    },
    getters: {
        getUserInfo: state => {
            return state.userInfo
        },
        getToken: state => {
            return state.token
        },
    },
}

export default userInfo