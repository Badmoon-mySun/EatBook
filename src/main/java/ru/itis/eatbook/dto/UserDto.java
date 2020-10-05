package ru.itis.eatbook.dto;

import lombok.*;
import ru.itis.eatbook.models.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class UserDto {
    private String name;
    private String avatar;
    private Integer age;
    private String gender;
    private String email;
    private String phone;
    private String uuid;

    public static UserDto castToUserDto(User user) {
        return UserDto.builder()
                .name(user.getName())
                .avatar(user.getAvatar())
                .age(user.getAge())
                .gender(user.getGender())
                .email(user.getEmail())
                .phone(user.getPhone())
                .uuid(user.getUuid())
                .build();
    }
}
