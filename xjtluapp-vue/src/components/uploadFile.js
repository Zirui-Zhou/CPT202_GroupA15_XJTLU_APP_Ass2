// let param = new FormData(); //创建form对象
// param.append('file', rawFile);//通过append向form对象添加数据
// console.log(param.get('file')); //FormData私有类对象，访问不到，可以通过get判断值是否传进去
// // let config = {
// //   headers:{'Content-Type':'multipart/form-data'} //这里是重点，需要和后台沟通好请求头，Content-Type不一定是这个值
// // }; //添加请求头
// // await axios.post('http://localhost:8081/upload',param,config)
// await axios.post('http://localhost:8081/upload',param)
//     .then(response=>{
//       console.log(response.data);
//     })