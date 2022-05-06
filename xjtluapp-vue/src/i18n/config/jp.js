const zh = {
    language: "日本語",
    message: {
        top_menu: {
            menu_item_student: "学生",
            menu_item_home: "ホームページ",
            menu_item_guide: "ガイド",
            menu_item_module: "課程",
            input_placeholder_input: "入力してください",
            input_missing_word_msg: "検索キーワードを入力してください"
        },
        setting_box: {
            box_title: "設定",
            item_change_dark_mode: "ナイトモードを変更する",
            item_change_password: "パスワードを変更する",
            item_logout: "ログアウト",
            item_language: "言語：",
        },
        change_password_box: {
            box_title: "パスワードの変更",
            label_old_pass: "以前のパスワード",
            label_new_pass: "新しいパスワード",
            label_confirm_pass: "パスワードの認証",
            button_submit: "送信",
            button_reset: "リセット",
            msg_missing_old_pass: "以前のパスワードを入力してください",
            msg_missing_new_pass: "新しいパスワードを入力してください",
            msg_same_new_pass: "別のパスワードを入力してください",
            msg_missing_check_pass: "新しいパスワードをもう一度入力してください",
            msg_different_check_pass: "2つのパスワードが一致しません",
        },
        avatar_with_card: {
            userinfo_label_colon: "：",
            userinfo_label_id: "学生証",
            userinfo_label_major: "専攻",
            userinfo_label_grade: "学年",
            button_logout: "ログアウト",
            label_no_login: "最初にログインしてください",
        },
        student_page: {
            tab_item_mine: "私の",
            tab_item_history: "履歴",
            tab_item_favourite: "お気に入り",
        },
        search_page: {
            label_search_result: "{word} の検索結果は次のとおりです："
        },
        userinfo_form: {
            userinfo_label_name: "名前",
            userinfo_label_major: "専攻",
            userinfo_label_id: "学生証",
            userinfo_label_grade: "学年",
        },
        upload_image: {
            error_image_wrong_format: "アバター形式は　{format}　形式である必要があります。",
            error_image_oversize: "アバターのサイズは {size}MB を超えることはできません。",
        },
        single_column_card: {
            label_nothing_below: "これ以上のコンテンツはありません。",
        },
        guide_detail_list: {
            table_label_date: "日にち",
            table_label_title: "タイトル",
            button_link_to: "リンク",
        },
        no_register_dialog: {
            dialog_title: "情報",
            button_confirm: "確認",
            button_cancel: "取消",
        },
        login_form: {
            form_title: "学生アプリ",
            input_placeholder_username: "ユーザー名",
            input_placeholder_password: "パスワード",
            switch_remember_me: "パスワードを覚える？",
            button_login: "ログイン",
            button_no_account: "アカウントがありませんか？",
            button_previous: "后退",
            error_missing_username: "ユーザー名を入力してください",
            error_missing_password: "パスワードを入力してください",
            error_wrong_info: "正しい情報を入力してください。",
        },
        article_comment: {
            comments_title: "コメント",
            input_placeholder_input: "入ってください",
            button_confirm: "確認",
        },
        message_utils: {
            msg_title_error: "エラー",
            msg_title_warning: "警告",
            msg_title_info: "情報",
            msg_title_success: "成功",
        },
        handle_user_api: {
            msg_no_login: "最初にログインしてください",
            msg_logout_success: "ログアウトに成功しました",
        }
    },
    html:{
        no_register_dialog: {
            information:
                "<p>申し訳ありませんが、この内部アプリケーションは自己登録サービスを提供していません</p>\n" +
                "<p>" +
                    "アカウントのリストについては、\n" +
                    "<a class=\"link\" href=\"https://www.learningmall.cn/mod/resource/view.php?id=211163\" target=\"_blank\">" +
                        "このリンク" +
                    "</a>\n" +
                    "にアクセスしてください\n" +
                "</p>\n" +
                "<p>アカウント形式の例を次に示します：</p>\n" +
                "<table style=\"border-spacing: 10px\">\n" +
                    "<tr>\n" +
                        "<td>ユーザー名：</td>\n" +
                        "<td>zirui.zhou</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                        "<td>パスワード：</td>\n" +
                        "<td>zirui.zhou</td>\n" +
                    "</tr>\n" +
                "</table>\n" +
                "<p>「確認」ボタンをクリックしてフォームに記入してください</p>",
        },
    }
}

export default zh