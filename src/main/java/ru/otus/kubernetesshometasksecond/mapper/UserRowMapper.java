package ru.otus.kubernetesshometasksecond.mapper;

import org.springframework.stereotype.Component;
import ru.otus.kubernetesshometasksecond.domain.User;
import ru.otus.kubernetesshometasksecond.dto.UserDto;

@Component
public class UserRowMapper {

    public UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }

    public User toEntity(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .userName(userDto.getUserName())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .phone(userDto.getPhone())
                .build();
    }
}
