<template>

  <CarouselList/>

  <br/>

  <el-tabs
      v-model="activeTab"
      class="demo-tabs"
  >

    <el-tab-pane
        :name="item.typeId"
        v-for="item in articleTypeList"
        :key="item.typeId"
    >
      <template #label>
        <span class="custom-tabs-label">
          <el-icon style="margin-right: 5px">
            <component :is="item.typeIcon"/>
          </el-icon>
          <span>{{ item.typeName }}</span>
        </span>
      </template>
    </el-tab-pane>

  </el-tabs>

  <SingleColumnCardList
      :key="activeTab"
      list-type="type"
      :list-func-param="[activeTab]"
  />

</template>

<script>
import {DataAnalysis, Document, Medal, OfficeBuilding} from "@element-plus/icons-vue";

export default {
  components: {
    Document: Document,
    Medal: Medal,
    OfficeBuilding: OfficeBuilding,
    DataAnalysis: DataAnalysis
  }
}
</script>

<script setup>
import {computed, ref} from 'vue'
import SingleColumnCardList from "@/components/main_page/conmponents/card_list/SingleColumnCardList";
import CarouselList from "@/components/main_page/conmponents/CarouselList";
import {useStore} from "vuex";

const store = useStore()

const activeTab = ref(1)

const articleTypeList = computed(()=>store.getters.getArticleTypeList)

</script>

<style scoped>

  .demo-tabs > .el-tabs__content {
    padding: 32px;
    color: #6b778c;
    font-size: 32px;
    font-weight: 600;
  }

  .demo-tabs{
    background-color: white;
  }


</style>