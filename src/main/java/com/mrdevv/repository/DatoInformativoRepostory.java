package com.mrdevv.repository;

import com.mrdevv.model.DatoInformativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatoInformativoRepostory extends JpaRepository<DatoInformativo, Long> {

    @Query(value = "SELECT * FROM mae_datos_informativos ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<DatoInformativo> findTop3Random();

    @Query(value = "SELECT * FROM mae_datos_informativos ORDER BY RAND() LIMIT 1", nativeQuery = true)
    DatoInformativo findDatoInformativoRandom();

    @Query(value = "SELECT * FROM mae_datos_informativos ORDER BY dato_informativo_id DESC", nativeQuery = true)
    List<DatoInformativo> findAllDatosInformativos();

}
