// Contributed by Qianchao Sun

const es = {
    language: "Español",
    message: {
        top_menu: {
            menu_item_student: "Estudiante",
            menu_item_home: "Página de Inicio",
            menu_item_guide: "Guía",
            menu_item_module: "Curso",
            input_placeholder_input: "Por favor, introduzca",
            input_missing_word_msg: "Introduzca la palabra clave de búsqueda."
        },
        setting_box: {
            box_title: "Opciónes",
            item_change_dark_mode: "Cambiar el modo oscuro",
            item_change_password: "Cambiar la contraseña",
            item_logout: "Cerrar sesión",
            item_language: "Idioma: ",
        },
        change_password_box: {
            box_title: "Cambiar la contraseña",
            label_old_pass: "Contraseña anterior",
            label_new_pass: "Nueva contraseña",
            label_confirm_pass: "Confirmar contraseña",
            button_submit: "Subir",
            button_reset: "Restablecer",
            msg_missing_old_pass: "Por favor, introduzca la contraseña anterior",
            msg_missing_new_pass: "Por favor, introduzca la nueva contraseña",
            msg_same_new_pass: "Por favor, introduzca una contraseña diferente",
            msg_missing_check_pass: "Por favor, introduzca la nueva contraseña otra vez",
            msg_different_check_pass: "Dos contraseñas no coinciden.",
        },
        avatar_with_card: {
            userinfo_label_colon: ": ",
            userinfo_label_id: "ID",
            userinfo_label_major: "Carrera",
            userinfo_label_grade: "Grado",
            button_logout: "Cerrar sesión",
            label_no_login: "Por favor, inicie sesión primero",
        },
        student_page: {
            tab_item_mine: "mi",
            tab_item_history: "Historia",
            tab_item_favourite: "Favorito",
        },
        search_page: {
            label_search_result: "Resultado de la búsqueda de {word}:"
        },
        userinfo_form: {
            userinfo_label_name: "Nombre",
            userinfo_label_major: "Carrera",
            userinfo_label_id: "ID",
            userinfo_label_grade: "Grado",
        },
        upload_image: {
            error_image_wrong_format: "La imagen del avatar debe tener el formato {format}.",
            error_image_oversize: "El tamaño de la imagen del avatar no puede superar los {size} MB.",
        },
        single_column_card: {
            label_nothing_below: "No hay nada abajo. ......",
        },
        guide_detail_list: {
            table_label_date: "Fecha",
            table_label_title: "Título",
            button_link_to: "Enlace a"
        },
        no_register_dialog: {
            dialog_title: "Información",
            button_confirm: "Confirmar",
            button_cancel: "Cancelar",
        },
        login_form: {
            form_title: "Aplicación de estudiante",
            input_placeholder_username: "Nombre de usuario",
            input_placeholder_password: "Contraseña",
            switch_remember_me: "¿Me acuerda?",
            button_login: "Iniciar",
            button_no_account: "¿No tiene cuenta?",
            button_previous: "Volver",
            error_missing_username: "Introduzca su nombre de usuario",
            error_missing_password: "Introduzca su contraseña",
            error_wrong_info: "Por favor, introduzca la información correcta.",
        },
        article_comment: {
            comments_title: "Comentario",
            input_placeholder_input: "Por favor, introduzca",
            button_confirm: "Confirmar",
        },
        message_utils: {
            msg_title_error: "Error",
            msg_title_warning: "Advertencia",
            msg_title_info: "Información",
            msg_title_success: "Éxito",
        },
        handle_user_api: {
            msg_no_login: "Por favor, inicie sesión primero",
            msg_logout_success: "Cierre de sesión con éxito",
        }
    },
    html:{
        no_register_dialog: {
            information:
                "<p>Lo siento, la aplicación interna no permite el auto registro.</p>\n" +
                "<p>" +
                    "Visite\n" +
                    "<a class=\"link\" href=\"https://www.learningmall.cn/mod/resource/view.php?id=211163\" target=\"_blank\">" +
                        "este enlace" +
                    "</a>\n" +
                    "para adquirir la lista de cuentas.\n" +
                "</p>\n" +
                "<p>Aquí tiene un ejemplo del formato de la cuenta.</p>\n" +
                "<table style=\"border-spacing: 10px\">\n" +
                    "<tr>\n" +
                        "<td>Nombre de usuario:</td>\n" +
                        "<td>zirui.zhou</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                        "<td>Contraseña:</td>\n" +
                        "<td>zirui.zhou</td>\n" +
                    "</tr>\n" +
                "</table>\n" +
                "<p>Pulse el botón \"Confirmar\" para rellenar.</p>",
        },
    }
}

export default es