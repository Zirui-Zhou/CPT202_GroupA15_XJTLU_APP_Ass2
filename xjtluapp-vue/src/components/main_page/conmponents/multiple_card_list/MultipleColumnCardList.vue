<template>
  <div class="space">

    <div
        class="spaceItem"
        v-for="item in moduleList"
        :key="item.resourceId"
    >
      <el-card shadow="hover" class="card" @click="clickCard(item.resourcePath)">
        <template #header>
          <div class="card-header">
            {{ item.resourceName }}
          </div>
        </template>
        <img :src="item.resourceImage">
      </el-card>
    </div>

  </div>
</template>

<script setup>
import {getResourceList} from "@/scripts/handleResourceApi";
import {onMounted, reactive, ref} from "vue";
import {delay} from "@/scripts/commonUtils";

const currentPage = ref(0)
const sizePage = 9

const moduleList = reactive([])


const loadNewArticle = async () => {

  if(currentPage.value !== 0) {
    await delay(1000)
  }
  const result = await getResourceList(currentPage.value, sizePage)

  currentPage.value++

  moduleList.push(...result)

}

const clickCard = (url) => {
  window.open(url)
}

onMounted(async () => await loadNewArticle())

</script>

<style scoped>

img {
  width: 100%;
  height: 100px;
  min-height: 160px;
}

.space {
  display: flex;
  flex-flow: row wrap;
}

.spaceItem {
  flex: 0 0 33.3%;
}

.card {
  display: block;
  margin: 10px
}

.card:hover {
  transform: scale(1.05);
  position: relative;
  z-index: 1;
  transition: 0.5s;

  cursor: pointer;
}

.card-header {
  text-align: center;
}

</style>
