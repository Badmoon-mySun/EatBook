package ru.itis.eatbook.models;

import lombok.*;
import ru.itis.eatbook.annotation.Constraint;
import ru.itis.eatbook.annotation.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
@ru.itis.eatbook.annotation.Table(name = "`table`")
public class Table {
    @Constraint(pk = true, notNull = true, autoInc = true)
    private Long id;
    @ManyToOne
    private Organization organization;
    private Integer number;
    private Integer seats;
    private Integer prise;
}
