package com.dhk.expensetrackerapi.user.repository;

import com.dhk.expensetrackerapi.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
