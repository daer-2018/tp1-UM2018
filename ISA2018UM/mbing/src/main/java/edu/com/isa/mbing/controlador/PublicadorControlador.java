package edu.com.isa.mbing.controlador;

import edu.com.isa.mbing.entidad.Mencion;
import edu.com.isa.mbing.entidad.Publicacion;
import edu.com.isa.mbing.entidad.Publicador;
import edu.com.isa.mbing.fachada.PublicadorFachada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/publicador")
public class PublicadorControlador {

  @Autowired
  private PublicadorFachada publicadorFachada;

    /*    http://localhost:8080/publicador/registrarPublicador/   */
  @PostMapping(value = "/registrarPublicador", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity< Publicador > registrarPublicadorControlador(@RequestBody Publicador publicador){

    Publicador publicad = new Publicador();
    try {
      publicad=publicadorFachada.registrarPublicadorFachada(publicador);
    }catch (Exception e){
      return new ResponseEntity< Publicador >(publicad,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity< Publicador >(publicad,HttpStatus.OK);
  }

    /*    http://localhost:8080/publicador/listarPublicadores/    */
  @GetMapping(value = "/buscarPublicadores",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity< List<Publicador> > buscarPublicadoresControlador(){
    List<Publicador> publicadors = new ArrayList<>();
    try {
      publicadors=publicadorFachada.buscarPublicadoresFachada();
    }catch (Exception e)    {
      new ResponseEntity< String >(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity< List<Publicador> >(publicadors,HttpStatus.OK);
  }

  /*    http://localhost:8080/publicador/listarPublicador/4   */
  @GetMapping(value = "/listarPublicador/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity< Publicador > listarPublicadorPorIdControlador(@PathVariable ("id") Integer id){
    Publicador publicador = new Publicador();
    try {
      publicador=publicadorFachada.listarPublicadorPorIdFachada(id);
    }catch (Exception e)
    {
      new ResponseEntity< String >(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity< Publicador >(publicador,HttpStatus.OK);
  }

  /*    http://localhost:8080/publicador/actualizarDatosDePublicador    */
  @PutMapping(value = "/modificarDatosDePublicador", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity< Integer > modificarDatosDePublicadorControlador(@RequestBody Publicador publicador){
    int resultado =0;
    try {
      publicadorFachada. modificarDatosDePublicadorFachada(publicador);
      resultado=1;
    }catch (Exception e){
      resultado=0;
    }
    return new ResponseEntity< Integer>(resultado,HttpStatus.OK);
  }

  /*    http://localhost:8080/publicador/eliminarPublicador/6   */
  @DeleteMapping(value = "/eliminarPublicador/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity< Integer > eliminarPublicadorControlador(@PathVariable Integer id){
    int resultado =0;
    try {
      publicadorFachada.eliminarPublicadorFachada(id);
      resultado=1;
    }catch (Exception e){
      resultado=0;
    }
    return new ResponseEntity< Integer>(resultado,HttpStatus.OK);
  }

}
