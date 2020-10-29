package ru.itis.eatbook.models;

import lombok.*;
import ru.itis.eatbook.annotation.Constraint;
import ru.itis.eatbook.annotation.ManyToOne;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
@ru.itis.eatbook.annotation.Table(name = "ordertable")
public class OrderTable {
    @Constraint(pk = true, notNull = true, autoInc = true)
    private Long id;
    @ManyToOne
    private Table table;
    @ManyToOne
    private User user;
    private Date dateOf;
    private Date dateTo;
    private Integer prise;
}