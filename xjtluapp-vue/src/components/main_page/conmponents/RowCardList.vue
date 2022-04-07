<template>
  <div class="space">
    <div class="spaceItem" v-for="i in guideList" :key="i.id">

      <el-card class="card">
        <template #header>
          <div class="card-header">
            {{i.name}}
          </div>
        </template>
        <img :src="i.idView">
      </el-card>

    </div>
  </div>
</template>

<script>
export default {
  name: "RowCardList"
}
</script>

<script setup>
const guideList = [
  {id:1,name:"New Student",idView:require('@/assets/guide/fresh.png')},
  {id:1,name:"Campus IT",idView:require('@/assets/guide/it.png')},
  {id:1,name:"Campus Live",idView:require('@/assets/guide/live.png')},
  {id:1,name:"Academic",idView:require('@/assets/guide/academic.png')},
  {id:1,name:"2+2",idView:require('@/assets/guide/liverpool.png')},
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

.card:hover{
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