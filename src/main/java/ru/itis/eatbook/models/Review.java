package ru.itis.eatbook.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class Review {
    private Long id;
    private User user;
    private Organization organization;
    private String date;
    private String text;
}
