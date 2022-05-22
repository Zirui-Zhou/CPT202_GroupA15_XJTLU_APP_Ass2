const config = {
    state: {
        serverUrl: "http://47.110.224.16:8081",
        // serverUrl: "http://localhost:8081",
        staticUrl: "http://47.110.224.16:8081/static",
        githubUrl: "https://github.com/Zirui-Zhou/CPT202_GroupA15_XJTLU_APP_Ass2",
    },
    getters: {
        getServerUrl: state => {
            return state.serverUrl
        },
        getStaticUrl: state => {
            return state.staticUrl
        },
        getGitHubUrl: state => {
            return state.githubUrl
        }
    },
}

export default config