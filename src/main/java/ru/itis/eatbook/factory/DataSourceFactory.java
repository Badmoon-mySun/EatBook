package ru.itis.eatbook.factory;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;


public class DataSourceFactory {

    public static DataSource getMySQLDataSource() throws SQLException {
        Properties props = new Properties();
        FileInputStream fis;
        MysqlDataSource mysqlDS = null;
        try {
            fis = new FileInputStream("C:\\dev\\Projects\\EatBook\\src\\main\\resources\\db.properties");
            props.load(fis);
            mysqlDS = new MysqlDataSource();
            mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
            mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
            mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
            mysqlDS.setServerTimezone("UTC");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mysqlDS;
    }

}
