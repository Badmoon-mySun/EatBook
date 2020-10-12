package ru.itis.eatbook.listeners;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import ru.itis.eatbook.repositories.DiscountRepositoryJdbcImpl;
import ru.itis.eatbook.repositories.OrganizationRepositoryJdbcImpl;
import ru.itis.eatbook.repositories.ReviewRepositoryJdbcImpl;
import ru.itis.eatbook.repositories.interfaces.DiscountRepository;
import ru.itis.eatbook.repositories.interfaces.OrganizationRepository;
import ru.itis.eatbook.repositories.interfaces.ReviewRepository;
import ru.itis.eatbook.repositories.interfaces.UsersRepository;
import ru.itis.eatbook.repositories.UsersRepositoryJdbcImpl;
import ru.itis.eatbook.services.*;
import ru.itis.eatbook.services.interfaces.DiscountsService;
import ru.itis.eatbook.services.interfaces.OrganizationsService;
import ru.itis.eatbook.services.interfaces.ReviewsService;
import ru.itis.eatbook.services.interfaces.UsersService;

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
        Properties dbProperties = new Properties();
        Properties directoryProperties = new Properties();
        try {
            dbProperties.load(servletContext.getResourceAsStream("/WEB-INF/properties/db.properties"));
            directoryProperties.load(servletContext.getResourceAsStream("/WEB-INF/properties/dir.properties"));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        // upload properties
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(dbProperties.getProperty("MYSQL_DB_DRIVER_CLASS"));
        hikariConfig.setJdbcUrl(dbProperties.getProperty("MYSQL_DB_URL"));
        hikariConfig.setUsername(dbProperties.getProperty("MYSQL_DB_USERNAME"));
        hikariConfig.setPassword(dbProperties.getProperty("MYSQL_DB_PASSWORD"));
        hikariConfig.setMaximumPoolSize(Integer.parseInt(dbProperties.getProperty("MYSQL_DB_MAX_POOL_SIZE")));
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        //# Send to servlet context
        servletContext.setAttribute("dataSource", dataSource);

        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(dataSource);
        UsersService usersService = new UsersServiceImpl(usersRepository);

        servletContext.setAttribute("usersService", usersService);

        DiscountRepository discountRepository = new DiscountRepositoryJdbcImpl(dataSource);
        DiscountsService discountsService = new DiscountsServiceImpl(discountRepository);

        servletContext.setAttribute("discountsService", discountsService);

        OrganizationRepository organizationRepository = new OrganizationRepositoryJdbcImpl(dataSource);
        OrganizationsService organizationsService = new OrganizationServiceImpl(organizationRepository);

        servletContext.setAttribute("organizationsService", organizationsService);

        ReviewRepository reviewRepository =
                new ReviewRepositoryJdbcImpl(dataSource, organizationRepository, usersRepository);
        ReviewsService reviewsService = new ReviewsServiceImpl(reviewRepository);

        servletContext.setAttribute("reviewsService", reviewsService);

        servletContext.setAttribute("IMAGE_DIR", directoryProperties.getProperty("image_load_dir"));

        servletContext.setAttribute("fileService",  new FileServiceImpl());
    }
}
