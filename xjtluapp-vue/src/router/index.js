import { createRouter, createWebHashHistory } from 'vue-router'
import {getIsAuth} from "@/components/handleUser";
import {ElNotification} from "element-plus";

const routes = [
  {
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
        component: () => import('@/components/main_page/HomePage')
      },
      {
        path: 'guide',
        name: 'Guide',
        component: () => import('@/components/main_page/GuidePage')
      },
      {
        path: 'module',
        name: 'Module',
        meta: {
          requireAuth: true
        },
        component: () => import('@/components/main_page/ModulePage')
      },
      {
        path: 'student',
        name: 'Student',
        meta: {
          requireAuth: true
        },
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

router.beforeResolve(async (to) => {
  if (to.matched.some(res => res.meta.requireAuth)) {
    if (! await getIsAuth()) {
      ElNotification({
        title: "Warning",
        message: "Please login first",
        type: 'warning',
        duration: 2000,
      })
      return {path: '/user/login',}
    }
  }
})

export default router
