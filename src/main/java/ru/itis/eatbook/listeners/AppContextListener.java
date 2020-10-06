package ru.itis.eatbook.listeners;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import ru.itis.eatbook.repositories.UsersRepository;
import ru.itis.eatbook.repositories.UsersRepositoryJdbcImpl;
import ru.itis.eatbook.services.FileServiceImpl;
import ru.itis.eatbook.services.HashingPasswordServiceImpl;
import ru.itis.eatbook.services.UsersService;
import ru.itis.eatbook.services.UsersServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.util.Properties;

@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        Properties properties = new Properties();
        try {
            properties.load(servletContext.getResourceAsStream("/WEB-INF/properties/db.properties"));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        // upload properties
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(properties.getProperty("MYSQL_DB_DRIVER_CLASS"));
        hikariConfig.setJdbcUrl(properties.getProperty("MYSQL_DB_URL"));
        hikariConfig.setUsername(properties.getProperty("MYSQL_DB_USERNAME"));
        hikariConfig.setPassword(properties.getProperty("MYSQL_DB_PASSWORD"));
        hikariConfig.setMaximumPoolSize(Integer.parseInt(properties.getProperty("MYSQL_DB_MAX_POOL_SIZE")));
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        //# Send to servlet context
        servletContext.setAttribute("dataSource", dataSource);

        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(dataSource);
        UsersService usersService = new UsersServiceImpl(usersRepository);

        servletContext.setAttribute("usersService", usersService);

        servletContext.setAttribute("hashingPassword", new HashingPasswordServiceImpl());

        // TODO
        servletContext.setAttribute("IMAGE_DIR", "C:\\dev\\Projects\\EatBook\\src\\main\\resources\\images");

        servletContext.setAttribute("fileService",  new FileServiceImpl());
    }
}
