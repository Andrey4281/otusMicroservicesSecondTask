package ru.otus.kubernetesshometasksecond.web.rest.user;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.kubernetesshometasksecond.dto.UserDto;
import ru.otus.kubernetesshometasksecond.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping(value = "users/new")
    public ResponseEntity<Void> insert(@RequestBody UserDto userDto) {
        userService.insert(userDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "users/update")
    public ResponseEntity<Void> update(@RequestBody UserDto userDto) {
        userService.update(userDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "users/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @DeleteMapping(value = "users/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
