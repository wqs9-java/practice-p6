package com.wqs.dbutils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.BeanMapHandler;

import java.sql.SQLException;
import java.util.List;

public class BlogDao {
    private static QueryRunner queryRunner;
    static  {
        queryRunner = HikariUtil.getQueryRunner();
    }

    public static List<Blog> findBlogList() throws SQLException {
        String sql = "select id, name, authorId from blog";
        List<Blog> list = queryRunner.query(sql, new BeanListHandler<Blog>(Blog.class));
        // Language Level 设置成 Java 8
        list.forEach(System.out::println);
        return list;
    }
}
