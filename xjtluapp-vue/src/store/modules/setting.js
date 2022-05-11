const setting = {
    state: {
        settings:
            localStorage["settings"] ?
            JSON.parse(localStorage.getItem("settings")) :
            {
                isDarkMode: false,
                lang: "en-US"
            }
    },
    mutations: {
        SET_SETTING: (state) => {
            localStorage.setItem("settings", JSON.stringify(state.settings))
        },
        SET_DARK_MODE: function(state, value) {
            state.settings.isDarkMode = value
            this.commit("SET_SETTING")
        },
        SET_LANG: function(state, value) {
            state.settings.lang = value
            this.commit("SET_SETTING")
        }
    },
    getters: {
        getIsDarkMode: state => {
            return state.settings.isDarkMode
        },
        getLang: state => {
            return state.settings.lang
        }
    },
}

export default setting