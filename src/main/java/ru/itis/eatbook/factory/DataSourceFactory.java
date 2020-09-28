package ru.itis.eatbook.factory;

import com.mysql.cj.jdbc.MysqlDataSource;
import sun.misc.ClassLoaderUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;


public class DataSourceFactory {

    public static DataSource getMySQLDataSource() {
        Properties props = new Properties();
        InputStream fis;
        MysqlDataSource mysqlDS = null;
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            fis = classLoader.getResourceAsStream("db.properties");
            props.load(fis);
            mysqlDS = new MysqlDataSource();
            mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
            mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
            mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
//            mysqlDS.setServerTimezone(props.getProperty("MYSQL_DB_TIMEZONE"));
            mysqlDS.setServerTimezone("UTC");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mysqlDS;
    }
}
