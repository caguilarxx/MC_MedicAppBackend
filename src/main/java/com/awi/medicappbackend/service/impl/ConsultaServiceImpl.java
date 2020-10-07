package com.awi.medicappbackend.service.impl;

import com.awi.medicappbackend.dto.ConsultaListaExamenDTO;
import com.awi.medicappbackend.model.Consulta;
import com.awi.medicappbackend.repository.IConsultaExamenRepo;
import com.awi.medicappbackend.repository.IConsultaRepo;
import com.awi.medicappbackend.repository.IGenericRepo;
import com.awi.medicappbackend.service.IConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConsultaServiceImpl extends CRUDImpl<Consulta, Integer> implements IConsultaService {

  @Autowired
  private IConsultaRepo repository;

  @Autowired
  private IConsultaExamenRepo iConsultaExamenRepo;

  @Override
  protected IGenericRepo<Consulta, Integer> getRepo() {
    return repository;
  }

  @Transactional
  @Override
  public Consulta registrarTransaccional(ConsultaListaExamenDTO dto) throws Exception {

    dto.getConsulta().getDetalleConsultaList().forEach(detalleConsulta -> detalleConsulta.setConsulta(dto.getConsulta()));
    repository.save(dto.getConsulta());

    dto.getLstExamen().forEach(examen -> iConsultaExamenRepo.registrar(dto.getConsulta().getIdConsulta(), examen.getIdExamen()));

    return dto.getConsulta();
  }
}
