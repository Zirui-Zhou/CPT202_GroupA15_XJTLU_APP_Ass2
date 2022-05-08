const article = {
    state: {
        articleTypeList: [],
        articleDraft: JSON.parse(localStorage.getItem("articleDraft")),
    },
    mutations: {
        SET_ARTICLE_TYPE_LIST: (state, type_list) => {
            state.articleTypeList = type_list
        },
        SET_ARTICLE_DRAFT: (state, article) => {
            state.articleDraft = article
            localStorage.setItem("articleDraft", JSON.stringify(state.articleDraft))
        },
        REMOVE_ARTICLE_DRAFT: (state) => {
            state.articleDraft = null
            localStorage.removeItem("articleDraft")
        },
    },
    getters: {
        getArticleTypeList: state => {
            return state.articleTypeList
        },
        getArticleDraft: state => {
            return state.articleDraft
        }
    },
}

export default article