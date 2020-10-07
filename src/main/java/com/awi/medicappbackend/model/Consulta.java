package com.awi.medicappbackend.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "consulta")
public class Consulta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idConsulta;

  @ManyToOne //FK
  @JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_paciente"))
  private Paciente paciente;

  @ManyToOne //FK
  @JoinColumn(name = "id_medico", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_medico"))
  private Medico medico;

  @ManyToOne //FK
  @JoinColumn(name = "id_especialidad", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_especialidad"))
  private Especialidad especialidad;

  @Column(name = "num_consultorio", length = 3, nullable = false)
  private String numConsultorio;

  @Column(name = "fecha", nullable = false)
  private LocalDateTime fecha;

  @OneToMany(mappedBy = "consulta", cascade = {CascadeType.ALL}, orphanRemoval = true)
  private List<DetalleConsulta> detalleConsultaList;
}
