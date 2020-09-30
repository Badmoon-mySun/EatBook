package ru.itis.eatbook.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class User {
    private Long id;
    private String name;
    private String avatar;
    private Integer age;
    private String email;
    private String phone;
    private String password;
    private Integer uuid;
}
