<template>
  <br/>
  <div class="title">
    <div class="v-md-editor" style="border-bottom: 1px solid #ddd; flex-flow: row wrap;">
      <textarea
          id="textarea"
          v-model="articleTitle"
          spellcheck="false"
          class="titleInput"
          placeholder="Please input the title"
          maxlength="64"
          rows="1"
      />

      <div style="width: 100%; margin: 0 32px 24px 32px;">

        <p>{{ getFormattedTime(editTime) }}</p>

        <el-row>
          <AvatarWithCard
              :user-info="userInfo"
              :is-show-email="false"
          />
          <div style="margin-left: 20px">
            <span class="name">
              {{ userInfo.realName }}
            </span>
              <span class="email">
              {{ userInfo.email }}
            </span>
          </div>
        </el-row>

      </div>
    </div>
  </div>

  <div class="content">
    <v-md-editor v-model="articleContent" height="600px"/>
  </div>

  <br/>
  <h2>Please select type:</h2>

  <el-button
      size="large"
      :icon="this[item.typeIcon]"
      :type="item.typeId === articleType ? 'primary' : 'default'"
      round v-for="item in articleTypeList"
      :key="item.typeName"
      @click="articleType = item.typeId"
  >
    {{ item.typeName }}
  </el-button>

  <br/>
  <h2>Preview:</h2>

  <el-card class="card">

    <CardIconList
        :item="item"
        listType="common"
        :itemFunc="itemFunc"
    />

    <CardArticleInfo
        :item="item"
        :itemFunc="itemFunc"
    />

    <CardUserInfo
        :item="item"
    />

  </el-card>

  <div style="display: flex; justify-content: flex-end">
    <el-button type="default" class="submitButton">
      Draft
    </el-button>
    <el-button type="primary" class="submitButton">
      Submit
    </el-button>
  </div>
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
import {onMounted, ref, computed, reactive, onBeforeMount} from "vue";
import {useStore} from "vuex"
import {getFormattedTime} from "@/scripts/utils/commonUtils";
import AvatarWithCard from "@/components/AvatarWithCard"
import CardIconList from "@/components/main_page/conmponents/single_card_list/CardIconList";
import CardArticleInfo from "@/components/main_page/conmponents/single_card_list/CardArticleInfo";
import CardUserInfo from "@/components/main_page/conmponents/single_card_list/CardUserInfo";
import {getAllArticleTypes} from "@/scripts/api/handleArticleApi";
import {Search} from "@element-plus/icons-vue";

const store = useStore()

const userInfo = computed(()=>store.getters.getUserInfo)
const editTime = ref(new Date().getTime())
const articleTitle = ref("")
const articleContent = ref("")
const articleType = ref(1)

const articleTypeList = computed(()=>store.getters.getArticleTypeList)

setInterval(() => {
  editTime.value = new Date().getTime()
}, 1000)

const item = reactive({
  title: articleTitle,
  image: null,
  editorTime: editTime,
  editorName: userInfo.value.realName,
  avatar: userInfo.value.avatar,
  isFavourite: false,
  typeId: articleType,
})

const itemFunc = async (item, key, value) => {
  item[key] = value
}

onMounted(()=>{
  document.getElementById("textarea").addEventListener("input", function() {
    this.style.height = "inherit";
    this.style.height = `${this.scrollHeight}px`;
  });

  document
      .getElementsByClassName("v-md-textarea-editor")
      .item(0)
      .getElementsByTagName("textarea")
      .item(0)
      .setAttribute("style", "background-color: white")

})

onBeforeMount(async ()=>{
  await getAllArticleTypes()
})

</script>

<style>

.title .v-md-editor{
  border-radius: 4px 4px 0 0;
}

.content .v-md-editor{
  box-shadow: 0 8px 10px 0 rgb(0 0 0 / 10%);
  border-radius: 0 0 4px 4px;
}

.content .v-md-textarea-editor{
  background-color: white;
}

</style>

<style scoped>
.titleInput{
  width: 100%;
  border: none;
  outline: none;
  resize: none;
  font-size: 2em;
  font-weight: bold;
  font-family: inherit;
  margin: 24px 32px 0 32px;
  overflow-y: hidden;
  background-color: white;
}

.name{
  position: absolute;
  top: 0;
  font-weight: bold;
  font-size: 20px
}

.email{
  position: absolute;
  bottom: 0;
}

.submitButton{
  width: 130px;
  font-size: 20px;
  padding: 20px;
  margin: 32px 32px 32px 0;
}

.card{
  position: relative;
  height: 200px;
}

.card:hover{
  transform: scale(1.05);
  position: relative;
  z-index: 1;
  transition: 0.5s;

  cursor: pointer;
}

</style>