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
    date: '2021-08-10',
    name: '暑期防霉除霉小tips！',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=2247510647&idx=1&sn=d6d6bfe44f074e6f75010ccc3400cd4e&scene=19#wechat_redirect'
  },
  {
    date: '2021-07-11',
    name: '这份夏日防暑指南你值得拥有！',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link:'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=2247508542&idx=1&sn=e39ee1b5bd87af9f8d542a4679b5ca27&scene=19#wechat_redirect'
  },
  {
    date: '2020-12-16',
    name: '芭菲国际公寓终于来啦',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=100019146&idx=3&sn=2d1ba17f378096e43e416eef890f253e&scene=19#wechat_redirect'
  },
  {
    date: '2021-01-12',
    name: '关于快递寄件的那些事儿~',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=100019867&idx=1&sn=cdd541c15268e87b79bb9e5fa9e87cdc&scene=19#wechat_redirect'
  },

  {
    date: '2020-12-27',
    name: '快来和兔兔看看如何绑定学生票的优惠资质吧！',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=100019433&idx=2&sn=fa7599ef006d3024e9b58ae829da6fed&scene=19#wechat_redirect'
  },

  {
    date: '2020-12-21',
    name: '迟到的兔兔军训小贴士！',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=100019296&idx=1&sn=614a2287fb43999082ea432dc28aba13&scene=19#wechat_redirect'
  },
  {
    date: '2018-10-12',
    name: '生病了怎么用医保？',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=2247490550&idx=1&sn=fd98b374616bfeb3c43b55cf50ce7c25&scene=19#wechat_redirect'
  },


]
</script>
