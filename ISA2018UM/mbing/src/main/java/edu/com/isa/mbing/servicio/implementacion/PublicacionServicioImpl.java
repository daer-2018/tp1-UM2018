package edu.com.isa.mbing.servicio.implementacion;

import edu.com.isa.mbing.entidad.*;
import edu.com.isa.mbing.modelo.IMencionDao;
import edu.com.isa.mbing.modelo.IPublicacionDao;
import edu.com.isa.mbing.modelo.IPublicadorSigueDao;
import edu.com.isa.mbing.modelo.ITagDao;
import edu.com.isa.mbing.servicio.interfacee.IPublicacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PublicacionServicioImpl implements IPublicacionServicio{

  @Autowired
  private IPublicacionDao publicacionDao;
  @Autowired
  private ITagDao tagDao;

  @Autowired
  private IMencionDao mencionDao;

  @Autowired
  private IPublicadorSigueDao publicadorSigueDao;

  @Override                                       // "publicación" trae un formulario desde un sitio "Ta_lleno"
  public Publicacion publicarPublicacionServicio(Publicacion publicacion) {

    List<Tag> tags = new ArrayList<>();
    List<Mencion> menciones = new ArrayList<>();

    String texto =publicacion.getCuerpo();
    texto=texto.replaceAll(","," "); // Reemplaza ',' por espacio
    String[] arreglo = texto.split(" ");  // romper cadena en cada espacio
    // Solo recorro too el arreglo en busca de @ o #
    for(String x: arreglo ){
      if(x.startsWith("@")){ // retorna booleano si cadena empieza con @
        x=x.substring(1,x.length()); // solo toma caracter  a partir del indice 1 en adelante, obvia el indice 0
        menciones.add(new Mencion(publicacion,x)); // Por acá, la lista de menciones
      }

      if(x.startsWith("#")){ // empieza con # v/f?
        x=x.substring(1,x.length());
        tags.add(new Tag(publicacion,x));// Por acá, la lista de tags
      }
    }
    publicacion.setTags(tags); // lista de tags que tiene la publicación
    publicacion.setMencions(menciones);// lista de menciones que tiene la publicación
    return publicacionDao.save(publicacion);
  }

  @Override
  public int republicarPublicacionServicio (Publicador publicador, Publicacion publicacion) {

    Publicacion publiCopia = new Publicacion(); // copia de la publicación (manejar referecnias a Tags y Menciones)
    Publicacion publiRepublicada = new Publicacion(); // Republicación

    try {
      publiCopia = publicacionDao.findOne(publicacion.getIdPublicacion()); // copio la orignal en publiCopia

      //Armando nueva publicación!!!
      publiRepublicada.setIdPublicacion(0); // JPA lo tma como nuevo
      publiRepublicada.setCuerpo(publiCopia.getCuerpo());
      publiRepublicada.setPublicador(publicador); // simula un insert -- cambia a publicador
      publiRepublicada.setFecha(LocalDate.now());
      //p2.setFecha(p.getFecha); // if Misma fecha

      // Direccionando Tags
      List<Tag> tagsCopias = tagDao.listarTagPorPublicacion(publicacion.getIdPublicacion());
      List<Tag> tagsRepublicados = new ArrayList<>(); //re_tag
      for(Tag t:tagsCopias){
        Tag tagRepublicado = new Tag();

        tagRepublicado.setPublicacion(publiRepublicada);// seteo idPublicacion donde está el tag  a otra nueva
        tagRepublicado.setTextoTag(t.getTextoTag()); // seteo textoTag a nuevo textoTag republicado
        tagsRepublicados.add(tagRepublicado); // Guardo cada Tag en la lista de Tags republicados
      }
      publiRepublicada.setTags(tagsRepublicados); // Seteo la republicacion con sus tags

    // Direccionando Menciones
      List<Mencion> mencions = mencionDao.listarMencionPorPublicacionDao(publicacion.getIdPublicacion());
      List<Mencion> remencions = new ArrayList<>(); // re_mención
      for(Mencion m: mencions){
        Mencion m1 = new Mencion();
        m1.setPublicacion(publiRepublicada);
        m1.setTextoMencion(m.getTextoMencion());
        remencions.add(m1);
      }
      publiRepublicada.setMencions(remencions);
      publicacionDao.save(publiRepublicada); // retorna ultimo id generado , 1 OK otros fail
    }catch (Exception e){
      System.out.println(e.getMessage());
    }
      return publiRepublicada.getIdPublicacion() > 0?1:0;
  }
  @Override
  public List<Publicacion> buscarPublicacionesPorPublicadorServicio(int idPublicador) {
    return publicacionDao.findPublicacionsByPublicador_IdPublicador(idPublicador);
  }

  public List<Publicacion> buscarPublicacionesPorTagServicio(String tag){
    return publicacionDao.buscarPublicacionesPorTagDao("#"+tag);  }

  @Override
  public List<Publicacion> buscarPublicacionesPorMencionServicio(String mencion) {
    return publicacionDao.buscarPublicacionesPorMencionDao("@"+mencion);
  }

  @Override
  public List<Publicacion> listarPublicacionesServicio() { //   Se coló!!!
    return publicacionDao.findAll();
  }
/////
  @Override
  public void borrarPublicacionServicio(int idPublicador, int idPublicacion) {
    Publicacion publicacion = new Publicacion();
    publicacion = publicacionDao.buscarParaBorrarPublicacionDao(idPublicador,idPublicacion);
    publicacionDao.delete (publicacion.getIdPublicacion());
  }

  // Buscar que publicaciones sigue este publicador, mostrar sus "todas" busco seguidos y luego sus publicaciones
  @Override
  public List<Publicacion> listarPublicacionesQuestaSiguiendoServicio(int idPublicador) {
    List<PublicadorSigue> publicadorSiguiendo = new ArrayList<>();
    publicadorSiguiendo  = publicadorSigueDao.ListarMisSeguidosDao(idPublicador); // acá están los seguidos
      // necesito sus pubicaciones
    List<Publicacion> publicacions = new ArrayList<>();

  for(PublicadorSigue p:publicadorSiguiendo){
     publicacions.add(publicacionDao.buscarPublicadorQueSigoDao(p.getSeguido().getIdPublicador()));
  }
    return publicacions;
  }

}
