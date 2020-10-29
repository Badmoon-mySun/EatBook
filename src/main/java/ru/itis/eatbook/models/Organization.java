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
@Table(name = "organization")
public class Organization {
    @Constraint(pk = true, notNull = true, autoInc = true)
    private Long id;
    private String name;
    private String type;
    private String address;
    private String image;
    private String description;
}