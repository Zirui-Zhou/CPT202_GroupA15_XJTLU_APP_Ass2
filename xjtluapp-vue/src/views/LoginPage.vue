<template>
  <div v-show="!isLogin" style="width: 450px; margin: 10% auto;">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: "LoginPage"
}
</script>

<script setup>
import {onBeforeMount, ref} from "vue";
import {useRouter} from "vue-router";
import {getIsAuth} from "@/components/handleUser";

const router = useRouter()

const isLogin = ref(true)

onBeforeMount(async () => {
  if(await getIsAuth()) {
    await router.push("/")
  }
  isLogin.value = false
})

</script>

<style scoped>

</style>