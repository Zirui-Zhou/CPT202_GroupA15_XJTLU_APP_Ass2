<template>
  <component
      :is="rootType"
      v-bind="attrs"
      v-for="item in articleList"
      :key="item.id"
      :timestamp="getFormattedTime(item.createTime)"
  >
    <br/>
    <el-card class="card" @click="clickCard(item.id)">
      <div style="display: inline-block;">
        <h3 style="margin-top: 0">{{item.title}}</h3>
        <el-image class="img" v-if="item.isLoading" v-loading="true">
          <template #error><div/></template>
        </el-image>
        <el-image
            class="img"
            style="object-fit: cover"
            v-show="!item.isLoading"
            :src="item.image"
            @load="item.isLoading=false"
        />
      </div>
      <div style="display: inline-block; position:absolute; right: 20px; bottom: 20px">
        <el-avatar class="avatar" :size="50" :src="item.avatar" style="margin: auto; "/>
        <br/>
        <span>{{item.userName}}</span>
        <span>&nbsp;2022.4.7</span>
      </div>
    </el-card>
  </component>

  <component
      :is="rootType"
      v-bind="attrs"
  >
    <br/>
    <el-card v-loading="true" v-show="isLoading" class="card"/>
    <el-card v-show="isNothing" class="card" style="text-align: center">
      <h2>There is nothing below.</h2>
    </el-card>
  </component>


</template>

<script>
export default {
  name: "SingleColumnCardList"
}
</script>

<script setup>
  import {onBeforeMount, reactive, ref, defineProps, watch} from "vue";
  import {getArticleList, clickCard} from "@/components/handleArticle";
  import moment from "moment"
  import {useStore} from "vuex";

  const articleList = reactive([])
  const currentPage = ref(0)
  const isLoading = ref(false)
  const isNothing = ref(false)

  const store = useStore()

  const props = defineProps({
    rootType: {
      type: String,
      default: "div",
    },
    getListFunc: {
      type: Function,
      default: getArticleList,
    },
    funcParams: {
      type: Array,
      default: () => [],
    },
    sizePage: {
      type: Number,
      default: 4
    },
    cardScale: {
      type: Number,
      default: 1.05
    },
    attrs: {
      type: Object,
      default: () => {}
    }
  })

  const delay = ms => new Promise(res => setTimeout(res, ms))

  const cardScale = props.cardScale.valueOf()

  const loadNewArticle = async () => {
    isLoading.value = true
    if(currentPage.value !== 0) {
      await delay(1000)
    }
    const result = await props.getListFunc(currentPage.value + 1, props.sizePage, ...props.funcParams)
    if(result.length === 0) {
      isNothing.value = true
      isLoading.value = false
      return
    }
    currentPage.value++
    result.forEach((item) => Object.assign(item, {isLoading: true}))
    articleList.push(...result)
    isLoading.value = false
  }

  const getFormattedTime = (time) => {
    return moment(time).format('YYYY-MM-DD HH:mm:ss')
  }

  window.onscroll = async (event) => {
    if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight && !isLoading.value && !isNothing.value) {
      await loadNewArticle()
    }
  }

  onBeforeMount(async () => loadNewArticle())

  // const watchUserInfo = watch(store.state.userInfo, (newValue, oldValue) => {
  //   articleList
  // })

</script>

<style scoped>
.img{
  height: 110px;
  width: 165px;
}

.card{
  position: relative;
  height: 200px;
}

.card:hover{
  transform: scale(v-bind(cardScale));
  position: relative;
  z-index: 1;
  transition: 0.5s;

  cursor: pointer;
}

.avatar{
  position: relative;
  left: 50%;
  transform: translateX(-50%);
}
</style>