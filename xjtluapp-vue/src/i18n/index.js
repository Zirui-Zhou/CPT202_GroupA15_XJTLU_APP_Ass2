import { createI18n } from "vue-i18n";

const configs = []
const files = require.context('./config', true, /\.js$/)

files.keys().forEach(file => {
    const moduleName = file.replace(/(^\.\/)|(.js$)/g, '');
    configs[moduleName] = files(file).default || files(file);
});

const i18n = createI18n({
    locale: 'en',
    fallbackLocale: 'en',
    legacy: false,
    globalInjection: true,
    messages: {
        ...configs
    }
})

export default i18n