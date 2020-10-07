package ru.itis.eatbook.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class Table {
    private Long id;
    private Organization organization;
    private User user;
    private Integer number;
    private Integer seats;
    private String dateOf;
    private String dateTo;
    private Integer prise;
}
