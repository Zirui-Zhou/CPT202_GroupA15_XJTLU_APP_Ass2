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
    date: '2021-06-30',
    name: '升学数据出炉！兔兔带你解读',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=2247508142&idx=2&sn=ec17f780a93e57a3774631b5c1945e41&scene=19#wechat_redirect'
  },
  {
    date: '2021-08-02',
    name: '新生缴费指南',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=2247509233&idx=2&sn=50b716a13e4776bae208d4c6fe0fef96&scene=19#wechat_redirect'

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
    date: '2021-07-23',
    name: '西浦宿舍大揭秘',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=2247500332&idx=1&sn=574555dd9e3fdda435d6193ad46cb640&scene=19#wechat_redirect'  },
  {
    date: '2021-06-28',
    name: '新生注册小贴士',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=2247509112&idx=2&sn=184e246c421fb85e597969271f85fd55&scene=19#wechat_redirect'
  },

  {
    date: '2019-08-28',
    name: '报到流程早知道，都要准备些啥？',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=2247496253&idx=2&sn=17661feaaee5e5e0c158889db2429ce1&scene=19#wechat_redirect'
  },

  {
    date: '2018-07-31',
    name: '西浦必备联系方式',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=2247488973&idx=1&sn=d1b80f56a086e9a5c59aa65fff4e5771&scene=19#wechat_redirect'
  },


]
</script>
