package com.epam.kubernetes.data.repository;

import com.epam.kubernetes.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByFirstName(String FirstName);
    List<UserEntity> findAll();
}
