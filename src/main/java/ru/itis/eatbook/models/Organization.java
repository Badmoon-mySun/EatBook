package ru.itis.eatbook.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Organization {
    private Long id;
    private String name;
    private String type;
    private String address;
    private String image;
    private String info;
}
