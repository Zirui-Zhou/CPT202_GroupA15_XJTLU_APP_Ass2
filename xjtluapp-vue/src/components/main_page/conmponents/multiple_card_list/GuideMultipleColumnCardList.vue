<template>
  <div v-loading="isLoading" class="space">

    <div
        class="spaceItem"
        v-for="item in guideTypeList"
        :key="item.typeId"
    >
      <el-card shadow="hover" class="card" @click="clickCard(item.typeId)">
        <template #header>
          <div class="card-header">
            {{ item.typeName }}
          </div>
        </template>
        <img :src="item.typeImage">
      </el-card>
    </div>

  </div>
</template>

<script setup>
import {computed, onMounted, ref, watch} from "vue";
import {getGuideTypeList} from "@/scripts/handleGuideApi";
import {useRouter} from "vue-router";
import {useStore} from "vuex";

const router = useRouter()
const store = useStore()

const isLoading = ref(false)
const guideTypeList = computed(()=>store.getters.getGuideTypeList)

const loadGuideType = async () => {
  await store.commit("SET_GUIDE_TYPE_LIST", await getGuideTypeList())
}

const clickCard = (type) => {
  router.push({path: "/guide/detail", query: {type: type}})
}

watch(()=>store.getters.getLang, ()=>loadGuideType())

onMounted(async () => await loadGuideType())

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

  /*Ensure the loading animation in the right position*/
  min-height: 300px;
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
