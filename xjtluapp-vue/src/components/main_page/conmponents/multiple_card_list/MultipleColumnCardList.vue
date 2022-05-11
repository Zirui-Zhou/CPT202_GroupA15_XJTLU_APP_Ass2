<template>
  <div v-loading="isLoading" class="space">

    <div
        class="spaceItem"
        v-for="item in itemList"
        :key="item[itemKeyList.id]"
    >
      <el-card
          shadow="hover"
          class="card"
          @click="clickCard(item[itemKeyList.path])"
      >
        <template #header>
          <div class="cardHeader">
            {{ item[itemKeyList.name] }}
          </div>
        </template>
        <el-image
            class="image"
            :src="item[itemKeyList.image]"
            fit="cover"
        />
      </el-card>
    </div>

  </div>
</template>

<script setup>
import { defineProps } from "vue";

defineProps({
  itemList: Object,
  isLoading: Boolean,
  clickCard: Function,
  itemKeyList: {
    type: Object,
    default: () => {
      return {
        id: "id",
        path: "path",
        name: "name",
        image: "image",
      }
    }
  },
})
</script>

<style scoped>
.image {
  width: 100%;
  height: 160px;
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

.cardHeader {
  text-align: center;
}
</style>