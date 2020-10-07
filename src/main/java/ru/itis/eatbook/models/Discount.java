package ru.itis.eatbook.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class Discount {
    private Long id;
    private Organization organization;
    private String title;
    private String info;
    private String image;
    private String date;
}
