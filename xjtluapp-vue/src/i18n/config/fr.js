// Contributed by Yi Shen

const fr = {
    language: "Français",
    message:{
        top_menu: {
            menu_item_student: "Étudiant",
            menu_item_home: "Page d'accueil",
            menu_item_guide: "Guide",
            menu_item_module: "Cours",
            input_placeholder_input: "Veuillez entrer",
            input_missing_word_msg: "Veuillez saisir un mot-clé de recherche."
        },
        setting_box: {
            box_title: "Option",
            item_change_dark_mode: "Remplacez le mode nuit.",
            item_change_password: "Remplacez le mode nuit.",
            item_logout: "Quitter",
            item_language: "Langue: ",
        },
        change_password_box: {
            box_title: "Remplacez le mode nuit",
            label_old_pass: "Nouveau mot de passe",
            label_new_pass: "Ancien mot de passe",
            label_confirm_pass: "Confirmez le mot de passe",
            button_submit: "Présenter",
            button_reset: "Réinitialiser",
            msg_missing_old_pass: "Veuillez entrer votre ancien mot de passe.",
            msg_missing_new_pass: "Veuillez entrer un nouveau mot de passe.",
            msg_same_new_pass: "Veuillez entrer un mot de passe différent.",
            msg_missing_check_pass: "Veuillez saisir à nouveau le nouveau mot de passe.",
            msg_different_check_pass: "Les deux nouveaux mots de passe ne correspondent pas.",
        },
        avatar_with_card: {
            userinfo_label_colon: ": ",
            userinfo_label_id: "Compte",
            userinfo_label_major: "Spécialité",
            userinfo_label_grade: "Année",
            button_logout: "Quitter",
            label_no_login: "Veuillez d’abord vous connecter",
        },
        student_page: {
            tab_item_mine: "Mes",
            tab_item_history: "Parcourir l’historique",
            tab_item_favourite: "Favori",
        },
        search_page: {
            label_search_result: "résultats de la recherche de {word}:"
        },
        userinfo_form: {
            userinfo_label_name: "Nom",
            userinfo_label_major: "Spécialité",
            userinfo_label_id: "Compte",
            userinfo_label_grade: "Année",
        },
        upload_image: {
            error_image_wrong_format: "Le format de l’avatar doit être au format {format}.",
            error_image_oversize: "La taille de l’avatar ne peut pas dépasser {size} MB.",
        },
        single_column_card: {
            label_nothing_below: "Rien de plus.",
        },
        guide_detail_list: {
            table_label_date: "Date",
            table_label_title: "Titre",
            button_link_to: "Lien vers",
        },
        no_register_dialog: {
            dialog_title: "Information",
            button_confirm: "Confirmer",
            button_cancel: "Annuler",
        },
        login_form: {
            form_title: "Application pour étudiants",
            input_placeholder_username: "Le nom d’utilisateur",
            input_placeholder_password: "Code",
            switch_remember_me: "Souvenez-vous de moi?",
            button_login: "Se connecter",
            button_no_account: "Vous n’avez pas de compte ?",
            button_previous: "Reculer",
            error_missing_username: "Veuillez entrer un nom d’utilisateur.",
            error_missing_password: "Veuillez entrer un mot de passe.",
            error_wrong_info: "Veuillez remplir les informations correctes.",
        },
        article_comment: {
            comments_title: "Commenter",
            input_placeholder_input: "Veuillez entrer",
            button_confirm: "Confirmer",
        },
        message_utils: {
            msg_title_error: "Erroné",
            msg_title_warning: "Admonestation",
            msg_title_info: "Information",
            msg_title_success: "Succès",
        },
        handle_user_api: {
            msg_no_login: "Veuillez d’abord vous connecter",
            msg_logout_success: "Déconnexion réussie",
        }
    },
    html:{
        no_register_dialog: {
            information:
                "<p>Désolé, cette application interne ne fournit pas de service d’auto-inscription</p>\n" +
                "<p>Veuillez consulter\n" +
                "<a class=\"link\" href=\"https://www.learningmall.cn/mod/resource/view.php?id=211163\" target=\"_blank\">" +
                "ce lien" +
                "</a>\n" +
                "pour obtenir la liste des comptes.\n" +
                "</p>\n" +
                "<p>Voici un exemple de format de compte :</p>\n" +
                "<table style=\"border-spacing: 10px\">\n" +
                "<tr>\n" +
                "<td>Le nom d’utilisateur:</td>\n" +
                "<td>zirui.zhou</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td>Code:</td>\n" +
                "<td>zirui.zhou</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<p>Cliquez sur le bouton « Confirmer » pour remplir le formulaire.</p>",
        },
    }
}

export default fr