package com.awi.medicappbackend.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.awi.medicappbackend.exception.ModelNotFoundException;
import com.awi.medicappbackend.model.Medico;
import com.awi.medicappbackend.service.IMedicoService;
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
@RequestMapping("medicos")
public class MedicoController {

  @Autowired
  private IMedicoService service;

  @GetMapping
  public ResponseEntity<List<Medico>> listar() throws Exception {
    return new ResponseEntity<>(service.listar(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Medico> listarPorId(@PathVariable("id") Integer id) throws Exception {

    Medico medico = service.listarPorId(id);

    if (medico == null) {
      throw new ModelNotFoundException("ID no encontrado " + id);
    }

    return new ResponseEntity<>(service.listarPorId(id), HttpStatus.OK);
  }

  @GetMapping("/hateoas/{id}")
  public EntityModel<Medico> listarPorIdHateoas(@PathVariable("id") Integer id) throws Exception {

    Medico medico = service.listarPorId(id);

    if (medico == null) {
      throw new ModelNotFoundException("ID no encontrado " + id);
    }

    EntityModel<Medico> recurso = EntityModel.of(medico);
    WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
    recurso.add(linkTo.withRel("medico-recurso"));
    return recurso;
  }

  @PostMapping
  public ResponseEntity<Void> registrar(@Valid @RequestBody Medico medico) throws Exception {

    Medico obj = service.registrar(medico);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdMedico()).toUri();

    return ResponseEntity.created(location).build();
  }

  @PutMapping
  public ResponseEntity<Medico> modificar(@Valid @RequestBody Medico medico) throws Exception {
    return new ResponseEntity<>(service.modificar(medico), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {

    Medico medico = service.listarPorId(id);

    if (medico == null) {
      throw new ModelNotFoundException("ID no encontrado " + id);
    }

    service.eliminar(id);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
