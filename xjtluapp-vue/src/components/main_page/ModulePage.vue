<template>
  <div class="bottomLink" style="background-color: #FFFFFF">

      <div class="customLink" v-for="(type, index) in typeList" :key="index">
        <div class="customLinkTitle">
          <span>{{type.name + ":"}}</span>
        </div>
        <div class="customLinkBlock">
          <div class="customLinkItem" v-for="(item, index) in type.item" :key="index">
            <el-link :underline="false">{{item}}</el-link>
          </div>
        </div>
        <el-divider v-if="index < typeList.length - 1" style="margin: 5px"/>
      </div>

  </div>

  <br/>

  <div class="customSpace">
    <div class="customSpaceItem" v-for="i in Moduleimg" :key="i.id">

      <el-card class="box-card" style="display: block; margin: 10px">
        <template #header>
          <div class="card-header"
               style="height:5px"
          >
            {{i.name}}
          </div>
        </template>
        <img :src="i.idView" class="image">
      </el-card>

    </div>
  </div>

</template>

<script>
export default {
  name: "ModulePage",
}
</script>

<script setup>
import {reactive} from "vue";

const typeList = reactive([])
typeList.push(
    {
      name: "School",
      item: ["XJTLU", "Liverpool"]
    },
    {
      name: "Semester",
      item: ["Semester2", "Semester2"]
    },
    {
      name: "Grade",
      item: ["Year1", "Year2", "Year3", "Year4"]
    },
    {
      name: "Major",
      item: ["ICS", "CST", "ECO"]
    },
    {
      name: "Test",
      item: ["TestMultiplyLine", "TestMultiplyLine", "TestMultiplyLine", "TestMultiplyLine", "TestMultiplyLine", "TestMultiplyLine"]
    },
)
const Moduleimg = [
  {name:"Powerpoint",idView:require('@/assets/guide/fresh.png')},
  {name:"Notes",idView:require('@/assets/guide/it.png')},
  {name:"Past exam",idView:require('@/assets/guide/live.png')},
  {name:"Source",idView:require('@/assets/guide/academic.png')},
  {name:"Digital library",idView:require('@/assets/guide/liverpool.png')},
]
</script>

<style scoped>

.bottomLink{
  margin-top: 10px;
}

.bottomLink {
  text-align: center;
}

header{
  background: rgba(28, 95, 162, 0.99);

}

.image{
  width: 100%;
  height: 100px;
  min-height: 160px;
}

.customLink {
  text-align: left;
  display: flex;
  flex-flow: row wrap;

  /*border-bottom-style: dashed;*/
  /*border-width: 2px;*/
  /*padding: 10px*/

}

.customLink:last-child {
  border: none;
}

.customLinkBlock {
  flex: 1;
  text-align: left;
  display: flex;
  flex-flow: row wrap;

}

.customLinkTitle {
  flex: 0 0 15%;
  margin: 5px 10px;
  font-size: 15px;
}

.customLinkItem {
  flex: 0;
  margin: 5px 10px;
  font-size: 15px;
}

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