package ru.itis.eatbook.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
}
