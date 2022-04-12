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
    date: '2021-07-07',
    name: '揭开代办费的秘密',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=2247508483&idx=1&sn=dbe97e6b492ac2586915541d01993334&scene=19#wechat_redirect'
  },
  {
    date: '2021-07-15',
    name: '想申诉成绩？兔兔有话说',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=2247508653&idx=1&sn=77c76efdcf98aa5a612c3fbad8f45a3e&scene=19#wechat_redirect'
  },
  {
    date: '2021-06-27',
    name: '2021专属暑期留校tips！',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=2247508054&idx=1&sn=effc5a493fa265f0b3abddd65916132d&scene=19#wechat_redirect'
  },
  {
    date: '2021-03-27',
    name: '你想知道的补考+CP+重修规则来啦',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=100022403&idx=1&sn=c41e807be3e1fe721add6f0dc07b7b22&scene=19#wechat_redirect'
  },
  {
    date: '2020-12-12',
    name: '淋最少的雨，上最快的学',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=100018868&idx=6&sn=914c215d2981138f1350eb2e36059966&scene=19#wechat_redirect'
  },


]
</script>
