package com.awi.medicappbackend.service.impl;

import com.awi.medicappbackend.model.Medico;
import com.awi.medicappbackend.repository.IGenericRepo;
import com.awi.medicappbackend.repository.IMedicoRepo;
import com.awi.medicappbackend.service.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoServiceImpl extends CRUDImpl<Medico, Integer> implements IMedicoService {

  @Autowired
  private IMedicoRepo repository;

  @Override
  protected IGenericRepo<Medico, Integer> getRepo() {
    return repository;
  }
}
