package com.spring.schedule_develop.repository;

import com.spring.schedule_develop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface UserRepository extends JpaRepository<User, Long> {
    default User findByIdOrElseThrow(Long userId) {
        return findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + userId));
    }
}
