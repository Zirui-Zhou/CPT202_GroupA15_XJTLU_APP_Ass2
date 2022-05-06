import { createRouter, createWebHashHistory } from 'vue-router'
import {getIsAuth, needLogin} from "@/scripts/api/handleUserApi";
import {addMessage} from "@/scripts/utils/messageUtils";

const routes = [
  {
    path: '/404',
    name: '404',
    component: () => import('@/views/ErrorPage')
  },
  {
    path: '/:catchAll(.*)',
    redirect: '/404'
  }
]

const files = require.context('./modules', true, /\.js$/)
files.keys().forEach(route => {
  routes.unshift(...(files(route).default || files(route)))
})

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
