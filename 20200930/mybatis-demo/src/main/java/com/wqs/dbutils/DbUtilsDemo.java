package com.wqs.dbutils;

import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DbUtilsDemo {
    public static void main(String[] args) throws SQLException {
        /*1、导入jar包
        <dependency>
            <groupId>commons-dbutils</groupId>
            <artifactId>commons-dbutils</artifactId>
            <version>1.7</version>
        </dependency>
        */

        //2、使用DbUtils提供的QueryRunner类
        HikariUtil.init();
        System.out.println(BlogDao.findBlogList());
    }
}
