package com.awi.medicappbackend.service;

import com.awi.medicappbackend.dto.ConsultaListaExamenDTO;
import com.awi.medicappbackend.model.Consulta;

public interface IConsultaService extends ICRUD<Consulta, Integer> {

  Consulta registrarTransaccional(ConsultaListaExamenDTO consulta) throws Exception;
}
