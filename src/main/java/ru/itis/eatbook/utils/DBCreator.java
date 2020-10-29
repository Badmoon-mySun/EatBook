package ru.itis.eatbook.utils;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import ru.itis.eatbook.annotation.Table;
import ru.itis.eatbook.caster.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Stream;

public class DBCreator {

    private static ArrayList<Castable> castables = new ArrayList<Castable>(){
        {add(new IntegerCaster());}
        {add(new StringCaster());}
        {add(new ManyToOneCaster());}
        {add(new DateCaster());}
        {add(new LongCaster());}
    };

    public static void create(DataSource dataSource) {
        Reflections reflections = new Reflections(
                "ru.itis.eatbook.models",
                new TypeAnnotationsScanner(),
                new SubTypesScanner()
        );

        Set<Class<?>> entities = reflections.getTypesAnnotatedWith(Table.class);
        entities.forEach(aClass -> {
            StringBuilder sql = new StringBuilder();

            sql.append("CREATE TABLE IF NOT EXISTS " + SqlUtils.recognizeTableName(aClass) + " (");

            Stream.of(aClass.getDeclaredFields())
                    .forEach(field -> {
                        sql.append(castables.stream()
                                .filter(castable -> castable.isSupport(field))
                                .map(castable -> castable.cast(field))
                                .findFirst()
                                .orElse("")).append(", ")
                       ;

                    });

            String finalSql = sql.substring(0, sql.length() - 2) + ");";

            System.out.println(finalSql);

            try (Connection connection = dataSource.getConnection()) {
                connection.prepareCall(finalSql).execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
