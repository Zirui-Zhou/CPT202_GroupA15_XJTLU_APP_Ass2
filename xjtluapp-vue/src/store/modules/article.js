const article = {
    state: {
        articleTypeList: [],
    },
    mutations: {
        SET_ARTICLE_TYPE_LIST: (state, type_list) => {
            state.articleTypeList = type_list
        },
    },
    getters: {
        getArticleTypeList: state => {
            return state.articleTypeList
        },
    },
}

export default article