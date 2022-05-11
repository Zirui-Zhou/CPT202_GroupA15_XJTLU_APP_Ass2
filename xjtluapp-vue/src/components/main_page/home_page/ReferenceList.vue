<template>
  <div class="space">
    <div
        class="spaceItem"
        v-for="(item, index) in referenceList"
        :key="index"
    >
      <el-button
          type="default"
          class="button"
          @click="openUrl(item.url)"
      >
        {{ item.name }}
      </el-button>
    </div>
  </div>
</template>

<script setup>
const referenceList = [
  {name: "E-bridge", url: "https://ebridge.xjtlu.edu.cn"},
  {name: "Learning Mall", url: "https://learningmall.xjtlu.edu.cn"},
  {name: "Library", url: "https://lib.xjtlu.edu.cn"},
  {name: "Utalk", url: "https://utalk.xjtlu.edu.cn"},
  {name: "Box", url: "https://box.xjtlu.edu.cn"},
  {name: "Mediasite", url: "https://video.xjtlu.edu.cn"},
  {name: "Email", url: "https://mail.xjtlu.edu.cn"},
]

const openUrl = (url) => {
  window.open(url)
}
</script>

<style scoped>
.button {
  display: block;
  width: 70%;
  margin: 10px auto;
}

.space {
  display: flex;
  flex-flow: row wrap;
}

.spaceItem {
  flex: 0 0 33.3%;
}
</style>