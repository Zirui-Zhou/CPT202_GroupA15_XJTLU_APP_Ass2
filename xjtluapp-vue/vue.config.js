const { defineConfig } = require('@vue/cli-service')

module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,

  chainWebpack: (config) => {
    config.module
        .rule("raw")
        .test(/\.md$/)
        .use("raw-loader")
        .loader("raw-loader")
        .end();
  },
})
