<template>
  <div class="bottomLink" >
    <el-row :gutter="20" >
      <el-col :span="4" class="bottom" v-for="i in SchoolList"><div class="grid-content ">{{i.Info}}</div></el-col>
    </el-row>

    <el-row :gutter="20" >
    <el-col :span="4" class="bottom" v-for="i in SemesterList"><div class="grid-content ">{{i.Info}}</div></el-col>
    </el-row>

    <el-row :gutter="20" >
    <el-col :span="4" class="bottom" v-for="i in GradeList"><div class="grid-content ">{{i.Info}}</div></el-col>
    </el-row>

    <el-row :gutter="20" >
    <el-col :span="4" class="bottom" v-for="i in MajorList"><div class="grid-content ">{{i.Info}}</div></el-col>
    </el-row>

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

import { ref } from 'vue'
const size = ref(30)

export default {
  name: "ModulePage",
  data(){
    return{
      SchoolList: [
        {Info:"School :"},
        {Info:"All "},
        {Info:"XJTLU"},
        {Info:"Liverpool"},
      ],
      SemesterList: [
        {Info:"Semester :"},
        {Info:"Semester1"},
        {Info:"Semester2"},

      ],
      GradeList: [
        {Info:"Grade :"},
        {Info:"Year1 "},
        {Info:"Year2"},
        {Info:"Year3"},
        {Info:"Year4"},
      ],
      MajorList: [
        {Info:"Major :"},
        {Info:"ICS "},
        {Info:"CST"},
        {Info:"ECO"},
      ],
      Moduleimg:[
        {name:"Powerpoint",idView:require('@/assets/guide/fresh.png')},
        {name:"Notes",idView:require('@/assets/guide/it.png')},
        {name:"Past exam",idView:require('@/assets/guide/live.png')},
        {name:"Source",idView:require('@/assets/guide/academic.png')},
        {name:"Digital library",idView:require('@/assets/guide/liverpool.png')},
      ]
    }
  }
}
</script>

<style scoped>


.bottomLink{
  margin-top: 10px;
}

.grid-content {
  margin-top: 25px;
  border-radius: 4px;
  min-height: 30px;
  background: rgba(233, 236, 239, 0.99);
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