package com.mrdevv.repository;

import com.mrdevv.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM MAE_USUARIOS WHERE email = :email AND password = :password", nativeQuery = true)
    Optional<Usuario> authUsuario(@Param("email") String email, @Param("password") String password);
}
