package com.mrdevv.repository;

import com.mrdevv.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM mae_usuarios WHERE email = :email AND password = :password", nativeQuery = true)
    Optional<Usuario> authUsuario(@Param("email") String email, @Param("password") String password);

    @Modifying
    @Query(value = "UPDATE mae_usuarios SET CUESTIONARIO_CONOCIMIENTOS_COMPLETADO = 1 WHERE usuario_id = :usuario_id", nativeQuery = true)
    void updateEstadoCuestionarioCompletado(@Param("usuario_id") Long usuarioId);

    @Modifying
    @Query(value = "UPDATE mae_usuarios SET PASSWORD = :new_password WHERE usuario_id = :usuario_id", nativeQuery = true)
    void updatePassword(@Param("new_password") String password, @Param("usuario_id") Long usuarioId);

    Optional<Usuario> findByEmail(String email);

    boolean existsByEmail(String email);
}
