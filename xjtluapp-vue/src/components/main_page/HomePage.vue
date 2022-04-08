<template>

  <MultipleColumnCardList/>

  <br/>

  <div class="customSpace">
    <div class="customSpaceItem" v-for="i in guideUrl" :key="i.id">
      <el-button
          type="default"
          style="display:block; width: 200px; margin: 10px auto"
          @click="openurl(i.url)"
      >
        {{i.name}}
      </el-button>
    </div>

  </div>

</template>

<script>
export default {
  name: "HomePage"
}
</script>

<script setup>

  import MultipleColumnCardList from "@/components/main_page/conmponents/MultipleColumnCardList";

  const guideUrl = [
    {name: "E-bridge", url: "https://ebridge.xjtlu.edu.cn"},
    {name: "Learning Mall", url: "https://learningmall.xjtlu.edu.cn"},
    {name: "Library", url: "https://lib.xjtlu.edu.cn"},
    {name: "Utalk", url: "https://utalk.xjtlu.edu.cn"},
    {name: "Box", url: "https://box.xjtlu.edu.cn"},
    {name: "Mediasite", url: "https://video.xjtlu.edu.cn"},
    {name: "Email", url: "https://mail.xjtlu.edu.cn"},
  ]

  const openurl = (url) => {
    window.open(url)
  }

</script>

<style scoped>

.customSpace {
  text-align: center;
  display: flex;
  align-content: flex-start;
  flex-flow: row wrap;
}

.customSpaceItem {
  flex: 0 0 33.3%;
}

</style>

