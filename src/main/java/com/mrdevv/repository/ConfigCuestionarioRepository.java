package com.mrdevv.repository;

import com.mrdevv.model.ConfigCuestionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigCuestionarioRepository extends JpaRepository<ConfigCuestionario, Long> {

    ConfigCuestionario findFirstByOrderByIdAsc();

}
