export default [{
    path: '/user',
    name: 'User',
    component: () => import("@/views/LoginPage"),
    children: [
        {
            path: 'login',
            name: 'Login',
            meta: {
                requireNoAuth: true
            },
            component: () => import("@/components/login_page/LoginForm")
        },
    ]
}]