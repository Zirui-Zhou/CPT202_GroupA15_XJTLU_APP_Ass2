import { createRouter, createWebHashHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    name: 'MainPage',
    component: () => import("@/views/MainPage"),
    children: [
      {
        path: 'guide',
        name: 'Guide',
        component: () => import('@/components/main_page/GuidePage')
      },
      {
        path: 'home',
        name: 'Home',
        component: () => import('@/components/main_page/HomePage')
      },
      {
        path: 'module',
        name: 'Module',
        component: () => import('@/components/main_page/ModulePage')
      },
      {
        path: 'student',
        name: 'Student',
        component: () => import('@/components/main_page/StudentPage')
      },
    ]
  },
  {
    path: '/user',
    name: 'User',
    component: () => import("@/views/LoginPage"),
    children: [
      {
        path: 'login',
        name: 'Login',
        component: () => import("@/components/login_page/LoginForm")
      },
      {
        path: 'register',
        name: 'Register',
        component: () => import("@/components/login_page/RegisterForm")
      },
    ]
  },
  {
    path: '/article',
    name: 'article',
    component: () => import("@/views/ArticlePage")
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
