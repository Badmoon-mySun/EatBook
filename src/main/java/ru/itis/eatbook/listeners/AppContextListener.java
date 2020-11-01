package ru.itis.eatbook.listeners;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import ru.itis.eatbook.repositories.*;
import ru.itis.eatbook.repositories.interfaces.*;
import ru.itis.eatbook.services.*;
import ru.itis.eatbook.services.interfaces.*;
import ru.itis.eatbook.utils.DBCreator;

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

//        DBCreator.create(dataSource);

        //# Send to servlet context
        servletContext.setAttribute("dataSource", dataSource);

        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(dataSource);
        UsersService usersService = new UsersServiceImpl(usersRepository);

        servletContext.setAttribute("usersService", usersService);

        OrganizationRepository organizationRepository = new OrganizationRepositoryJdbcImpl(dataSource);
        OrganizationsService organizationsService = new OrganizationServiceImpl(organizationRepository);

        servletContext.setAttribute("organizationsService", organizationsService);

        DiscountRepository discountRepository = new DiscountRepositoryJdbcImpl(dataSource, organizationRepository);
        DiscountsService discountsService = new DiscountsServiceImpl(discountRepository);

        servletContext.setAttribute("discountsService", discountsService);

        ReviewRepository reviewRepository =
                new ReviewRepositoryJdbcImpl(dataSource, organizationRepository, usersRepository);
        ReviewsService reviewsService = new ReviewsServiceImpl(reviewRepository);

        servletContext.setAttribute("reviewsService", reviewsService);

        TableRepository tableRepository = new TableRepositoryJdbcImpl(dataSource, organizationRepository);
        TablesService tablesService = new TablesServiceImpl(tableRepository);

        servletContext.setAttribute("tablesService", tablesService);

        OrderTableRepository orderTableRepository =
                new OrderTableRepositoryJdbcImpl(dataSource, tableRepository, usersRepository);
        OrderTablesService orderTablesService = new OrderTablesServiceImpl(orderTableRepository);

        servletContext.setAttribute("orderTablesService", orderTablesService);

        servletContext.setAttribute("IMAGE_DIR", directoryProperties.getProperty("image_load_dir"));

        servletContext.setAttribute("fileService",  new FileServiceImpl());

        servletContext.setAttribute("dateService", new DateServiceImpl());
    }
}
