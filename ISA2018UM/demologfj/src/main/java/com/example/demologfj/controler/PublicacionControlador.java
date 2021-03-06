package com.example.demologfj.controler;//package edu.com.isa.mbing.controlador;

import com.example.demologfj.entidad.Publicacion;
import com.example.demologfj.fachada.PublicacionFachada;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*import edu.com.isa.mbing.entidad.Publicacion;
import edu.com.isa.mbing.entidad.Publicador;
import edu.com.isa.mbing.fachada.PublicacionFachada;
*/

@RestController
@RequestMapping("/publicacion")
public class PublicacionControlador {

//private Logger logger = Logger.getLogger(String.valueOf(PublicacionControlador.class));
//private static Logger logger = (Logger) LogManager.getLogger();
//  private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
private static org.apache.logging.log4j.Logger logger = LogManager.getLogger(PublicacionControlador.class);
@Autowired
  private PublicacionFachada publicacionFachada;

  /*    http://localhost:8080/publicacion/publicarPublicacion/     */
  @PostMapping(value = "/publicarPublicacion", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Publicacion> publicarPublicacionControlador(@RequestBody Publicacion publicacion){
    logger.info("Ejecurando metodo publicarPublicacionControlador --OK!");
    Publicacion pub = new Publicacion();
    try {
      pub=publicacionFachada.publicarPublicacionFachada(publicacion);
    }catch (Exception e){
      logger.info("No se puede publicar desde publicarPublicacionControlador .. REVISAR!!!");
      return new ResponseEntity<Publicacion>(pub, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    logger.info("Publicación exitosa y retornando un nuevo publicador--- OK!");
    return new ResponseEntity<Publicacion>(pub,HttpStatus.OK);
  }
}
/*    http://localhost:8080/publicacion/republicar/1/4    */
  /* @GetMapping(value = "/republicarPublicacion/{idpublicador}/{idpublicacion}",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Integer > republicarPublicacionControlador(@PathVariable ("idpublicador") Integer idpublicador, @PathVariable ("idpublicacion") Integer idpublicacion){
    int salida = 0;
    Publicacion publicacion = new Publicacion();
    publicacion.setIdPublicacion(idpublicacion);

    Publicador publicador = new Publicador();
    publicador.setIdPublicador(idpublicador);
    try {
      salida = publicacionFachada.republicarPublicacionFachada(publicador, publicacion);
    }catch (Exception e) {
      new ResponseEntity< String >(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<Integer >(salida,HttpStatus.OK);
  }*/

/*    http://localhost:8080/publicacion/buscarPublicacionesPorPublicador/1    */
  /*@GetMapping(value = "/buscarPublicacionesPorPublicador/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
  public  ResponseEntity< List<Publicacion> > buscarPublicacionesPorPublicadorControlador(@PathVariable ("id") Integer id){

    List<Publicacion> publicaciones = new ArrayList<>();

    try {
      publicaciones = publicacionFachada.buscarPublicacionesPorPublicadorFachada(id);

    }catch (Exception e){

      new ResponseEntity< String >(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

    }
    return new  ResponseEntity< List<Publicacion> >(publicaciones,HttpStatus.OK);
  }*/

/*    http://localhost:8080/publicacion/buscarPublicacionesPorTag/rutean    */
  /*@GetMapping(value = "/buscarPublicacionesPorTag/{texto}",produces = MediaType.APPLICATION_JSON_VALUE)
  public  ResponseEntity< List<Publicacion> > buscarPublicacionesPorTagControlador(@PathVariable ("texto") String texto){

    List<Publicacion> publicaciones = new ArrayList<>();

    try {
      publicaciones = publicacionFachada.buscarPublicacionesPorTagFachada(texto);

    }catch (Exception e){

      new ResponseEntity< String >(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

    }
    return new  ResponseEntity< List<Publicacion> >(publicaciones,HttpStatus.OK);
  }*/


  /*@GetMapping(value = "/buscarPublicacionesPorMencion/{nombre}",produces = MediaType.APPLICATION_JSON_VALUE)
  public  ResponseEntity< List<Publicacion> > buscarPublicacionesPorMencionControlador(@PathVariable ("nombre") String nombre){

    List<Publicacion> publicaciones = new ArrayList<>();

    try {
      publicaciones = publicacionFachada.buscarPublicacionesPorMencionFachada(nombre);

    }catch (Exception e){

      new ResponseEntity< String >(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

    }
    return new  ResponseEntity< List<Publicacion> >(publicaciones,HttpStatus.OK);
  }

  @GetMapping(value = "/listarPublicaciones",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity< List<Publicacion> > listarPublicacionesControlador(){

    List<Publicacion> publicacions = new ArrayList<>();

    try {
      publicacions=publicacionFachada.listarPublicacionesFachada();

    }catch (Exception e)
    {
      new ResponseEntity< String >(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

    }
    return new ResponseEntity< List<Publicacion> >(publicacions,HttpStatus.OK);
  }

  @DeleteMapping(value = "/borrarPublicacion/{idPublicador}/{idPubliccion}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity< Integer > borrarPublicacionControlador(@PathVariable ("idPublicador") Integer idPublicador,@PathVariable ("idPubliccion") Integer idPubliccion){
    int resultado =0;
    try {
      publicacionFachada.borrarPublicacionFachada(idPublicador, idPubliccion);
      resultado=1;
    }catch (Exception e){
      resultado=0;
    }
    return new ResponseEntity< Integer>(resultado,HttpStatus.OK);
  }

  @GetMapping(value = "/listarPublicacionesQuestaSiguiendo/{idPublicador}",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity< List<Publicacion> > listarPublicacionesQuestaSiguiendoControlador(@PathVariable ("idPublicador") int idPublicador){
    List<Publicacion> publicaciones = new ArrayList<>();
    try {
      publicaciones=publicacionFachada.listarPublicacionesQuestaSiguiendoFachada(idPublicador);
    }catch (Exception e)
    {
      new ResponseEntity< String >(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity< List<Publicacion> >(publicaciones,HttpStatus.OK);
  }*//*    http://localhost:8080/publicacion/republicar/1/4    */
  /* @GetMapping(value = "/republicarPublicacion/{idpublicador}/{idpublicacion}",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Integer > republicarPublicacionControlador(@PathVariable ("idpublicador") Integer idpublicador, @PathVariable ("idpublicacion") Integer idpublicacion){
    int salida = 0;
    Publicacion publicacion = new Publicacion();
    publicacion.setIdPublicacion(idpublicacion);

    Publicador publicador = new Publicador();
    publicador.setIdPublicador(idpublicador);
    try {
      salida = publicacionFachada.republicarPublicacionFachada(publicador, publicacion);
    }catch (Exception e) {
      new ResponseEntity< String >(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<Integer >(salida,HttpStatus.OK);
  }*/

/*    http://localhost:8080/publicacion/buscarPublicacionesPorPublicador/1    */
  /*@GetMapping(value = "/buscarPublicacionesPorPublicador/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
  public  ResponseEntity< List<Publicacion> > buscarPublicacionesPorPublicadorControlador(@PathVariable ("id") Integer id){

    List<Publicacion> publicaciones = new ArrayList<>();

    try {
      publicaciones = publicacionFachada.buscarPublicacionesPorPublicadorFachada(id);

    }catch (Exception e){

      new ResponseEntity< String >(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

    }
    return new  ResponseEntity< List<Publicacion> >(publicaciones,HttpStatus.OK);
  }*/

/*    http://localhost:8080/publicacion/buscarPublicacionesPorTag/rutean    */
  /*@GetMapping(value = "/buscarPublicacionesPorTag/{texto}",produces = MediaType.APPLICATION_JSON_VALUE)
  public  ResponseEntity< List<Publicacion> > buscarPublicacionesPorTagControlador(@PathVariable ("texto") String texto){

    List<Publicacion> publicaciones = new ArrayList<>();

    try {
      publicaciones = publicacionFachada.buscarPublicacionesPorTagFachada(texto);

    }catch (Exception e){

      new ResponseEntity< String >(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

    }
    return new  ResponseEntity< List<Publicacion> >(publicaciones,HttpStatus.OK);
  }*/


  /*@GetMapping(value = "/buscarPublicacionesPorMencion/{nombre}",produces = MediaType.APPLICATION_JSON_VALUE)
  public  ResponseEntity< List<Publicacion> > buscarPublicacionesPorMencionControlador(@PathVariable ("nombre") String nombre){

    List<Publicacion> publicaciones = new ArrayList<>();

    try {
      publicaciones = publicacionFachada.buscarPublicacionesPorMencionFachada(nombre);

    }catch (Exception e){

      new ResponseEntity< String >(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

    }
    return new  ResponseEntity< List<Publicacion> >(publicaciones,HttpStatus.OK);
  }

  @GetMapping(value = "/listarPublicaciones",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity< List<Publicacion> > listarPublicacionesControlador(){

    List<Publicacion> publicacions = new ArrayList<>();

    try {
      publicacions=publicacionFachada.listarPublicacionesFachada();

    }catch (Exception e)
    {
      new ResponseEntity< String >(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

    }
    return new ResponseEntity< List<Publicacion> >(publicacions,HttpStatus.OK);
  }

  @DeleteMapping(value = "/borrarPublicacion/{idPublicador}/{idPubliccion}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity< Integer > borrarPublicacionControlador(@PathVariable ("idPublicador") Integer idPublicador,@PathVariable ("idPubliccion") Integer idPubliccion){
    int resultado =0;
    try {
      publicacionFachada.borrarPublicacionFachada(idPublicador, idPubliccion);
      resultado=1;
    }catch (Exception e){
      resultado=0;
    }
    return new ResponseEntity< Integer>(resultado,HttpStatus.OK);
  }

  @GetMapping(value = "/listarPublicacionesQuestaSiguiendo/{idPublicador}",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity< List<Publicacion> > listarPublicacionesQuestaSiguiendoControlador(@PathVariable ("idPublicador") int idPublicador){
    List<Publicacion> publicaciones = new ArrayList<>();
    try {
      publicaciones=publicacionFachada.listarPublicacionesQuestaSiguiendoFachada(idPublicador);
    }catch (Exception e)
    {
      new ResponseEntity< String >(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity< List<Publicacion> >(publicaciones,HttpStatus.OK);
  }*/
