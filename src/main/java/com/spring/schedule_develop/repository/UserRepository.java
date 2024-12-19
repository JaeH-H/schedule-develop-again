package com.spring.schedule_develop.repository;

import com.spring.schedule_develop.dto.UserRequestDto;
import com.spring.schedule_develop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


//
//    Optional<User> findBy(String email, String password);

    default User findByIdOrElseThrow(Long userId) {
        return findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + userId));
    }

    User findByEmail(String email);

}
