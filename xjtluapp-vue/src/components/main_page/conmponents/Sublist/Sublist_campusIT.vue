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
    date: '2021-08-16',
    name: '大学生好伙伴-电脑要怎么挑',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=2247510817&idx=1&sn=7efdec547b023089acc83df1630c7d29&scene=19#wechat_redirect'  },
  {
    date: '2021-08-23',
    name: '邮箱使用的秘诀',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=2247510329&idx=2&sn=ade8b54ffbc22f0b25602d18118fc25f&scene=19#wechat_redirect',

  },
  {
    date: '2021-07-22',
    name: '密码过期？兔兔教你怎么更新密码！',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=2247508997&idx=1&sn=dda7819a57f4f036d7e35711e597a6df&scene=19#wechat_redirect',  },
  {
    date: '2021-04-15',
    name: 'IT自助重置密码上线，还不快冲',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=2247506394&idx=1&sn=8c1302fd089b6fb6436f92e3978ce10c&scene=19#wechat_redirect'  },
  {
    date: '2021-12-22',
    name: '小兔叽带着新鲜的VPN教程来啦',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=100018868&idx=4&sn=a7c7f6c3bb02c794790c96b7fd439756&scene=19#wechat_redirect'  },

  {
    date: '2021-12-22',
    name: '小主人期盼的打印干货来啦！',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=100018868&idx=5&sn=6f43447e0f4a54d53c29616aec0fe5be&scene=19#wechat_redirect'
  },

  {
    date: '2017-11-27',
    name: '学校WIFI连接设备满了怎么办?',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=2247486036&idx=1&sn=9c470354717e45e48cb50bd19d07c7da&scene=19#wechat_redirect'

  },
  {
    date: '2017-8-24',
    name: '如何交学费',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link:'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=2247484407&idx=1&sn=4b43b59acb01423dfd71098af6766295&scene=19#wechat_redirect'
      },

  {
    date: '2019-01-21',
    name: '最新西浦90小时实习报告提交步骤',
    state: 'China',
    city: 'Suzhou',
    address: 'Renai Road NO.111',
    zip: '216028',
    link: 'https://mp.weixin.qq.com/s?__biz=MzU5NzEwNDcwMw==&mid=2247493191&idx=1&sn=dbbf09e22cbf169319a8287905895f9f&scene=19#wechat_redirect'
  },

]
</script>
