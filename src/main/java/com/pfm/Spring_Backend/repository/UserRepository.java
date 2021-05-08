package com.pfm.Spring_Backend.repository;

import com.pfm.Spring_Backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}