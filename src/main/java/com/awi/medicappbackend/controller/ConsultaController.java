package com.awi.medicappbackend.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.awi.medicappbackend.dto.ConsultaListaExamenDTO;
import com.awi.medicappbackend.exception.ModelNotFoundException;
import com.awi.medicappbackend.model.Consulta;
import com.awi.medicappbackend.service.IConsultaService;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

  @Autowired
  private IConsultaService service;

  @GetMapping
  public ResponseEntity<List<Consulta>> listar() throws Exception {
    return new ResponseEntity<>(service.listar(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Consulta> listarPorId(@PathVariable("id") Integer id) throws Exception {

    Consulta consulta = service.listarPorId(id);

    if (consulta == null) {
      throw new ModelNotFoundException("ID no encontrado " + id);
    }

    return new ResponseEntity<>(service.listarPorId(id), HttpStatus.OK);
  }

  @GetMapping("/hateoas/{id}")
  public EntityModel<Consulta> listarPorIdHateoas(@PathVariable("id") Integer id) throws Exception {

    Consulta consulta = service.listarPorId(id);

    if (consulta == null) {
      throw new ModelNotFoundException("ID no encontrado " + id);
    }

    EntityModel<Consulta> recurso = EntityModel.of(consulta);
    WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
    recurso.add(linkTo.withRel("consulta-recurso"));
    return recurso;
  }

  @PostMapping
  public ResponseEntity<Void> registrar(@Valid @RequestBody ConsultaListaExamenDTO consultaDto) throws Exception {

    Consulta obj = service.registrarTransaccional(consultaDto);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdConsulta()).toUri();

    return ResponseEntity.created(location).build();
  }

  @PutMapping
  public ResponseEntity<Consulta> modificar(@Valid @RequestBody Consulta consulta) throws Exception {
    return new ResponseEntity<>(service.modificar(consulta), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {

    Consulta consulta = service.listarPorId(id);

    if (consulta == null) {
      throw new ModelNotFoundException("ID no encontrado " + id);
    }

    service.eliminar(id);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
