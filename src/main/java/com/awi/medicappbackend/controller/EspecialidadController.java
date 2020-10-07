package com.awi.medicappbackend.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.awi.medicappbackend.exception.ModelNotFoundException;
import com.awi.medicappbackend.model.Especialidad;
import com.awi.medicappbackend.service.IEspecialidadService;
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
@RequestMapping("especialidades")
public class EspecialidadController {

  @Autowired
  private IEspecialidadService service;

  @GetMapping
  public ResponseEntity<List<Especialidad>> listar() throws Exception {
    return new ResponseEntity<>(service.listar(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Especialidad> listarPorId(@PathVariable("id") Integer id) throws Exception {

    Especialidad especialidad = service.listarPorId(id);

    if (especialidad == null) {
      throw new ModelNotFoundException("ID no encontrado " + id);
    }

    return new ResponseEntity<>(service.listarPorId(id), HttpStatus.OK);
  }

  @GetMapping("/hateoas/{id}")
  public EntityModel<Especialidad> listarPorIdHateoas(@PathVariable("id") Integer id) throws Exception {

    Especialidad especialidad = service.listarPorId(id);

    if (especialidad == null) {
      throw new ModelNotFoundException("ID no encontrado " + id);
    }

    EntityModel<Especialidad> recurso = EntityModel.of(especialidad);
    WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
    recurso.add(linkTo.withRel("especialidad-recurso"));
    return recurso;
  }

  @PostMapping
  public ResponseEntity<Void> registrar(@Valid @RequestBody Especialidad especialidad) throws Exception {

    Especialidad obj = service.registrar(especialidad);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdEspecialidad()).toUri();

    return ResponseEntity.created(location).build();
  }

  @PutMapping
  public ResponseEntity<Especialidad> modificar(@Valid @RequestBody Especialidad especialidad) throws Exception {
    return new ResponseEntity<>(service.modificar(especialidad), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {

    Especialidad especialidad = service.listarPorId(id);

    if (especialidad == null) {
      throw new ModelNotFoundException("ID no encontrado " + id);
    }

    service.eliminar(id);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
