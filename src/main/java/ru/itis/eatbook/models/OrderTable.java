package ru.itis.eatbook.models;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class OrderTable {
    private Long id;
    private Table table;
    private User user;
    private Date dateOf;
    private Date dateTo;
    private Integer prise;
}
