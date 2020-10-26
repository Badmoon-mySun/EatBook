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
public class Review {
    private Long id;
    private User user;
    private Organization organization;
    private Date date;
    private String text;
}
