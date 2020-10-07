package com.awi.medicappbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "medico")
public class Medico {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idMedico;

  @Column(name = "nombres", nullable = false, length = 70)
  private String nombres;

  @Column(name = "apellidos", nullable = false, length = 70)
  private String apellidos;

  @Column(name = "CMP", nullable = false, length = 12)
  private String CMP;

  @Column(name = "foto_url")
  private String fotoUrl;
}
