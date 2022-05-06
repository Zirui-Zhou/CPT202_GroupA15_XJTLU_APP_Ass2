const module = {
    state: {
        selectedTags: [],
    },
    mutations: {
        PUSH_SELECTED_TAG: (state, tag) => {
            state.selectedTags.push(tag)
        },
        POP_SELECTED_TAG: (state, tag) => {
            state.selectedTags.forEach((item, index, array) => {
                if (item === tag) {
                    array.splice(index,1);
                }
            })
        },
    },
    getters: {
        getSelectedTags: state => {
            return state.selectedTags
        },
    },
}

export default module