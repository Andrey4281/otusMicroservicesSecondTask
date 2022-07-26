package ru.otus.kubernetesshometasksecond.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.kubernetesshometasksecond.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
