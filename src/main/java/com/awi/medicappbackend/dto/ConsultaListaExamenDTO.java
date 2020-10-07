package com.awi.medicappbackend.dto;

import com.awi.medicappbackend.model.Consulta;
import com.awi.medicappbackend.model.Examen;
import java.util.List;
import lombok.Data;

@Data
public class ConsultaListaExamenDTO {

  private Consulta consulta;
  private List<Examen> lstExamen;
}