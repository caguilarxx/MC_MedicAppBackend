package com.awi.medicappbackend.service.impl;

import com.awi.medicappbackend.model.Especialidad;
import com.awi.medicappbackend.repository.IEspecialidadRepo;
import com.awi.medicappbackend.repository.IGenericRepo;
import com.awi.medicappbackend.service.IEspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspecialidadServiceImpl extends CRUDImpl<Especialidad, Integer> implements IEspecialidadService {

  @Autowired
  private IEspecialidadRepo repository;

  @Override
  protected IGenericRepo<Especialidad, Integer> getRepo() {
    return repository;
  }
}
