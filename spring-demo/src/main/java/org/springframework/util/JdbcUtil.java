package org.springframework.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author leellun
 * date: 2020-1-2 11:54
 * desc:
 **/
public class JdbcUtil {

    private static final String DRIVERCLASSNAME = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "leellun";
    private static final String PASSWORD = "liulun666";
    private static final String URL = "jdbc:mysql://localhost:3308/my_database?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
    private static Connection connection = null;

    /**
     * @author leellun
     * date: 2020-1-2 12:13
     * desc: 获取连接
     **/
    public static Statement statement(){

        try {
            // 加载驱动
            Class.forName(DRIVERCLASSNAME);
            // 获取连接
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Statement statement = connection.createStatement();
            return statement;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @author leellun
     * date: 2020-1-2 12:15
     * desc: 释放资源
     **/
    public void closeResouce(Connection connection,Statement statement,ResultSet resultSet){
        try {
            if(connection != null){
                connection.close();
            }
            if(statement != null){
                statement.close();
            }
            if(resultSet != null){
                resultSet.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
