export default [{
    path: '/',
    name: 'MainPage',
    component: () => import("@/views/MainPage"),
    redirect: "/guide",
    children: [
        {
            path: 'home',
            name: 'Home',
            meta: {
                requireAuth: true
            },
            component: () => import('@/components/main_page/home_page/HomePage')
        },
        {
            path: '/guide',
            name: 'Guide',
            component: () => import('@/components/main_page/guide_page/GuidePage'),
        },
        {
            path: 'guide/detail',
            name: 'GuideDetail',
            component: () => import("@/components/main_page/guide_page/GuideDetailPage")
        },
        {
            path: 'module',
            name: 'Module',
            meta: {
                requireAuth: true
            },
            component: () => import('@/components/main_page/module_page/ModulePage')
        },
        {
            path: 'student',
            name: 'Student',
            meta: {
                requireAuth: true
            },
            component: () => import('@/components/main_page/student_page/StudentPage')
        },
        {
            path: 'search',
            name: 'search',
            meta: {
                requireAuth: true
            },
            component: () => import('@/components/main_page/search_page/SearchPage')
        },
    ]
}]
