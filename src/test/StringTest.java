package test;

import java.util.Arrays;

public class StringTest {

    public static void main(String[] args) {
        /*String str1 = "hello"; //str1指向静态区
        String str2 = new String("hello");  //str2指向堆上的对象
        String str3 = "hello";
        String str4 = new String("hello");
        System.out.println(str1.equals(str2)); //true
        System.out.println(str2.equals(str4)); //true
        System.out.println(str1 == str3); //true
        System.out.println(str1 == str2); //false
        System.out.println(str2 == str4); //false
        System.out.println(str2 == "hello"); //false
        str2 = str1;
        System.out.println(str2 == "hello"); //true
        byte[] bytes = str3.getBytes();
        System.out.println(Arrays.toString(bytes));*/
        String createTableSql = "CREATE TABLE `user` (\n" +
                "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',\n" +
                "  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,\n" +
                "  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,\n" +
                "  `nick_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户昵称-用户显示',\n" +
                "  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT '' COMMENT '用户手机号码',\n" +
                "  `email` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,\n" +
                "  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态：可用:1，不可用:0，冻结:-1，过期:-2',\n" +
                "  `modify_user_id` bigint(20) DEFAULT NULL,\n" +
                "  `create_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '账号创建人员',\n" +
                "  `gmt_freeze_end` datetime DEFAULT NULL COMMENT '冻结结束时间',\n" +
                "  `effective_start_time` datetime DEFAULT NULL COMMENT '账号有效的开始时间(可以为null)',\n" +
                "  `effective_end_time` datetime DEFAULT NULL COMMENT '账号有效的结束时间(可以为null)',\n" +
                "  `last_login_time` datetime DEFAULT NULL COMMENT '账号最后登陆时间(可以为null)',\n" +
                "  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',\n" +
                "  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',\n" +
                "  `extro_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '其他信息',\n" +
                "  `auto_distribution` int(1) NOT NULL DEFAULT '0',\n" +
                "  `last_modify_password_time` datetime DEFAULT NULL COMMENT '最后一次修改密码时间',\n" +
                "  `login_times` tinyint(1) DEFAULT '0' COMMENT '当天登录次数',\n" +
                "  `password_error_times` tinyint(1) DEFAULT '0' COMMENT '当天密码错误次数',\n" +
                "  `current_dept_id` bigint(20) DEFAULT NULL COMMENT '用户当前所在部门',\n" +
                "  PRIMARY KEY (`id`) USING BTREE,\n" +
                "  UNIQUE KEY `un_user_name` (`user_name`) USING BTREE COMMENT '用户名唯一'\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=345 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='用户表'";
        int firstLeftBracket = createTableSql.indexOf("(");
        int fistRightBracket = createTableSql.lastIndexOf(")");
        createTableSql = createTableSql.substring(firstLeftBracket + 1, fistRightBracket);
        String[] lines = createTableSql.split("\n");
        StringBuilder sql = new StringBuilder();
        // 第一行为空，不考虑
        for (int i = 1; i < lines.length; i++) {
            String trimLine = lines[i].trim();
            String fieldName = trimLine.substring(0, trimLine.indexOf(" "));
            // 去除两个引号
            fieldName = fieldName.substring(1, fieldName.length() - 1);
            //if (notExist.contains(fieldName)) {
            // 需要添加到增加字段的SQL
            sql.append(" ADD ").append(lines[i]).append("\n");
            //}
        }
        // 如果最后一个符号为逗号，处理最后一个逗号，改为句号
        if (sql.charAt(sql.length() - 1) == ',') {
            sql.replace(sql.lastIndexOf(","), sql.lastIndexOf(","), ";");
        } else {
            sql.deleteCharAt(sql.length() - 1);
            sql.append(';');
        }
        System.out.println(sql.toString());
    }

}
