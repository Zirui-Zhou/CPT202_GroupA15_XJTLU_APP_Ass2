import { createRouter, createWebHashHistory } from 'vue-router'
import {getIsAuth, needLogin} from "@/scripts/handleUserApi";
import {addMessage} from "@/scripts/messageUtils";

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
        meta: {
          requireNoAuth: true
        },
        component: () => import("@/components/login_page/LoginForm")
      },
      {
        path: 'register',
        name: 'Register',
        meta: {
          requireNoAuth: true
        },
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

router.beforeEach(async (to) => {
  if (to.matched.some(res => res.meta.requireAuth)) {
    await needLogin()
  }
})

router.beforeEach(async (to) => {
  if (to.matched.some(res => res.meta.requireNoAuth)) {
    if (await getIsAuth()) {
      addMessage("Please logout first", "warning")
      return false
    }
  }
})

export default router
