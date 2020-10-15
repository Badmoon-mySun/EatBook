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
    private Integer number;
    private Integer seats;
    private Integer prise;
}
