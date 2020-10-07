package com.awi.medicappbackend.repository;

import com.awi.medicappbackend.model.ConsultaExamen;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IConsultaExamenRepo extends IGenericRepo<ConsultaExamen, Integer> {

  //  @Transactional
  @Modifying
  @Query(value = "INSERT INTO consulta_examen(id_consulta, id_examen) VALUES (:idConsulta, :idExamen)", nativeQuery = true)
  Integer registrar(@Param("idConsulta") Integer idConsulta, @Param("idExamen") Integer idExamen);
}
