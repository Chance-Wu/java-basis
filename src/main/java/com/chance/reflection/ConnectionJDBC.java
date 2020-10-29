package com.chance.reflection;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @Description: 反射的经典应用——JDBC的数据库的连接
 * @Author: chance
 * @Date: 2020-10-29 09:15
 * @Version 1.0
 */
public class ConnectionJDBC {

    public static Properties getJdbcProperties() {
        Properties properties = new Properties();
        try {
            InputStream inputStream = ConnectionJDBC.class.getClass().getResourceAsStream("/jdbc.properties");
            BufferedInputStream in = new BufferedInputStream(inputStream);
            properties.load(in);
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
            return properties;
        }
    }

    public static void main(String[] args) {
        Properties properties = getJdbcProperties();
        String driverName = (String) properties.get("jdbc.driverName");
        String url = (String) properties.get("jdbc.url");
        String username = (String) properties.get("jdbc.username");
        String password = (String) properties.get("jdbc.password");
        try {
            // 通过反射加载数据库驱动程序
//            Class.forName(driverName);
            // 通过DriverManager类的静态方法getConnection来进行数据库的连接
            // JDBC4.0之后DriverManager初始化时会通过ServiceLoader类去注册驱动
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println(con);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
