package com.awi.medicappbackend.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ConsultaExamenPK implements Serializable {


  @ManyToOne
  @JoinColumn(name = "id_consulta", nullable = false)
  private Consulta consulta;

  @ManyToOne
  @JoinColumn(name = "id_examen", nullable = false)
  private Examen examen;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsultaExamenPK that = (ConsultaExamenPK) o;
    return Objects.equals(consulta, that.consulta) &&
        Objects.equals(examen, that.examen);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consulta, examen);
  }
}
