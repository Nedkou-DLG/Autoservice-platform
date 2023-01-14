package com.nedyalkoboydev.autoserviceplatform.persistence.repositories;

import com.nedyalkoboydev.autoserviceplatform.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
