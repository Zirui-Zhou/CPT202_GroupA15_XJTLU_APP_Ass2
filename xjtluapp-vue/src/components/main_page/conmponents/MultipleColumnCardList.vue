<template>
  <div class="space">
    <el-button v-show="!showit" type="primary" @click="unshowit1()">
      <el-icon style="vertical-align: middle;">
        <back/>
      </el-icon>
      <span style="vertical-align: middle;"> 返回上一页 </span>
    </el-button>
    <div class="spaceItem" v-for="i in guideList" :key="i.id">

      <el-card v-show="showit" shadow="hover" class="card"
                v-if="i.id==1" @click="showit1">
        <template #header>
          <div class="card-header">
            {{ i.name }}
          </div>
        </template>
        <img :src="i.idView">
      </el-card>

      <el-card v-show="showit" shadow="hover" class="card"
               v-if="i.id==2" @click="showit2">
        <template #header>
          <div class="card-header">
            {{ i.name }}
          </div>
        </template>
        <img :src="i.idView">
      </el-card>

      <el-card v-show="showit" shadow="hover" class="card"
               v-if="i.id==3" @click="showit3">
        <template #header>
          <div class="card-header">
            {{ i.name }}
          </div>
        </template>
        <img :src="i.idView">
      </el-card>

      <el-card v-show="showit" shadow="hover" class="card"
               v-if="i.id==4" @click="showit4">
        <template #header>
          <div class="card-header">
            {{ i.name }}
          </div>
        </template>
        <img :src="i.idView">
      </el-card>

      <el-card v-show="showit" shadow="hover" class="card"
               v-if="i.id==5" @click="showit5">
        <template #header>
          <div class="card-header">
            {{ i.name }}
          </div>
        </template>
        <img :src="i.idView">
      </el-card>

    </div>
    <MultipleColumnCardList_sublist v-show="showit_1"></MultipleColumnCardList_sublist>
    <Sublist_campusIT v-show="showit_2"></Sublist_campusIT>
    <CampusLife v-show="showit_3"></CampusLife>
    <Academic v-show="showit_4"></Academic>
    <twoplustwo v-show="showit_5"></twoplustwo>
  </div>
</template>

<script>
import MultipleColumnCardList_sublist from "@/components/main_page/conmponents/MultipleColumnCardList_sublist";
import Sublist_campusIT from "@/components/main_page/conmponents/Sublist_campusIT";
import CampusLife from "@/components/main_page/conmponents/CampusLife";
import Academic from "@/components/main_page/conmponents/Academic";
import Twoplustwo from "@/components/main_page/conmponents/twoplustwo";
export default {
  name: "RowCardList",
  components: {Twoplustwo, Academic, CampusLife, Sublist_campusIT, MultipleColumnCardList_sublist},
  data() {
    return {
      showit_1: false,
      showit_2: false,
      showit_3: false,
      showit_4: false,
      showit_5: false,
      showit: true
    }
  },
  methods: {

    showit1() {
      this.showit_1 = true;
      this.showit = false;
    },
    showit2() {
      this.showit_2 = true;
      this.showit = false;
    },
    showit3() {
      this.showit_3 = true;
      this.showit = false;
    },
    showit4() {
      this.showit_4 = true;
      this.showit = false;
    },
    showit5() {
      this.showit_5 = true;
      this.showit = false;
    },
    unshowit1() {
      this.showit = true;
      this.showit_1 = false;
      this.showit_2 = false;
      this.showit_3 = false;
      this.showit_4 = false;
      this.showit_5 = false;
    },

  }
}
</script>

<script setup>
import {Back} from '@element-plus/icons-vue';

const guideList = [
  {id: 1, name: "New Student", idView: require('@/assets/guide/fresh.png'),},
  {id: 2, name: "Campus IT", idView: require('@/assets/guide/it.png')},
  {id: 3, name: "Campus Live", idView: require('@/assets/guide/live.png')},
  {id: 4, name: "Academic", idView: require('@/assets/guide/academic.png')},
  {id: 5, name: "2+2", idView: require('@/assets/guide/liverpool.png')},
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
