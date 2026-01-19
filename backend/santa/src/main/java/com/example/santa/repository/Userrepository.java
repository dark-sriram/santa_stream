package com.example.santa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.example.santa.entity.UserEntity;

public interface  Userrepository extends  JpaRepository<UserEntity, Long>{
    Optional<UserEntity> findByEmail(String email);
}
