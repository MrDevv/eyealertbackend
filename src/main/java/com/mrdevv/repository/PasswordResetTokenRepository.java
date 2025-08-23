package com.mrdevv.repository;

import com.mrdevv.model.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {

    @Query(name = "select * from password_reset_token where token = :token", nativeQuery = true)
    Optional<PasswordResetToken> findByToken(@Param(value = "token") String token);
}
