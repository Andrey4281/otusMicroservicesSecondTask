package ru.otus.kubernetesshometasksecond.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.kubernetesshometasksecond.domain.User;
import ru.otus.kubernetesshometasksecond.dto.UserDto;
import ru.otus.kubernetesshometasksecond.exceptions.NotFoundUserException;
import ru.otus.kubernetesshometasksecond.mapper.UserRowMapper;
import ru.otus.kubernetesshometasksecond.repository.UserRepository;

@Transactional(readOnly = true)
@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserRowMapper userRowMapper;

    @Transactional(readOnly = false)
    public void insert(UserDto userDto) {
        User user = userRowMapper.toEntity(userDto);
        if (user.getId() != null) {
            throw new IllegalArgumentException("You shouldn't pass id for new user");
        }
        userRepository.save(user);
    }

    @Transactional(readOnly = false)
    public void update(UserDto userDto) {
        User user = userRowMapper.toEntity(userDto);
        userRepository.findById(user.getId()).ifPresentOrElse(u -> userRepository.save(user), () -> {
            throw new NotFoundUserException(String.format("User with id=%d not found in database for update", user.getId()));
        });
    }

    @Transactional(readOnly = true)
    public UserDto findById(Long id) {
        return userRepository.findById(id).map(userRowMapper::toDto)
                .orElseThrow(() -> new NotFoundUserException(String.format("Not found user for id=%d", id)));
    }

    @Transactional(readOnly = false)
    public void deleteById(Long id) {
        userRepository.findById(id).ifPresentOrElse(u -> userRepository.deleteById(u.getId()), () -> {
            throw new NotFoundUserException(String.format("User with id=%d not found in database for delete", id));
        });
    }

}
