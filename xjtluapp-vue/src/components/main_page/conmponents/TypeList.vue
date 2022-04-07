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

      <span class="customLinkTitle">{{type.name + ":"}}</span>

      <div class="customLinkBlock">
        <div class="customLinkItem" v-for="(item, index) in type.item" :key="index">
          <el-link
              :underline="false"
              @click="handleLinkClick(item)"
              :type="selectedList.indexOf(item) === -1 ? 'default' : 'primary'"
          >
            {{item}}
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
import {reactive} from "vue";

const selectedList = reactive(["XJTLU", "Liverpool"])
const typeList = reactive([])
typeList.push(
    {
      name: "School",
      item: ["XJTLU", "Liverpool"]
    },
    {
      name: "Semester",
      item: ["Semester1", "Semester2"]
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
}

.customLinkTitle {
  flex: 0 0 15%;
  margin: 5px;
  font-size: 15px;
}

.customLinkItem {
  /*flex: 0;*/
  margin: 5px 10px;
  font-size: 15px;
}
</style>