package com.awi.medicappbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "paciente")
public class Paciente {

  @Id
  @Column(name = "idPaciente")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idPaciente;

  @Size(min = 3, message = "Nombres debe tener mínimo 3 caracteres")
  @Column(name = "nombres", nullable = false, length = 70)
  private String nombres;

  @Size(min = 3, message = "Apellidos debe tener mínimo 3 caracteres")
  @Column(name = "apellidos", nullable = false, length = 70)
  private String apellidos;

  @Size(min = 8, max = 8, message = "DNI debe contener 8 caracteres")
  @Column(name = "dni", nullable = false, length = 8)
  private String dni;

  @Size(min = 3, max = 150, message = "Direccion debe tener minimo 3 caracteres")
  @Column(name = "direccion", nullable = false, length = 150)
  private String direccion;

  @Size(min = 9, max = 9, message = "Teléfono debe tener 9 caracteres")
  @Column(name = "telefono", length = 9)
  private String telefono;

  @Email
  @Column(name = "email", length = 70)
  private String email;
}
