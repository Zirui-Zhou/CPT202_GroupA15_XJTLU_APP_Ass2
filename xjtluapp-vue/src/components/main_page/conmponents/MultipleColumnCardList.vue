<template>
  <div class="space">
    <el-button v-show="unshowit" type="primary" @click="unshowit1()">
      <el-icon style="vertical-align: middle;">
        <back/>
      </el-icon>
      <span style="vertical-align: middle;"> 返回上一页 </span>
    </el-button>
    <div class="spaceItem" v-for="i in guideList" :key="i.id">

      <el-card v-show="showit" shadow="hover" class="card"
               @click="showit1()">
        <template #header>
          <div class="card-header">
            {{ i.name }}
          </div>
        </template>
        <img :src="i.idView">
      </el-card>

    </div>
    <MultipleColumnCardList_sublist v-show="unshowit"></MultipleColumnCardList_sublist>
  </div>
</template>

<script>
import MultipleColumnCardList_sublist from "@/components/main_page/conmponents/MultipleColumnCardList_sublist";
export default {
  name: "RowCardList",
  components: {MultipleColumnCardList_sublist},
  data() {
    return {
      showit: true,
      unshowit: false
    }
  },
  methods: {

    showit1() {
      this.showit = false;
      this.unshowit = true;
    },
    unshowit1() {
      this.showit = true;
      this.unshowit = false;
    },

  }
}
</script>

<script setup>
import {Back} from '@element-plus/icons-vue';

const guideList = [
  {id: 1, name: "New Student", idView: require('@/assets/guide/fresh.png')},
  {id: 1, name: "Campus IT", idView: require('@/assets/guide/it.png')},
  {id: 1, name: "Campus Live", idView: require('@/assets/guide/live.png')},
  {id: 1, name: "Academic", idView: require('@/assets/guide/academic.png')},
  {id: 1, name: "2+2", idView: require('@/assets/guide/liverpool.png')},
]
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
