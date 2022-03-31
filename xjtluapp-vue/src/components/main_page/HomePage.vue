<template>
  <div class="customSpace">
    <div class="customSpaceItem" v-for="i in Guideimg" :key="i.id">

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

  const Guideimg = [
    {id:1,name:"New Student",idView:require('@/assets/guide/fresh.png')},
    {id:1,name:"Campus IT",idView:require('@/assets/guide/it.png')},
    {id:1,name:"Campus Live",idView:require('@/assets/guide/live.png')},
    {id:1,name:"Academic",idView:require('@/assets/guide/academic.png')},
    {id:1,name:"2+2",idView:require('@/assets/guide/liverpool.png')},
  ]

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

