package com.coding.module1introduction.repositories;

import com.coding.module1introduction.dto.UserDTO;
import com.coding.module1introduction.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
}
