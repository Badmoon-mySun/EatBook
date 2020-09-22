package ru.itis.eatbook.model;

import lombok.Data;

@Data
public class User {
    public static final String TABLE_NAME = "user";
    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "username";
    public static final String PASSWORD_COLUMN = "warehouse_id";

    private Long id;
    private String username;
    private String password;
}
