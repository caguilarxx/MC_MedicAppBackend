package com.awi.medicappbackend.service.impl;

import com.awi.medicappbackend.model.Examen;
import com.awi.medicappbackend.repository.IExamenRepo;
import com.awi.medicappbackend.repository.IGenericRepo;
import com.awi.medicappbackend.service.IExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamenServiceImpl extends CRUDImpl<Examen, Integer> implements IExamenService {

  @Autowired
  private IExamenRepo repository;

  @Override
  protected IGenericRepo<Examen, Integer> getRepo() {
    return repository;
  }
}
