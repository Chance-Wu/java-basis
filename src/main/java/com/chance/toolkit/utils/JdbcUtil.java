package com.chance.toolkit.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * @Description: JdbcUtil
 * @Author: chance
 * @Date: 4/6/21 9:36 PM
 * @Version 1.0
 */
public class JdbcUtil {

    public final static Logger logger = LoggerFactory.getLogger(JdbcUtil.class);


    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            // 创建连接
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test",
                    "root",
                    "539976");

            // 创建Statement
            statement = connection.createStatement();

            // CRUD
            ResultSet resultSet = statement.executeQuery("select * from user");

            //
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                System.out.println(username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            try {
                if (null != statement) {
                    statement.close();
                }
            } catch (SQLException e) {
                logger.info("异常：{}", e.getMessage());
            } finally {
                try {
                    if (null != connection) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    logger.info("异常：{}", e.getMessage());
                }
            }
        }
    }
}
