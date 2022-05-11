<template>
  <div style="width: 900px; margin: auto">
    <TopMenu/>
    <router-view/>
  </div>
  <BackTopButton/>
</template>

<script setup>
import TopMenu from "@/components/TopMenu";
import BackTopButton from "@/components/BackTopButton";
</script>

<style scoped>

</style>