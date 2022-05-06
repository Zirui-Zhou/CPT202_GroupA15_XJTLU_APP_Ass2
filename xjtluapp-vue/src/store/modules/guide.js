const guide = {
    state: {
        guideTypeList: [],
    },
    mutations: {
        SET_GUIDE_TYPE_LIST: (state, type_list) => {
            state.guideTypeList = type_list
        },
    },
    getters: {
        getGuideTypeList: state => {
            return state.guideTypeList
        },
    },
}

export default guide