<template>

    <h1>
      {{ $t('message.article_comment.comments_title') }}
    </h1>
    <el-row style="display:flex; justify-content:space-between;margin: auto 32px; min-height: 400px">
      <AvatarWithCard :user-info="userInfo"/>
      <el-input
          class="commentInput"
          v-model="textarea"
          type="textarea"
          :placeholder="$t('message.article_comment.input_placeholder_input')"
          resize="none"
          :autosize="{minRows:3}"
          :maxlength="256"
          show-word-limit
      />
      <el-button
          type="primary"
          class="commentButton"
          plain
      >
        {{ $t('message.article_comment.button_confirm') }}
      </el-button>
    </el-row>

</template>

<script setup>
import AvatarWithCard from "@/components/AvatarWithCard";
import { ref, computed } from 'vue'
import {useStore} from "vuex";

const store = useStore()

const textarea = ref('')

const userInfo = computed(()=>store.getters.getUserInfo)

</script>

<style scoped>

.commentButton{
  font-size: 18px;
  padding:18px;
}

.commentInput{
  width: 75%;
  margin-top: 0;
  margin-bottom: auto;
  font-size: 16px;
}

</style>