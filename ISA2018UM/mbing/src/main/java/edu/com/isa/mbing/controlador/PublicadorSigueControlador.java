package edu.com.isa.mbing.controlador;

import edu.com.isa.mbing.entidad.Publicador;
import edu.com.isa.mbing.entidad.PublicadorSigue;
import edu.com.isa.mbing.fachada.PublicadorSigueFachada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/publicadorSigue")
public class PublicadorSigueControlador {

  @Autowired
  private PublicadorSigueFachada publicadorSigueFachada;

  /*    http://localhost:8080/publicadorSigue/seguirAotroPublicador/1/3   */
  @GetMapping(value = "/seguirAotroPublicador/{idpublicador}/{idsigue}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Integer> seguirAotroPublicadorControlador(@PathVariable("idpublicador") Integer idpublicador,@PathVariable ("idsigue")Integer idsigue){
    Publicador publicador = new Publicador();
    publicador.setIdPublicador(idpublicador);
    Publicador seguido = new Publicador();
    seguido.setIdPublicador(idsigue);
    int retornOperacion;
    try{
      retornOperacion = publicadorSigueFachada.seguirAotroPublicadorFachada(publicador,seguido);
    }catch (Exception e){
         retornOperacion=0;
    }
    return new ResponseEntity<Integer>(retornOperacion,HttpStatus.OK);
  }

  /*    http://localhost:8080/publicadorSigue/seguirPublicador    */
  @PostMapping(value = "/seguirPublicador", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PublicadorSigue> seguirPublicadorContralador(@RequestBody PublicadorSigue siguendo){
    PublicadorSigue publicadorSigue = new PublicadorSigue();
    try {
      publicadorSigue=publicadorSigueFachada.seguirPublicadorFachada(siguendo);
    }catch (Exception e){
      return new ResponseEntity<PublicadorSigue>(publicadorSigue, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<PublicadorSigue>(publicadorSigue,HttpStatus.OK);
  }

  /*    http://localhost:8080/publicadorSigue/listarPublicadoresQueMeSiguen/    */
  @GetMapping(value = "/listarPublicadoresQueMeSiguen",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity< List<PublicadorSigue> > listarPublicadoresQueMeSiguenControlador(){ //buscarSiguiendoPublicaciones
    int usuarioId=1;
    List<PublicadorSigue> publicadorSiguiendo = new ArrayList<>();
    try {
      publicadorSiguiendo = publicadorSigueFachada.listarPublicadoresQueMeSiguenFachada(usuarioId);
    }catch (Exception e)
    {
      new ResponseEntity< String >(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity< List<PublicadorSigue> >(publicadorSiguiendo,HttpStatus.OK);
  }

  /*    http://localhost:8080/publicadorSigue/dejarDeSeguirPublicador/1/4   */
  @DeleteMapping(value = "/dejarDeSeguirPublicador/{idPublicador}/{idseguido}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity< Integer > dejarDeSeguirPublicadorControlador (@PathVariable Integer idPublicador, @PathVariable Integer idseguido){
    int resultado =0;
    try {
      publicadorSigueFachada.dejarDeSeguirPublicadorFachada(idPublicador,idseguido);
      resultado=1;
    }catch (Exception e){
      resultado=0;
    }
    return new ResponseEntity<Integer>(resultado,HttpStatus.OK);
  }
}
