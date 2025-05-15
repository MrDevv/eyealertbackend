package com.mrdevv.repository;

import com.mrdevv.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RolRepository extends JpaRepository<Rol, Long> {

    @Query(value = "SELECT * FROM mae_roles WHERE descripcion = 'usuario'", nativeQuery = true)
    Rol findIdRolUsuario();

}
