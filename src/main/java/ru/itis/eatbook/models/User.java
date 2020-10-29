package ru.itis.eatbook.models;

import lombok.*;
import ru.itis.eatbook.annotation.Constraint;
import ru.itis.eatbook.annotation.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
@Table(name = "user")
public class User {
    @Constraint(pk = true, notNull = true, autoInc = true)
    private Long id;
    private String name;
    private String avatar;
    private Integer age;
    private String gender;
    @Constraint(notNull = true, unic = true)
    private String email;
    private String phone;
    private String password;
    @Constraint(notNull = true, unic = true)
    private String uuid;
}
