<template>
  <div style="width: 900px; margin: auto">
    <TopMenu/>
    <br/>
    <router-view/>
  </div>
</template>

<script>
import TopMenu from "@/components/main_page/TopMenu";

export default {
  name: "MainPage",
  components: {
    TopMenu
  }
}
</script>

<style scoped>

</style>