package ru.itis.eatbook.models;

import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Review {
    private Long id;
    private User user;
    private Organization organization;
    private String date;
    private String text;
}
