package com.wqs.jdbc;

import java.sql.*;

/**
 * 原始JDBC连接数据库的方式:
 *
 * 1、重复代码：如果项目比较复杂，表比较多，各种数据库操作多，那么代码就会很重复了。
 * 2、资源管理：这里需要手动关闭资源，如果有时没写，就可能导致数据库连接枯竭
 * 3、结果集处理：而且对于结果集的处理，必须要指明字段属性的类型来一个个处理
 * 4、SQL耦合：处理业务逻辑 和 处理数据的代码是耦合在一起的。
 *
 * 这些问题怎么解决呢？写一个工具类，将重复的代码和资源给封装起来，传SQL即可。
 * Apache在2003年就发布了一个Commons DbUtils的工具类，可简化数据库操作。
 * 下面请看DbUtilsDemo
 */
public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //0、在pom.xml中引入MySQL驱动的依赖

        //对于本地mybatis库的标blog
        //1、注册DBC驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2、打开连接
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3066/mybatis?useUnicode=true&amp;characterEncoding=utf8",
                "root", "123456");

        //3、创建一个Statement对象
        Statement statement = connection.createStatement();

        //4、执行查询
        String SQL = "SELECT id, name, author_id from blog";
        ResultSet resultSet = statement.executeQuery(SQL);

        //5、结果解析为POJO对象的属性
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int id = resultSet.getInt("id");
            System.out.println("id: " + id + ", name: " + name);
        }

        //6、关闭数据库连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
