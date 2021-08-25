package com.demo.sharding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTablesUtil {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*
         *  导入时将下面stat.executeUpdate(sql)全部打开
         */
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/demo?characterEncoding=utf8&rewriteBatchedStatements=true&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true";
        Connection conn = DriverManager.getConnection(url, "root", "123456");
        Statement stat = conn.createStatement();
        //创建表
        for (int i = 0; i <= 31; i++) {
            String sql = "CREATE TABLE `student_info_" + i + "` (" +
                "  `id` bigint unsigned NOT NULL ," +
                "  `class_id` int NOT NULL COMMENT '班级id'," +
                "  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称'," +
                "  `class_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '班级名称'," +
                "  `age` int DEFAULT NULL COMMENT '年龄'," +
                "  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP," +
                "  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP," +
                "  `deleted` tinyint(1) NOT NULL DEFAULT '0'," +
                "  PRIMARY KEY (`id`) USING BTREE," +
                "  KEY `idx_class_id` (`class_id`) USING BTREE," +
                "  KEY `idx_name` (`name`) USING BTREE" +
                ") ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='学生信息表'";
            System.out.println(sql);
            stat.executeUpdate(sql);
        }
        stat.close();
        conn.close();
    }
}
