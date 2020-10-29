package ru.itis.eatbook.models;

import lombok.*;
import ru.itis.eatbook.annotation.Constraint;
import ru.itis.eatbook.annotation.ManyToOne;
import ru.itis.eatbook.annotation.Table;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
@Table(name = "review")
public class Review {
    @Constraint(pk = true, notNull = true, autoInc = true)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Organization organization;
    private Date date;
    private String text;
}
