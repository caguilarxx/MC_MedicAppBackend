package com.awi.medicappbackend.service.impl;

import com.awi.medicappbackend.model.Paciente;
import com.awi.medicappbackend.repository.IGenericRepo;
import com.awi.medicappbackend.repository.IPacienteRepo;
import com.awi.medicappbackend.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl extends CRUDImpl<Paciente, Integer> implements IPacienteService {

  @Autowired
  private IPacienteRepo repository;

  @Override
  protected IGenericRepo<Paciente, Integer> getRepo() {
    return repository;
  }
}
