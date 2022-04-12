<template>
  <el-table :data="tableData" style="width: 100%">
    <el-table-column type="expand">
      <template #default="props">
        <p>State: {{ props.row.state }}</p>
        <p>City: {{ props.row.city }}</p>
        <p>Address: {{ props.row.address }}</p>
        <el-button type="primary" @click="openurl(props.row.link)">
          <el-icon style="vertical-align: middle;">
            <Key/>
          </el-icon>
          <span style="vertical-align: middle;"> 跳转 </span>
        </el-button>



      </template>
    </el-table-column>
    <el-table-column label="日期" prop="date"/>
    <el-table-column label="标题" prop="name"/>
  </el-table>

</template>

<script setup>
import {Key} from '@element-plus/icons-vue';


const openurl = (url) => {
  window.open(url)
}

const tableData = [
  {
    date: '2020-06-12',
    name: '2+2干货|汇总小指南准时上线！',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=2247499722&idx=1&sn=aa59a064bfc8911c0261e6a212a1d683&scene=19#wechat_redirect'
  },
  {
    date: '2020-07-03',
    name: '2+2 肺结核体检超全干货！',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=2247499866&idx=1&sn=30e513015dc60949eb649ffe340666cf&scene=19#wechat_redirect'
  },
  {
    date: '2021-07-07',
    name: '揭开代办费的秘密',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: ''
  },



]
</script>
