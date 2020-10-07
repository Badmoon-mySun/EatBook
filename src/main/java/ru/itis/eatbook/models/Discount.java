package ru.itis.eatbook.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Discount {
    private Long id;
    private Organization organization;
    private String info;
    private String date;
}
