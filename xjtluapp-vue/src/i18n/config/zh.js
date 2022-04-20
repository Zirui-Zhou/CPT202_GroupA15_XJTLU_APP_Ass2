const zh = {
    language: "简体中文",
    message:{
        top_menu: {
            menu_item_student: "学生",
            menu_item_home: "主页",
            menu_item_guide: "指南",
            menu_item_module: "课程",
            input_placeholder_input: "请输入",
            input_missing_word_msg: "请输入搜索关键词。"
        },
        setting_box: {
            box_title: "设置",
            item_change_dark_mode: "更换夜间模式",
            item_change_password: "更改密码",
            item_logout: "登出",
            item_language: "语言：",
        },
        change_password_box: {
            box_title: "更改密码",
            label_old_pass: "旧密码",
            label_new_pass: "新密码",
            label_confirm_pass: "确认密码",
            button_submit: "提交",
            button_reset: "重置",
            msg_missing_old_pass: "请输入旧密码",
            msg_missing_new_pass: "请输入新密码",
            msg_same_new_pass: "请输入不同的密码",
            msg_missing_check_pass: "请再次输入新密码",
            msg_different_check_pass: "两个新密码不符",
        },
        avatar_with_card: {
            userinfo_label_colon: "：",
            userinfo_label_id: "学号",
            userinfo_label_major: "专业",
            userinfo_label_grade: "年级",
            button_logout: "登出",
            label_no_login: "请先登录",
        },
        student_page: {
            tab_item_mine: "我的",
            tab_item_history: "历史",
            tab_item_favourite: "最爱",
        },
        search_page: {
            label_search_result: "{word} 的搜索结果为："
        },
        userinfo_form: {
            userinfo_label_name: "姓名",
            userinfo_label_major: "专业",
            userinfo_label_id: "学号",
            userinfo_label_grade: "年级",
        },
        upload_image: {
            error_image_wrong_format: "头像格式必须为 {format} 格式。",
            error_image_oversize: "头像大小不能超过{size}MB。",
        },
        single_column_card: {
            label_nothing_below: "没有更多内容了……",
        },
        guide_detail_list: {
            table_label_date: "日期",
            table_label_title: "标题",
            button_link_to: "前往",
        },
        no_register_dialog: {
            dialog_title: "信息",
            button_confirm: "确认",
            button_cancel: "取消",
        },
        login_form: {
            form_title: "学生应用",
            input_placeholder_username: "用户名",
            input_placeholder_password: "密码",
            switch_remember_me: "记住我？",
            button_login: "登录",
            button_no_account: "没有账号？",
            button_previous: "后退",
            error_missing_username: "请输入用户名",
            error_missing_password: "请输入密码",
            error_wrong_info: "请填写正确的信息。",
        },
        article_comment: {
            comments_title: "评论",
            input_placeholder_input: "请输入",
            button_confirm: "确认",
        },
        message_utils: {
            msg_title_error: "错误",
            msg_title_warning: "警告",
            msg_title_info: "信息",
            msg_title_success: "成功",
        },
        handle_user_api: {
            msg_no_login: "请先登录",
            msg_logout_success: "登出成功",
        }
    },
    html:{
        no_register_dialog: {
            information:
                "<p>对不起，本内部应用不提供自主注册服务</p>\n" +
                "<p>请前往\n" +
                "<a class=\"link\" href=\"https://www.learningmall.cn/mod/resource/view.php?id=211163\" target=\"_blank\">" +
                "这个链接" +
                "</a>\n" +
                "来获取账户列表\n" +
                "</p>\n" +
                "<p>这里提供一个账户格式的例子：</p>\n" +
                "<table style=\"border-spacing: 10px\">\n" +
                "<tr>\n" +
                "<td>用户名：</td>\n" +
                "<td>zirui.zhou</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td>密码：</td>\n" +
                "<td>zirui.zhou</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<p>点击“确认”按钮来填写表单</p>",
        },
    }
}

export default zh