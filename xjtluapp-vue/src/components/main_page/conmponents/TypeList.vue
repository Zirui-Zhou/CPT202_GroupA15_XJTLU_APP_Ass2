<template>
  <div style="background-color: #FFFFFF">

    <div class="customLink" v-show="selectedList.length > 0">
      <span class="customLinkTitle">Classification:</span>
      <div class="customLinkBlock">
        <el-tag
            v-for="tag in selectedList"
            :key="tag"
            closable
            style="margin: 5px; vertical-align: middle"
            @close="handleClose(tag)"
        >
          {{tag}}
        </el-tag>
      </div>
    </div>

    <div class="customLink" v-for="(type, index) in typeList" :key="index">

      <span class="customLinkTitle">{{type.typeName + ":"}}</span>

      <div class="customLinkBlock">
        <div class="customLinkItem" v-for="(tag, index) in type.tagName" :key="index">
          <el-link
              :underline="false"
              @click="handleLinkClick(tag)"
              :type="selectedList.indexOf(tag) === -1 ? 'default' : 'primary'"
          >
            {{tag}}
          </el-link>
        </div>
      </div>
      <!--        <el-divider v-if="index < typeList.length - 1" style="margin: 5px"/>-->
    </div>

  </div>
</template>

<script>
export default {
  name: "TypeList"
}
</script>

<script setup>
import {onBeforeMount, reactive} from "vue";
import {getTagTypeList} from "@/components/handleArticle";

const selectedList = reactive([])
const typeList = reactive([])


const handleClose = (tag) => {
  selectedList.forEach((item, index, arr) => {
    if (item === tag) {
      arr.splice(index,1);
    }
  })
}

const handleLinkClick = (item) => {
  if(selectedList.indexOf(item) === -1) {
    selectedList.push(item)
  } else {
    handleClose(item)
  }
}

onBeforeMount(async ()=> typeList.push(...await getTagTypeList()))

</script>

<style scoped>

.customLink {
  text-align: left;
  display: flex;
  flex-flow: row wrap;

  border-bottom: 2px dashed var(--el-border-color);

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
  margin: 5px auto;
}

.customLinkTitle {
  flex: 0 0 15%;
  margin: auto 10px;
  font-size: 15px;
}

.customLinkItem {
  /*flex: 0;*/
  margin: 5px 10px;
  font-size: 15px;
}
</style>