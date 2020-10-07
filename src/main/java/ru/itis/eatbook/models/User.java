package ru.itis.eatbook.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class User {
    private Long id;
    private String name;
    private String avatar;
    private Integer age;
    private String gender;
    private String email;
    private String phone;
    private String password;
    private String uuid;
}
