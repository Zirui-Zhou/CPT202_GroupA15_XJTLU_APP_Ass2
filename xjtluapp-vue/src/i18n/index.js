import { createI18n } from "vue-i18n";
import en from "@/i18n/config/en"
import zh from "@/i18n/config/zh"
import jp from "@/i18n/config/jp"
import fr from "@/i18n/config/fr"
import es from "@/i18n/config/es"

const i18n = createI18n({
    locale: 'en',
    fallbackLocale: 'en',
    legacy: false,
    globalInjection: true,
    messages: {
        en,
        zh,
        jp,
        fr,
        es,
    }
})

export default i18n