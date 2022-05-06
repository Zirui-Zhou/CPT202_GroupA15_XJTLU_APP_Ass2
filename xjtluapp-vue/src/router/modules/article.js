export default [
    {
        path: '/article',
        name: 'article',
        component: () => import("@/views/ArticlePage"),
        children: [
            {
                path: '',
                name: 'readArticle',
                component: () => import("@/components/article_page/ArticleReader")
            },
            {
                path: 'add',
                name: 'addArticle',
                component: () => import("@/components/article_page/ArticleEditor")
            },
        ]
    },
]