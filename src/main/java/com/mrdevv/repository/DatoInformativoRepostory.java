package com.mrdevv.repository;

import com.mrdevv.model.DatoInformativo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatoInformativoRepostory extends JpaRepository<DatoInformativo, Long> {

    @Query(value = "SELECT * FROM mae_datos_informativos ORDER BY RAND() LIMIT :size", nativeQuery = true)
    List<DatoInformativo> findTopRandom(@Param("size") Integer size);

    @Query(value = "SELECT * FROM mae_datos_informativos ORDER BY RAND() LIMIT 1", nativeQuery = true)
    DatoInformativo findDatoInformativoRandom();

    @Query(value = "SELECT * FROM mae_datos_informativos ORDER BY dato_informativo_id DESC", nativeQuery = true)
    Page<DatoInformativo> findAllDatosInformativos(Pageable pageable);

}
