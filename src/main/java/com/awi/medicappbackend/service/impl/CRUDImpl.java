package com.awi.medicappbackend.service.impl;

import com.awi.medicappbackend.repository.IGenericRepo;
import com.awi.medicappbackend.service.ICRUD;
import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

  protected abstract IGenericRepo<T, ID> getRepo();

  @Override
  public T registrar(T t) throws Exception {
    return getRepo().save(t);
  }

  @Override
  public T modificar(T t) throws Exception {
    return getRepo().save(t);
  }

  @Override
  public List<T> listar() throws Exception {
    return getRepo().findAll();
  }

  @Override
  public T listarPorId(ID id) throws Exception {
    return getRepo().findById(id).orElse(null);
  }

  @Override
  public void eliminar(ID id) throws Exception {
    getRepo().deleteById(id);
  }
}
